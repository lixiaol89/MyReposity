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

import com.alibaba.dubbo.common.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.github.pagehelper.PageInfo;
import com.huatai.cube.rms.core.IBussinessService;
import com.huatai.cube.rms.core.aop.annotation.MsgType;
import com.huatai.cube.rms.exception.CubeRiskServiceException;
import com.huatai.cube.rms.modules.mktquotation.dao.LivePriceModelMapper;
import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModel;
import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModelExample;
import com.huatai.cube.rms.modules.mktquotation.service.ILivePriceService;
import com.huatai.cube.rms.util.CommonUtils;
import com.huatai.cube.rms.util.define.CubeRiskXValues;
import com.huatai.cube.rms.util.define.UValues;
import com.huatai.cube.server.common.utils.CubeLibrary;
import com.huatai.cube.server.common.utils.CubeXFields;
import com.huatai.cube.server.common.utils.CubeLibrary.Model;
import com.huatai.xtrade.xstep.app.field.XFields;
import com.huatai.xtrade.xstep.app.value.XValues;
import com.huatai.xtrade.xstep.event.IXStepEvent;
import com.huatai.xtrade.xstep.event.XStepEvent;

/**
 * @author 006562
 *
 */
@Service
public class LivePriceServiceImpl implements ILivePriceService,IBussinessService {
	
	private final static Logger logger = LoggerFactory.getLogger(LivePriceServiceImpl.class); 
	
	@Resource(name="livePriceModelMapper")
	LivePriceModelMapper livePriceModelMapper;
	
