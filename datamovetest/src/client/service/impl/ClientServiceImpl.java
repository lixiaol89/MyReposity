package com.huatai.cube.rms.modules.client.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.huatai.cube.rms.core.IBussinessService;
import com.huatai.cube.rms.core.aop.annotation.MsgType;
import com.huatai.cube.rms.exception.CubeRiskServiceException;
import com.huatai.cube.rms.modules.client.dao.ClientModelMapper;
import com.huatai.cube.rms.modules.client.model.ClientModel;
import com.huatai.cube.rms.modules.client.model.ClientModelExample;
import com.huatai.cube.rms.modules.client.service.IClientService;
import com.huatai.cube.rms.util.CommonUtils;
import com.huatai.cube.rms.util.define.CubeRiskXValues;
import com.huatai.cube.rms.util.define.UValues;
import com.huatai.cube.server.common.utils.CubeLibrary;
import com.huatai.cube.server.common.utils.CubeXFields;
import com.huatai.xtrade.xstep.app.field.XFields;
import com.huatai.xtrade.xstep.app.value.XValues;
import com.huatai.xtrade.xstep.event.IXStepEvent;
import com.huatai.xtrade.xstep.event.XStepEvent;
import com.huatai.xtrade.xstep.exception.XStepException;


@Service
public class ClientServiceImpl implements IClientService,IBussinessService{
	
	private final static Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Resource(name="clientModelMapper")
	ClientModelMapper clientModelMapper;

	
	@Override
	@MsgType(request = CubeRiskXValues.MsgType.queryClientRequest, response = CubeRiskXValues.MsgType.queryClientResponse)
	public IXStepEvent queryClient(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(CubeRiskXValues.MsgType.queryClientResponse);
		response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.RuntimeError);
		
