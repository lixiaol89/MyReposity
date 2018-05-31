package com.huatai.cube.rms.modules.client.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.esotericsoftware.minlog.Log;
import com.github.pagehelper.PageInfo;
import com.huatai.cube.rms.core.IBussinessService;
import com.huatai.cube.rms.core.aop.annotation.MsgType;
import com.huatai.cube.rms.modules.client.dao.ClientPricingModelMapper;
import com.huatai.cube.rms.modules.client.model.ClientPricingModel;
import com.huatai.cube.rms.modules.client.model.ClientPricingModelExample;
import com.huatai.cube.rms.modules.client.service.IClientPricingService;
import com.huatai.cube.rms.util.CommonUtils;
import com.huatai.cube.rms.util.define.UValues;
import com.huatai.cube.rms.util.define.clientpricing.ClientPricingValues;
import com.huatai.cube.server.common.utils.CubeXFields;
import com.huatai.xtrade.xstep.app.field.XFields;
import com.huatai.xtrade.xstep.app.value.XValues;
import com.huatai.xtrade.xstep.event.IXStepEvent;
import com.huatai.xtrade.xstep.event.XStepEvent;
import com.huatai.xtrade.xstep.exception.XStepException;

@Service
public class ClientPricingServiceImpl implements IClientPricingService ,IBussinessService {
	
	@Resource(name = "clientPricingModelMapper")
	private ClientPricingModelMapper clientPricingModelMapper;

	@Override
	@MsgType(request = ClientPricingValues.MsgType.queryClientPricingRequest, response = ClientPricingValues.MsgType.queryClientPricingResponse)
	public IXStepEvent queryClientPricings(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(ClientPricingValues.MsgType.queryClientPricingResponse);
		try {
			request.setCurrentRow(0);
			if (!request.hasField(XFields.System.pageNo)) {
				request.setInt(XFields.System.pageNo, 1);
			}
			CommonUtils.setPagingInfo(request, response);
			ClientPricingModelExample example = new ClientPricingModelExample();
			ClientPricingModelExample.Criteria criteria = example.or(); 
			
			if(request.hasField(CubeXFields.Common.clientID)) {
				String clientid  = request.getString(CubeXFields.Common.clientID);
				String[] clientidss = clientid.split(",");
				List<String> clientids= Arrays.asList(clientidss);
				criteria.andClientidIn(clientids);
			}
			
			if (request.hasField(CubeXFields.Booking.templateType)) {
				criteria.andTemplatetypeEqualTo(request.getString(CubeXFields.Booking.templateType));
			}
			
			if (request.hasField(CubeXFields.Common.orderSide)) {
				criteria.andLongshortEqualTo(request.getInt(CubeXFields.Common.orderSide));
			}
			
			List<ClientPricingModel> pricingList = clientPricingModelMapper.selectByExample(example);
			
			PageInfo<ClientPricingModel> page = new PageInfo<ClientPricingModel>(pricingList);
			response.setInt(XFields.System.subGroupNumber, pricingList.size());
			response.setInt(XFields.System.pageSize, page.getPageSize());
			if (!request.hasField(XFields.System.pageNo)) {
				response.setInt(XFields.System.pageNo,0);
			}
			response.setLong(XFields.System.totalSize, page.getTotal());
			response.setInt(XFields.System.requestExeStatus, XValues.RequestExeStatus.success);
			for(ClientPricingModel model : pricingList){
				response.addRowAndSetCurrent();
				CommonUtils.awesomeModelToIXStepEvent(model, response);
			}
			response.resetIndex();
			
		} catch (XStepException e) {
			Log.info(e.getMessage());
		} catch (ClassNotFoundException e) {
			Log.info(e.getMessage());
		}
		return response;
		
	}

	
	@Override
	@MsgType(request = ClientPricingValues.MsgType.dealClientPricingRequest, response = ClientPricingValues.MsgType.dealClientPricingResponse)
	public IXStepEvent dealClientPricings(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(ClientPricingValues.MsgType.dealClientPricingResponse);
		request.setCurrentRow(0);
		int AddSuccessNumber = 0;
		int UpdateSuccessNumber = 0;
		int DeleteSuccessNumber = 0;
		List<String> failRequestID = new ArrayList<>();
		List<String> textDescription = new ArrayList<>();
		try {
			int requestSize = request.getInt(XFields.System.subGroupNumber);
			if(requestSize <= 0){
				response.setString(XFields.System.textDescription, "参数设置不正确, 分组记录数目subGroupNumber需大于0");
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
				response.resetIndex();
				return response;
			}
			
			for(int i=0;i<requestSize;i++) {
				request.setCurrentRow(i+1);
				ClientPricingModelExample example = new ClientPricingModelExample();
				ClientPricingModel record = new ClientPricingModel();
				CommonUtils.awesomeIXStepEventToModel(request, record);
				int op = request.getInt(CubeXFields.Common.operatorType);
				if(0 == op) {
					try {
						int result = clientPricingModelMapper.insertSelective(record);
						if(1==result) {
							AddSuccessNumber ++;
						}else {
							failRequestID.add(request.getString(CubeXFields.Common.requestID));
							textDescription.add(record.getClientid() + "新增失败");
						}
					} catch (Exception e) {
						Log.info(e.getMessage());
						failRequestID.add(request.getString(CubeXFields.Common.requestID));
						textDescription.add(record.getClientid() + "新增报错");
					}
					
				}else if(1 == op) {
					try {
						example.createCriteria().andClientidEqualTo(record.getClientid()).andTemplatetypeEqualTo(record.getTemplatetype()).andLongshortEqualTo(record.getLongshort());
						int result = clientPricingModelMapper.updateByExampleSelective(record, example);
						if(1==result) {
							UpdateSuccessNumber ++;
						}else {
							failRequestID.add(request.getString(CubeXFields.Common.requestID));
							textDescription.add(record.getClientid() + "更新失败");
						}
					} catch (Exception e) {
						Log.info(e.getMessage());
						failRequestID.add(request.getString(CubeXFields.Common.requestID));
						textDescription.add(record.getClientid() + "更新报错");
					}
					
				}else if(2 == op) {
					try {
						example.createCriteria().andClientidEqualTo(record.getClientid()).andTemplatetypeEqualTo(record.getTemplatetype()).andLongshortEqualTo(record.getLongshort());
						int result = clientPricingModelMapper.deleteByExample(example);
						if(1==result) {
							DeleteSuccessNumber ++;
						}else {
							failRequestID.add(request.getString(CubeXFields.Common.requestID));
							textDescription.add(record.getClientid() + "刪除失败");
						}
					} catch (Exception e) {
						Log.info(e.getMessage());
						failRequestID.add(request.getString(CubeXFields.Common.requestID));
						textDescription.add(record.getClientid() + "刪除报错");
					}
					
				}
			}
			
		} catch (XStepException e1) {
			Log.info(e1.getMessage());
		} catch (ClassNotFoundException e) {
			Log.info(e.getMessage());
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
	}

}
