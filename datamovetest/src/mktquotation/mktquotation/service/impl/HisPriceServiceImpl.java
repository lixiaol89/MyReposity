/**
 * 
 */
package com.huatai.cube.rms.modules.mktquotation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.huatai.cube.rms.core.IBussinessService;
import com.huatai.cube.rms.core.aop.annotation.MsgType;
import com.huatai.cube.rms.exception.CubeRiskServiceException;
import com.huatai.cube.rms.modules.mktquotation.dao.HisPriceModelMapper;
import com.huatai.cube.rms.modules.mktquotation.model.HisPriceModel;
import com.huatai.cube.rms.modules.mktquotation.model.HisPriceModelExample;
import com.huatai.cube.rms.modules.mktquotation.service.IHisPriceService;
import com.huatai.cube.rms.util.CommonUtils;
import com.huatai.cube.rms.util.define.CubeRiskXValues;
import com.huatai.cube.rms.util.define.UValues;
import com.huatai.cube.server.common.utils.CubeLibrary;
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
public class HisPriceServiceImpl implements IHisPriceService, IBussinessService {
private final static Logger logger = LoggerFactory.getLogger(HisPriceServiceImpl.class); 
	
	@Resource(name="hisPriceModelMapper")
	HisPriceModelMapper hisPriceModelMapper;
	