		try {
			request.setCurrentRow(0);
			if (!request.hasField(XFields.System.pageNo)) {
				request.setInt(XFields.System.pageNo, 1);
			}
			CommonUtils.setPagingInfo(request, response);
			//参数检查
			List<ClientModel> clientResult = new ArrayList<ClientModel>();
			ClientModelExample example = new ClientModelExample();
			List<String> assetAccountList = new ArrayList<>();
			List<String> clientName = new ArrayList<>();
			if (request.hasField(CubeXFields.Common.clientID)) {
				String[] assetAccount = request.getString(CubeXFields.Common.clientID).split(",");
				for(int i = 0 ; i < assetAccount.length ; i ++){
					assetAccountList.add(assetAccount[i]);
				}
			}
			if (request.hasField(CubeXFields.Common.clientName)) {
				String[] assetAccountName = request.getString(CubeXFields.Common.clientName).split(",");
				for(int i = 0 ; i < assetAccountName.length ; i ++){
					clientName.add(assetAccountName[i]);
				}
			}
			if (assetAccountList.size() > 0) {
				example.or().andClientidIn(assetAccountList);
			}
			if (clientName.size() > 0) {
				example.or().andClientnameIn(clientName);
			}
			clientResult = clientModelMapper.selectByExample(example);
			
			PageInfo<ClientModel> page = new PageInfo<ClientModel>(clientResult);
			response.setInt(XFields.System.subGroupNumber, clientResult.size());
			response.setInt(XFields.System.pageSize, page.getPageSize());
			response.setInt(XFields.System.pageNo, page.getPageNum());
			response.setLong(XFields.System.totalSize, page.getTotal());
			response.setInt(XFields.System.requestExeStatus, XValues.RequestExeStatus.success);
			for(ClientModel model : clientResult){
				response.addRowAndSetCurrent();
				CommonUtils.awesomeModelToIXStepEvent(model, response);
			}
			response.resetIndex();
			return response;

		}catch(Exception ex)
		{
			logger.error("Query Client Error", ex);
			response.setString(XFields.System.textDescription, ex.getMessage());
			return response;
		}
	}

	
	@Override
	@MsgType(request = CubeRiskXValues.MsgType.dealClientRequest, response = CubeRiskXValues.MsgType.dealClientResponse)
	public IXStepEvent dealClient(IXStepEvent request) {
		
		IXStepEvent response = new XStepEvent( CubeRiskXValues.MsgType.dealClientResponse);
		response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.RuntimeError);
		
		try {
			//参数检查	
			int addSuccessNumber = 0;
			int updateSuccessNumber = 0;
			int deleteSuccessNumber = 0;
			request.setCurrentRow(0);
			if(!request.hasField(CubeXFields.Common.lastUpdateUser)){
				response.setString(XFields.System.textDescription, "参数类型设置不正确, 最后更新用户名(User)不能为空");
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
				return response;
			}
			String user = request.getString(CubeXFields.Common.lastUpdateUser);
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
			
			List<ClientModel> clientResult = new ArrayList<ClientModel>();
			List<String> failRequestID = new ArrayList<>();
			List<String> textDescription = new ArrayList<>();
			for(int i = 0; i < requestSize; i++){				
				ClientModel model = new ClientModel();
				ClientModelExample example = new ClientModelExample();	
				request.setCurrentRow(i + 1);
				CommonUtils.awesomeIXStepEventToModel(request, model);
				if(!request.hasField(CubeXFields.Common.operatorType)){
					response.setString(XFields.System.textDescription, "参数类型设置不正确, 操作类型OperatorType不能为空");
					response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
					return response;
				}
				if(StringUtils.isBlank(model.getClientid())){
					throw new CubeRiskServiceException(UValues.ErrorType.paramsError, "客户代码不能为空");
				}
				example.or().andClientidEqualTo(model.getClientid());
				clientResult = clientModelMapper.selectByExample(example);
				if (CubeLibrary.OperatorType.add == request.getInt(CubeXFields.Common.operatorType)) {
					if(clientResult.size() == 0){
						model.setLastupdateuser(user);
						model.setLastupdatetime(new Date());
						int Success = clientModelMapper.insert(model);
						if(Success == 1){
							addSuccessNumber ++;
						}else {
							writeFailReason(failRequestID, textDescription, request, model.getClientid() + "新增失败");
						}
						
					}else{
						writeFailReason(failRequestID, textDescription, request, model.getClientid() + "已有存在的记录，不允许重复新增");
					}
				}
				if (CubeLibrary.OperatorType.modify == request.getInt(CubeXFields.Common.operatorType)) {
					if(clientResult.size() == 1){
						model.setLastupdateuser(user);
						model.setLastupdatetime(new Date());
						model.setId(clientResult.get(0).getId());
						int Success = clientModelMapper.updateByPrimaryKey(model);
						if(Success == 1){
							updateSuccessNumber ++;
						}else {
							writeFailReason(failRequestID, textDescription, request, model.getClientid() + "修改失败");
						}
					}else{
						writeFailReason(failRequestID, textDescription, request, model.getClientid() + "不存在的记录，不允许修改");
					}
				}
				if (CubeLibrary.OperatorType.delete == request.getInt(CubeXFields.Common.operatorType)) {
					if(clientResult.size() == 1){
						model.setLastupdateuser(user);
						int Success = clientModelMapper.deleteByPrimaryKey(clientResult.get(0).getId());
						if(Success == 1){
							deleteSuccessNumber ++;
						}else {
							writeFailReason(failRequestID, textDescription, request, model.getClientid() + "删除失败");
						}
					}else{
						writeFailReason(failRequestID, textDescription, request, model.getClientid() + "不存在的记录，不允许删除");
					}
				}
			}
			if (textDescription.size() > 0) {
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.insertError);
			} else {
				response.setInt(XFields.System.requestExeStatus, XValues.RequestExeStatus.success);
			}
			response.setInt(CubeXFields.Common.addSuccessNumber, addSuccessNumber);
			response.setInt(CubeXFields.Common.updateSuccessNumber, updateSuccessNumber);
			response.setInt(CubeXFields.Common.deleteSuccessNumber, deleteSuccessNumber);
			response.setInt(XFields.System.subGroupNumber, textDescription.size());
			for(int m = 0 ;m < textDescription.size() ; m ++){
				response.addRowAndSetCurrent();
				response.setString(CubeXFields.Common.requestID, failRequestID.get(m));
				response.setString(CubeXFields.Common.comment, textDescription.get(m));
			}
			return response;
			
		} catch (Exception e) {
			logger.error("Deal Client Error", e);
			response.setString(XFields.System.textDescription, e.getMessage());
			return response;
		}
		
	}
	
	public void writeFailReason(List<String> failRequestID, List<String> failReason,IXStepEvent request ,String reason) throws XStepException{
		failRequestID.add(request.getString(CubeXFields.Common.requestID));
		failReason.add(reason);
	}

}
