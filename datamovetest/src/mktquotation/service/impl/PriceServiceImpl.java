/**
 * 
 */
package com.huatai.cube.rms.modules.mktquotation.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huatai.cube.rms.core.IBussinessService;
import com.huatai.cube.rms.core.aop.annotation.MsgType;
import com.huatai.cube.rms.modules.mktquotation.dao.HisPriceModelMapper;
import com.huatai.cube.rms.modules.mktquotation.dao.LivePriceModelMapper;
import com.huatai.cube.rms.modules.mktquotation.model.HisPriceModel;
import com.huatai.cube.rms.modules.mktquotation.model.HisPriceModelExample;
import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModel;
import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModelExample;
import com.huatai.cube.rms.modules.mktquotation.service.IPriceService;
import com.huatai.cube.rms.util.CommonUtils;
import com.huatai.cube.rms.util.define.CubeRiskXValues;
import com.huatai.cube.rms.util.define.UValues;
import com.huatai.cube.server.common.utils.CubeXFields;
import com.huatai.xtrade.xstep.app.field.XFields;
import com.huatai.xtrade.xstep.app.value.XValues;
import com.huatai.xtrade.xstep.event.IXStepEvent;
import com.huatai.xtrade.xstep.event.XStepEvent;

/**
 * @author 006562
 *
 */
@Service
public class PriceServiceImpl implements IPriceService,IBussinessService {
	
	@Resource(name="hisPriceModelMapper")
	HisPriceModelMapper hisPriceModelMapper;
	
	@Resource(name="livePriceModelMapper")
	LivePriceModelMapper livePriceModelMapper;

	private final static Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class); 
	@Override
	@MsgType(request = CubeRiskXValues.MsgType.queryPriceRequest , response = CubeRiskXValues.MsgType.queryPriceResponse)
	public IXStepEvent queryPriceDetails(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(CubeRiskXValues.MsgType.queryPriceResponse);
		response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.RuntimeError);
		try {
			request.setCurrentRow(0);
			int pageNo = 1;
			if (request.hasField(XFields.System.pageNo)) {
				pageNo = request.getInt(XFields.System.pageNo);
				response.setInt(XFields.System.pageNo, pageNo);
			}else{
				response.setInt(XFields.System.pageNo, 0);
			}
			LivePriceModelExample liveExample = new LivePriceModelExample();
			LivePriceModelExample.Criteria criteriaLive =  liveExample.createCriteria();
			HisPriceModelExample hisExample = new HisPriceModelExample();
			HisPriceModelExample.Criteria criteriaHis =  hisExample.createCriteria();
			if (request.hasField(CubeXFields.Common.underlying)) {
				String[] underlyingString = request.getString(CubeXFields.Common.underlying).split(",");
				List<String> underlyinglist = new ArrayList<String>();
				for(int i = 0 ; i < underlyingString.length ; i ++){
					underlyinglist.add(underlyingString[i]);
				}
				criteriaLive.andUnderlyingIn(underlyinglist);
				criteriaHis.andUnderlyingIn(underlyinglist);
			}
			if (request.hasField(CubeXFields.Common.currency)) {
				String[] currencyString = request.getString(CubeXFields.Common.currency).split(",");
				List<String> currencylist = new ArrayList<String>();
				for(int i = 0 ; i < currencyString.length ; i ++){
					currencylist.add(currencyString[i]);
				}
				criteriaLive.andCurrencyIn(currencylist);
				criteriaHis.andCurrencyIn(currencylist);
			}
			if (request.hasField(CubeXFields.Common.exchangeCode)) {
				String[] exchangecodeString = request.getString(CubeXFields.Common.exchangeCode).split(",");
				List<String> exchangecodelist = new ArrayList<String>();
				for(int i = 0 ; i < exchangecodeString.length ; i ++){
					exchangecodelist.add(exchangecodeString[i]);
				}
				criteriaLive.andExchangecodeIn(exchangecodelist);
				criteriaHis.andExchangecodeIn(exchangecodelist);
			}
			Date startDate = CommonUtils.dateconvertString(request.getString(CubeXFields.Common.startDate));
			Date endDate = CommonUtils.dateconvertString(request.getString(CubeXFields.Common.endDate));
			criteriaLive.andNowdateBetween(startDate, endDate);
			criteriaHis.andHisdateBetween(startDate, endDate);
			List<LivePriceModel> priceModels = livePriceModelMapper.selectByExample(liveExample);
			List<HisPriceModel> hisPriceModels = hisPriceModelMapper.selectByExample(hisExample);
			int pageSize = request.getInt(XFields.System.pageSize);
			List<Object> models = new ArrayList<>();
			models.addAll(priceModels);
			models.addAll(hisPriceModels);
			response.setInt(XFields.System.pageSize, pageSize);
			response.setLong(XFields.System.totalSize, models.size());
			int account = 0;
			for(int i = pageSize*(pageNo -1); i < Math.min(pageSize * pageNo, models.size());i++){
				response.addRowAndSetCurrent();
				if (models.get(i) instanceof LivePriceModel) {
					LivePriceModel model = (LivePriceModel) models.get(i);
					CommonUtils.awesomeModelToIXStepEvent(model, response);
					response.setInt(CubeXFields.Common.isDefault, 0);
				} else {
					HisPriceModel model = (HisPriceModel) models.get(i);
					CommonUtils.awesomeModelToIXStepEvent(model, response);
					response.setInt(CubeXFields.Common.isDefault, 1);
				}
				account ++;
			}
			response.setCurrentRow(0);
			response.setInt(XFields.System.subGroupNumber, account);
			response.setInt(XFields.System.requestExeStatus, XValues.RequestExeStatus.success);
			response.resetIndex();
			return response;
			
		} catch (Exception e) {
			logger.error("Query price Error", e);
			response.setString(XFields.System.textDescription, e.getMessage());
			return response;
		}
	}
	
}