	@Override
	@MsgType(request = CubeRiskXValues.MsgType.dealHisPriceRequest , response = CubeRiskXValues.MsgType.dealHisPriceResponse)
	public IXStepEvent dealHisPriceDetails(IXStepEvent request) {
		IXStepEvent response = new XStepEvent( CubeRiskXValues.MsgType.dealHisPriceResponse);
		response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.RuntimeError);
		try {
			int AddSuccessNumber = 0;
			int UpdateSuccessNumber = 0;
			int DeleteSuccessNumber = 0;
			request.setCurrentRow(0);
			if(!request.hasField(CubeXFields.Common.lastUpdateUser)){
				response.setString(XFields.System.textDescription, "参数类型设置不正确, 最后更新用户名(lastUpdateUserName)不能为空");
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
				return response;
			}
			if(!request.hasField(XFields.System.subGroupNumber)){
				response.setString(XFields.System.textDescription, "参数类型设置不正确, 分组记录数目subGroupNumber不能为空");
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
				return response;
			}
			
			int requestSize = request.getInt(XFields.System.subGroupNumber);
			
			if(requestSize <= 0){
				response.setString(XFields.System.textDescription, "参数设置不正确, 分组记录数目subGroupNumber需大于0");
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
				response.resetIndex();
				return response;
			}
			List<String> failRequestID = new ArrayList<>();
			List<String> textDescription = new ArrayList<>();
			for(int i = 0; i < requestSize; i++){
				request.setCurrentRow(i + 1);
				HisPriceModel model = new HisPriceModel();
				if(request.hasField(CubeXFields.Common.underlying)){
					model.setUnderlying(request.getString(CubeXFields.Common.underlying));
				}
				if(request.hasField(CubeXFields.Common.currency)){
					model.setCurrency(request.getString(CubeXFields.Common.currency));
				}
				if(request.hasField(CubeXFields.Common.exchangeCode)){
					model.setExchangecode(request.getString(CubeXFields.Common.exchangeCode));
				}
				if(request.hasField(CubeXFields.Common.stopFlag)){
					model.setStopflag((request.getInt(CubeXFields.Common.stopFlag)==1)?true:false);
				}
				if(request.hasField(CubeXFields.Common.high)){
					model.setHigh(CommonUtils.convertDouble(request.getDouble(CubeXFields.Common.high)));
				}
				if(request.hasField(CubeXFields.Common.low)){
					model.setLow(CommonUtils.convertDouble(request.getDouble(CubeXFields.Common.low)));
				}
				if(request.hasField(CubeXFields.Common.close)){
					model.setClose(CommonUtils.convertDouble(request.getDouble(CubeXFields.Common.close)));
				}
				if(request.hasField(CubeXFields.Common.last)){
					model.setLast(CommonUtils.convertDouble(request.getDouble(CubeXFields.Common.last)));
				}
				if(request.hasField(CubeXFields.Common.settlePrice)){
					model.setSettleprice(CommonUtils.convertDouble(request.getDouble(CubeXFields.Common.settlePrice)));
				}
				if(request.hasField(CubeXFields.Common.open)){
					model.setOpen(CommonUtils.convertDouble(request.getDouble(CubeXFields.Common.open)));
				}
				if(StringUtils.isBlank(model.getUnderlying())){
					throw new CubeRiskServiceException(UValues.ErrorType.paramsError, "证券代码不能为空");
				}
				if(StringUtils.isBlank(model.getCurrency())){
					throw new CubeRiskServiceException(UValues.ErrorType.paramsError, "Currency不能为空");
				}
				if(StringUtils.isBlank(model.getExchangecode())){
					throw new CubeRiskServiceException(UValues.ErrorType.paramsError, "ExchangeCode不能为空");
				}
				if(!request.hasField(CubeXFields.Booking.tradeDate)){
					throw new CubeRiskServiceException(UValues.ErrorType.paramsError, "nowdate不能为空");
				}
				if(!request.hasField(CubeXFields.Common.requestID)){
					throw new CubeRiskServiceException(UValues.ErrorType.paramsError, "RequestID不能为空");
				}
				model.setHisdate(CommonUtils.dateconvertString(request.getString(CubeXFields.Booking.tradeDate)));
				HisPriceModelExample priceModelExample = new HisPriceModelExample();
				priceModelExample.or().andUnderlyingEqualTo(model.getUnderlying()).andCurrencyEqualTo(model.getCurrency()).andExchangecodeEqualTo(model.getExchangecode()).andHisdateEqualTo(model.getHisdate());
				List<HisPriceModel> Result = hisPriceModelMapper.selectByExample(priceModelExample);
				if (CubeLibrary.OperatorType.add == request.getInt(CubeXFields.Common.operatorType)) {
					if(0 == Result.size()){
						int Success = hisPriceModelMapper.insert(model);
						if(Success == 1){
							AddSuccessNumber ++;
						}else {
							failRequestID.add(request.getString(CubeXFields.Common.requestID));
							textDescription.add(model.getUnderlying() + "新增失败");
						}
						
					}else{
						failRequestID.add(request.getString(CubeXFields.Common.requestID));
						textDescription.add(model.getUnderlying() + "已有存在的记录，不允许重复新增");
					}
				}
				if (CubeLibrary.OperatorType.modify == request.getInt(CubeXFields.Common.operatorType)) {
					if(0 != Result.size()){
						model.setId(Result.get(0).getId());
						int Success = hisPriceModelMapper.updateByPrimaryKey(model);
						if(Success == 1){
							UpdateSuccessNumber ++;
						}else {
							failRequestID.add(request.getString(CubeXFields.Common.requestID));
							textDescription.add(model.getUnderlying() + "修改失败");
						}
					}else{
						failRequestID.add(request.getString(CubeXFields.Common.requestID));
						textDescription.add(model.getUnderlying() + "修改失败");
					}
				}
				if (CubeLibrary.OperatorType.delete == request.getInt(CubeXFields.Common.operatorType)) {
					if(0 != Result.size()){
						model.setId(Result.get(0).getId());
						int Success = hisPriceModelMapper.deleteByPrimaryKey(model.getId());
						if(Success == 1){
							DeleteSuccessNumber ++;
						}else {
							failRequestID.add(request.getString(CubeXFields.Common.requestID));
							textDescription.add(model.getUnderlying() + "删除失败");
						}
					}else{
						failRequestID.add(request.getString(CubeXFields.Common.requestID));
						textDescription.add(model.getUnderlying() + "不存在的记录，不允许删除");
					}
				}
				
				
			}
			if (textDescription.size() > 0) {
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.insertError);
			} else {
				response.setInt(XFields.System.requestExeStatus, XValues.RequestExeStatus.success);
			}
			response.setInt(CubeXFields.Common.addSuccessNumber, AddSuccessNumber);
			response.setInt(CubeXFields.Common.updateSuccessNumber, UpdateSuccessNumber);
			response.setInt(CubeXFields.Common.deleteSuccessNumber, DeleteSuccessNumber);
			response.setInt(XFields.System.subGroupNumber, textDescription.size());
			for(int m = 0 ;m < textDescription.size() ; m ++){
				response.addRowAndSetCurrent();
				response.setString(CubeXFields.Common.requestID, failRequestID.get(m));
				response.setString(CubeXFields.Common.comment, textDescription.get(m));
			}
			return response;
			
		} catch (Exception e) {
			logger.error("Deal HisPrice Error", e);
			response.setString(XFields.System.textDescription, e.getMessage());
			return response;
		}
	}
	
	
}
