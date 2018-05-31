/**
 * 
 */
package com.huatai.cube.rms.modules.mktquotation.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huatai.cube.rms.modules.mktquotation.Help.TimeDataServiceHelper;
import com.huatai.cube.rms.modules.mktquotation.dao.LivePriceModelMapper;
import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModel;
import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModelExample;
import com.huatai.cube.rms.modules.parameter.dao.UnderlyingModelMapper;
import com.huatai.cube.rms.modules.parameter.model.UnderlyingModel;

/**
 * @author 006562
 *
 */
@Service
public class LivePriceHandler {

	private final static Logger logger = LoggerFactory.getLogger(LivePriceHandler.class);

	@Resource(name="underlyingModelMapper")
	UnderlyingModelMapper underlyingModelMapper;
	@Resource(name="livePriceModelMapper")
	LivePriceModelMapper livePriceModelMapper;
	
	@Autowired
	TimeDataServiceHelper timeDataServiceHelper;
	
    public void makePrice(){  
    	Date date = new Date();
    	List<UnderlyingModel> underlyinglist = underlyingModelMapper.selectAll();
    	List<String> exchangeList = new ArrayList<String>();//指数、外汇、期货
    	exchangeList.add("SH");
    	exchangeList.add("SZ");
    	exchangeList.add("HK");
    	exchangeList.add("SHF");
    	exchangeList.add("CFFEX");
    	exchangeList.add("CZCE");
    	exchangeList.add("DCE");
    	exchangeList.add("MORN");
    	exchangeList.add("FX");
    	//为了不让某一个行情的异常影响到其他行情的更新，在循环更新时出现Exception的时候，将其先存起来，更新完成后统一处理（或只处理第一条。）
		boolean isError = false;
    	String errorMsg = "下列标的，更新行情出错：";
    	for(UnderlyingModel model: underlyinglist ){
    		try {
				LivePriceModel priceModel = new LivePriceModel();
				LivePriceModelExample priceModelExample = new LivePriceModelExample();
				priceModelExample.or().andUnderlyingEqualTo(model.getUnderlying()).andExchangecodeEqualTo(model.getExchangecode());
				List<LivePriceModel> Result = livePriceModelMapper.selectByExample(priceModelExample);
				if (exchangeList.contains(model.getExchangecode())) {
					priceModel = timeDataServiceHelper.getTimeData(model);
					priceModel.setNowdate(date);
					if (0 == Result.size()) {
						livePriceModelMapper.insert(priceModel);
					} else {
						priceModel.setId(Result.get(0).getId());
						livePriceModelMapper.updateByPrimaryKeySelective(priceModel);
					}
				} else {
					if (1 == Result.size()) {
						Result.get(0).setNowdate(date);
						livePriceModelMapper.updateByPrimaryKeySelective(Result.get(0));
					}
				}
			}
			catch (Exception e)
			{
				isError = true;
				logger.info("更新"+model.getUnderlying()+"时出错：",e);
				errorMsg += model.getUnderlying() + "; ";
			}
    	}

    	if(isError){
    		throw new RuntimeException(errorMsg);
		}
    } 
    
}
