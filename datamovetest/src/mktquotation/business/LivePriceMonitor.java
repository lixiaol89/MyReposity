package com.huatai.cube.rms.modules.mktquotation.business;

import com.htsc.mdc.query.service.QueryRealTimeDataService;
import com.huatai.cube.api.ICubeMonitorService;
import com.huatai.cube.rms.modules.mktquotation.Help.TimeDataServiceHelper;
import com.huatai.cube.rms.modules.mktquotation.dao.LivePriceModelMapper;
import com.huatai.xtrade.xstep.app.field.XFields;
import com.huatai.xtrade.xstep.event.IXStepEvent;
import com.huatai.xtrade.xstep.event.XStepEvent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.github.pagehelper.PageHelper.startPage;

/**
 * Created by 012737 on 2018/2/7.
 */
@Aspect
@Component //通过配置文件声明这个bean了
public class LivePriceMonitor {
    private final static Logger logger = LoggerFactory.getLogger(LivePriceMonitor.class);

    @Autowired
    ICubeMonitorService cubeMonitorService;

    @Pointcut("execution(* com.huatai.cube.rms.modules.mktquotation.business.LivePriceHandler.makePrice(..))")
    public void makePrice() {
    }

    @Around("makePrice()")
    public void aroundMakePrice(ProceedingJoinPoint jp) {
        //before proceed
        logger.debug("-----切面行情检查 开始-----");
        IXStepEvent response = null;
        try{
            IXStepEvent request = new XStepEvent();
            request.setType("240915");
            request.addRowAndSetCurrent();
            response = cubeMonitorService.execServices(request);
        }
        catch (Exception e)
        {
            logger.error("beforeAOP监控服务cubeMonitorService调用出错：", e);
        }
        finally {
            try {
                jp.proceed();//执行被 切面 包裹的 函数
            } catch (Throwable e) {
                logger.error("makePrice()或aroundMakePrice()运行中出错：", e);
                //告警
                String errorString = e.toString();
                String alarmContent = "检查行情时出现错误。\n" + errorString.substring(0, errorString.length() > 200 ? 200 : errorString.length());
                cubeMonitorService.cubeSendAlarmEvent(4, "Cube行情告警", alarmContent);
                logger.debug("-----切面行情检查 结束-----");
            }

            //after proceed
            if (response!=null && response.hasField(XFields.System.clientMesssageID)) {
                try {
                    IXStepEvent request = new XStepEvent("240917");
                    request.setString(XFields.System.clientMesssageID,response.getString(XFields.System.clientMesssageID));
                    response = cubeMonitorService.execServices(request);
                } catch (Exception e) {
                    logger.error("afterAOP监控服务cubeMonitorService调用出错：", e);
                }
            }
            logger.debug("-----切面行情检查 结束-----");
        }
    }

}