	@Override
	@MsgType(request = CubeRiskXValues.MsgType.queryLivePriceRequest , response = CubeRiskXValues.MsgType.queryLivePriceResponse)
	public IXStepEvent queryLivePriceDetails(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(CubeRiskXValues.MsgType.queryLivePriceResponse);
		response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.RuntimeError);
		try {
			CommonUtils.setPagingInfo(request, response);
			List<LivePriceModel> livePriceResult = new ArrayList<LivePriceModel>();
			LivePriceModelExample example = new LivePriceModelExample();
			LivePriceModelExample.Criteria criteria = example.createCriteria();
			boolean notFx = true;
			if (request.hasField(CubeXFields.Common.exchangeCode)) {
				String[] exchangecodeString = request.getString(CubeXFields.Common.exchangeCode).split(",");
				List<String> exchangecodelist = new ArrayList<String>();
				for(int i = 0 ; i < exchangecodeString.length ; i ++){
					exchangecodelist.add(exchangecodeString[i]);
				}
				if(exchangecodelist.size()==1 && exchangecodelist.get(0).equals("FX")){
					notFx = false;
				}else{
					criteria.andExchangecodeIn(exchangecodelist);
				}
			}
			List<String> underlyinglist = new ArrayList<String>();
			if (request.hasField(CubeXFields.Common.underlying)) {
				String[] underlyingString = request.getString(CubeXFields.Common.underlying).split(",");
				for(int i = 0 ; i < underlyingString.length ; i ++){
					underlyinglist.add(underlyingString[i]);
				}
				if(notFx){
					criteria.andUnderlyingIn(underlyinglist);
				}
			}
			List<String> currencylist = new ArrayList<String>();
			if (request.hasField(CubeXFields.Common.currency)) {
				String[] currencyString = request.getString(CubeXFields.Common.currency).split(",");
				for(int i = 0 ; i < currencyString.length ; i ++){
					currencylist.add(currencyString[i]);
				}
				if(notFx){
					criteria.andCurrencyIn(currencylist);
				}
			}
			if(!notFx){
				if(underlyinglist.size()>0 && currencylist.size()>0){
					if(underlyinglist.size() == currencylist.size()){
						List<String> fxlist = new ArrayList<String>();
						for(int i=0;i<underlyinglist.size();i++){
							if(!underlyinglist.get(i).isEmpty() && !currencylist.get(i).isEmpty()){
								fxlist.add(underlyinglist.get(i)+currencylist.get(i));
							}else{
								logger.info("Query FX With Empty Params");
								response.setInt(XFields.System.requestExeStatus, 1);
								response.setString(XFields.System.textDescription,"请调整汇率查询条件！");
								return response;
							}
						}
						criteria.andUnderlyingIn(fxlist);
					}else{
						logger.info("Query FX With UnMatch Params");
						response.setInt(XFields.System.requestExeStatus, 1);
						response.setString(XFields.System.textDescription,"请调整汇率查询条件！");
						return response;
					}
				}else {
					criteria.andExchangecodeEqualTo("FX");
				}
			}
			livePriceResult = livePriceModelMapper.selectByExample(example);
			PageInfo<LivePriceModel> page = new PageInfo<LivePriceModel>(livePriceResult);
			response.setString(XFields.System.subGroupNumber, String.valueOf(livePriceResult.size()));
			response.setLong(XFields.System.totalSize, page.getTotal());
			response.setInt(XFields.System.requestExeStatus, XValues.RequestExeStatus.success);
			for(LivePriceModel model : livePriceResult){
				response.addRowAndSetCurrent();
				if(model.getExchangecode().equals("FX")){
					if( !(model.getUnderlying()==null) && !model.getUnderlying().isEmpty()){
						model.setUnderlying(model.getUnderlying().substring(0,3));
					}
				}
				model.setNowdate(new Date());
				CommonUtils.awesomeModelToIXStepEvent(model, response);
			}
			response.resetIndex();
			return response;
			
		} catch (Exception e) {
			logger.error("Query LivePrice Error", e);
			response.setInt(XFields.System.requestExeStatus, 1);
			response.setString(XFields.System.textDescription,"暂时无法查询行情");
			return response;
		}
	}
	
	@Override
	@MsgType(request = CubeRiskXValues.MsgType.dealLivePriceRequest , response = CubeRiskXValues.MsgType.dealLivePriceResponse)
	public IXStepEvent dealLivePriceDetails(IXStepEvent request) {
		IXStepEvent response = new XStepEvent( CubeRiskXValues.MsgType.dealLivePriceResponse);
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
				LivePriceModel model = new LivePriceModel();
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
				if(!request.hasField(CubeXFields.Common.requestID)){
					throw new CubeRiskServiceException(UValues.ErrorType.paramsError, "RequestID不能为空");
				}
				model.setNowdate(new Date());
				LivePriceModelExample priceModelExample = new LivePriceModelExample();
				priceModelExample.or().andUnderlyingEqualTo(model.getUnderlying()).andCurrencyEqualTo(model.getCurrency()).andExchangecodeEqualTo(model.getExchangecode());
				List<LivePriceModel> Result = livePriceModelMapper.selectByExample(priceModelExample);
				if (CubeLibrary.OperatorType.add == request.getInt(CubeXFields.Common.operatorType)) {
					if(0 == Result.size()){
						int Success = livePriceModelMapper.insert(model);
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
						int Success = livePriceModelMapper.updateByPrimaryKey(model);
						if(Success == 1){
							UpdateSuccessNumber ++;
						}else {
							failRequestID.add(request.getString(CubeXFields.Common.requestID));
							textDescription.add(model.getUnderlying() + "修改失败");
						}
					}else{
						failRequestID.add(request.getString(CubeXFields.Common.requestID));
						textDescription.add(model.getUnderlying() + "不存在的记录，不允许修改");
					}
				}
				if (CubeLibrary.OperatorType.delete == request.getInt(CubeXFields.Common.operatorType)) {
					if(0 != Result.size()){
						model.setId(Result.get(0).getId());
						int Success = livePriceModelMapper.deleteByPrimaryKey(model.getId());
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
			logger.error("Deal LivePrice Error", e);
			response.setString(XFields.System.textDescription, e.getMessage());
			return response;
		}
	}
	
}
