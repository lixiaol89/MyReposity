package com.huatai.cube.server.ts.modules.securitypool.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huatai.cube.server.ts.core.IBussinessService;
import com.huatai.cube.server.ts.core.aop.annotation.MsgType;
import com.huatai.cube.server.ts.modules.order.model.OrderModel;
import com.huatai.cube.server.ts.modules.securitypool.business.SecurityPoolHandler;
import com.huatai.cube.server.ts.modules.securitypool.dao.SecurityPoolModelMapper;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModel;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModelExample;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModelExample.Criteria;
import com.huatai.cube.server.ts.modules.securitypool.service.ISecurityPoolManageService;
import com.huatai.cube.server.ts.util.CommonUtils;
import com.huatai.cube.server.ts.util.define.CommonXFields;
import com.huatai.cube.server.ts.util.define.UValues;
import com.huatai.cube.server.ts.util.define.securitypool.SecurityPoolXFields;
import com.huatai.cube.server.ts.util.define.securitypool.SecurityPoolXValues;
import com.huatai.xtrade.xstep.app.field.XFields;
import com.huatai.xtrade.xstep.app.value.XValues;
import com.huatai.xtrade.xstep.event.IXStepEvent;
import com.huatai.xtrade.xstep.event.XStepEvent;

/**
 * 券池管理
 * 
 */
@Service
public class SecurityPoolManageService implements ISecurityPoolManageService ,IBussinessService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SecurityPoolManageService.class);

	@Autowired
	private SecurityPoolModelMapper securityPoolModelMapper;
	
	@Autowired
	private SecurityPoolHandler securityPoolHandler;

	/**
	 * 业务人员查询券池
	 * @author K0180007
	 */
	@Override
	@MsgType(request = SecurityPoolXValues.MsgType.querySecurityPoolByManagerRequest, 
	         response = SecurityPoolXValues.MsgType.querySecurityPoolByManagerResponse)
	public IXStepEvent querySecurityPoolByManager(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(SecurityPoolXValues.MsgType.querySecurityPoolByManagerResponse);
		try {
			request.setCurrentRow(0);
			if(request.hasField(XFields.System.clientMesssageID)){
				response.setString(XFields.System.clientMesssageID,request.getString(XFields.System.clientMesssageID));
			}
			//查询暂不校验
//			if (!request.hasField(XFields.UserAccount.loginUserID)) {
//                response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
//                response.setString(XFields.System.textDescription, "loginUserID不能为空");
//                return response;
//            }
			//String lastupuser = request.getString(XFields.UserAccount.loginUserID);
//			if (!request.hasField(CommonXFields.RequestID)) {
//				response.setCurrentRow(0);
//                response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
//                response.setString(XFields.System.textDescription, "requestId不能为空");
//                return response;
//            }
			// 分页
			CommonUtils.setPagingInfo(request, response);
			SecurityPoolModelExample example = new SecurityPoolModelExample();
			Criteria criteria = example.createCriteria();
			//证券代码
			if (request.hasField(SecurityPoolXFields.SecurityPool.Underlying)) {
				criteria.andUnderlyingEqualTo(request.getString(SecurityPoolXFields.SecurityPool.Underlying));
			}
			//交易市场
			if (request.hasField(SecurityPoolXFields.SecurityPool.SecurityExchange)) {
				criteria.andSecurityexchangeEqualTo(request.getString(SecurityPoolXFields.SecurityPool.SecurityExchange));
			}
			//证券名称
			if (request.hasField(SecurityPoolXFields.SecurityPool.UnderlyingName)) {
				criteria.andUnderlyingnameEqualTo(request.getString(SecurityPoolXFields.SecurityPool.UnderlyingName));
			}
			//开始时间
			if (request.hasField(SecurityPoolXFields.SecurityPool.StartDate)) {
				String startDateStr = request.getString(SecurityPoolXFields.SecurityPool.StartDate);
				Date startDate = CommonUtils.dateconvertString(startDateStr);
				if(startDate != null){
					criteria.andDateGreaterThanOrEqualTo(startDate);
				}
			}
			//结束时间
			if (request.hasField(SecurityPoolXFields.SecurityPool.EndDate)) {
				String endDateStr = request.getString(SecurityPoolXFields.SecurityPool.EndDate);
				Date endDate = CommonUtils.dateconvertString(endDateStr);
				if(endDate != null){
					criteria.andDateLessThanOrEqualTo(endDate);					
				}
			}
			if (!request.hasField(SecurityPoolXFields.SecurityPool.StartDate) &&
					!request.hasField(SecurityPoolXFields.SecurityPool.EndDate)) {
				Date date = new Date();
				SecurityPoolModel spModel = securityPoolModelMapper.selectAllMaxDate();
				if(spModel != null && spModel.getDate() != null){
					date = spModel.getDate();
				}
				criteria.andDateEqualTo(date);
			}
			
			example.or(criteria);
			List<SecurityPoolModel> securityPoolList = securityPoolModelMapper
					.selectByExample(example);
			//当前查询数量
			Integer currentNum = 0;
			//总数量
			Integer totalNum = 0;
			// 循环赋值，输出
			if (securityPoolList != null && !securityPoolList.isEmpty()) {
				currentNum = securityPoolList.size();
				for (SecurityPoolModel sp : securityPoolList) {
					response.addRowAndSetCurrent();
					CommonUtils.awesomeModelToIXStepEvent(sp, response);
				}
			}
			totalNum = securityPoolModelMapper.countByExample(example);
			response.setCurrentRow(0);
			response.setInt(XFields.System.subGroupNumber, currentNum);
			response.setLong(XFields.System.totalSize, totalNum);
			response.setInt(XFields.System.requestExeStatus,
					XValues.RequestExeStatus.success);
			response.setString(XFields.System.textDescription, "查询成功");
			return response;			
		} catch (Exception e) {
			LOGGER.error("querySecurityPoolByManager error", e);
			response.setCurrentRow(0);
			response.setString(XFields.System.textDescription, e.getMessage());
			return response;
		}
	}

	/**
	 * 根据证券代码修改可借数量和利率、可空额度
	 * @author K0180007
	 */
	@Override
	@MsgType(request = SecurityPoolXValues.MsgType.editSecurityPoolRequest, 
	         response = SecurityPoolXValues.MsgType.editSecurityPoolResponse)
	public IXStepEvent editAbleBorrowAmountAndInterestRate(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(SecurityPoolXValues.MsgType.editSecurityPoolResponse);
        try {
        	request.setCurrentRow(0);
        	if(request.hasField(XFields.System.clientMesssageID)){
				response.setString(XFields.System.clientMesssageID,request.getString(XFields.System.clientMesssageID));
			}
        	if (!request.hasField(XFields.UserAccount.loginUserID)) {
                response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
                response.setString(XFields.System.textDescription, "loginUserID不能为空");
                return response;
            }
			String lastUpdateUser = request.getString(XFields.UserAccount.loginUserID);
			if(!request.hasField(XFields.System.subGroupNumber)  || request.getInt(XFields.System.subGroupNumber) <= 0){
				response.setString(XFields.System.textDescription, "参数类型设置不正确, 分组记录数目subGroupNumber不能为空");
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
				return response;
			}
			//证券个数
			int requestSize = request.getInt(XFields.System.subGroupNumber);
			
			int sucessnum = 0;
			for(int i = 0; i < requestSize; i++){
				SecurityPoolModel sp = new SecurityPoolModel();
				request.setCurrentRow(i + 1);				
				if (!request.hasField(CommonXFields.RequestID)) {
					response.addRowAndSetCurrent();
					response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "requestId不能为空");
					response.setInt(CommonXFields.Completed, 0);
	                continue;
	            }
				if (!request.hasField(SecurityPoolXFields.SecurityPool.Underlying)) {
					response.addRowAndSetCurrent();
					response.setInt(CommonXFields.Completed, 0);
					response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "证券代码不能为空");
	                continue;
	            }
				if (!request.hasField(SecurityPoolXFields.SecurityPool.LendAbleAmount) && 
						!request.hasField(SecurityPoolXFields.SecurityPool.InterestRate) &&
						!request.hasField(SecurityPoolXFields.SecurityPool.ShortAbleamount)) {
					response.addRowAndSetCurrent();
					response.setInt(CommonXFields.Completed, 0);
					response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "可借数量、利率和可空数量不能同时为空");
	                continue;
	            }
	        	CommonUtils.awesomeIXStepEventToModel(request, sp);
	        	//查询此证券当前信息
	        	SecurityPoolModelExample example = new SecurityPoolModelExample();
//	        	example.setOrderByClause("Date desc");
        		example.or().andUnderlyingEqualTo(sp.getUnderlying()).andDateEqualTo(new Date());
    			List<SecurityPoolModel> securityPoolList = securityPoolModelMapper
    					.selectByExample(example);
        		if(securityPoolList == null || securityPoolList.isEmpty()){
        			response.addRowAndSetCurrent();
					response.setInt(CommonXFields.Completed, 0);
					response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "数据库不存在" + sp.getUnderlying() +"的今天的数据");
	                continue;
        		}
        		//总数量
        		int totalAmount = 0;
        		if(securityPoolList.get(0).getTotalamount() != null){
        			totalAmount = securityPoolList.get(0).getTotalamount();
        		}
	        	//校验可借数量，不能大于总数量
	        	if(sp.getLendableamount() != null && totalAmount < sp.getLendableamount()){
        			response.addRowAndSetCurrent();
					response.setInt(CommonXFields.Completed, 0);
					response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "可借数量不能大于总数量");
	                continue;
	        	}
	        	//校验可卖空数量，不能大于总数量
	        	if(sp.getShortableamount() != null && totalAmount < sp.getShortableamount()){
	        		response.addRowAndSetCurrent();
	        		response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
					response.setInt(CommonXFields.Completed, 0);
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "可卖空数量不能大于总数量");
	                continue;
	        	}
	        	//可借数量与可卖空数量之和
        		int ableSum = 0;
        		if(sp.getLendableamount() != null){
        			ableSum += sp.getLendableamount();
        		}else{
        			ableSum += securityPoolList.get(0).getLendableamount();
        		}
        		if(sp.getShortableamount() != null){
        			ableSum += sp.getShortableamount();
        		}else{
        			ableSum += securityPoolList.get(0).getShortableamount();
        		}
	        	//已借数量
        		int haveBorrowAmount = 0;
        		//锁券数量
        		int lockAmount = 0;
        		//已卖空数量
        		int haveShortAmount = 0;
        		if(securityPoolList.get(0).getLentamount() != null){
        			haveBorrowAmount = securityPoolList.get(0).getLentamount();
        		}
        		if(securityPoolList.get(0).getLockedamount() != null){
        			lockAmount = securityPoolList.get(0).getLockedamount();
        		}
        		if(securityPoolList.get(0).getShortedamount() != null){
        			haveShortAmount = securityPoolList.get(0).getShortedamount();
        		}
        		//剩余数量 = 可借数量 + 可卖空数量 - 已借数量-锁券数量-已卖空数量  
        		if(ableSum < (haveBorrowAmount + lockAmount + haveShortAmount)){
        			response.addRowAndSetCurrent();
					response.setInt(CommonXFields.Completed, 0);
					response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," +
					"可借数量与可卖空数量之和，不能小于已借数量、已卖空数量、锁券数量之和");
	                continue;
        		}
        		//更新剩余可借数量
        		int leftAmount = ableSum - (haveBorrowAmount + lockAmount + haveShortAmount);
        		sp.setLeftamount(leftAmount);
	        	//校验利率，不能小于0
	        	if(sp.getInterestrate() != null && sp.getInterestrate().compareTo(new BigDecimal(0)) < 0){
	        		response.addRowAndSetCurrent();
					response.setInt(CommonXFields.Completed, 0);
					response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "利率不能小于0");
	                continue;
	        	}
	        	sp.setLastupdateuser(lastUpdateUser);
	        	sp.setLastupdatetime(new Date());
	        	sp.setDate(new Date());
	        	int result = -1;
	        	String resultMsg =null;
	        	try{
	        		result = securityPoolModelMapper.updateByUnderlyingSelective(sp);
	        	}catch(Exception e){
	        		LOGGER.error("editAbleBorrowAmountAndInterestRate Error", e);
	        		resultMsg = e.getMessage();
	        	}
	        	//入库成功
	        	if(result > 0){
	        		++sucessnum;
	        		response.addRowAndSetCurrent();
		        	response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	        		response.setInt(CommonXFields.Completed, 1);
	        	}else{
	        		response.addRowAndSetCurrent();
	        		response.setInt(CommonXFields.Completed, 0);
	        		response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "更新失败" 
	                + (resultMsg != null ? "，原因："+ resultMsg : ""));
	        	}
			}
			response.setCurrentRow(0);
			response.setInt(XFields.System.subGroupNumber, requestSize);
        	response.setInt(XFields.System.requestExeStatus, XValues.RequestExeStatus.success);
        	response.setString(XFields.System.textDescription, "成功修改" + sucessnum + "个证券信息");
        	return response;
		}catch (Exception e) {
			LOGGER.error("editAbleBorrowAmountAndInterestRate Error", e);
			response.setCurrentRow(0);
			response.setString(XFields.System.textDescription, e.getMessage());
			return response;
		}
	}

	/**
	 * 客户查询券池
	 */
	@Override
	@MsgType(request = SecurityPoolXValues.MsgType.querySecurityPoolByCustomerRequest, 
    response = SecurityPoolXValues.MsgType.querySecurityPoolByCustomerResponse)
	public IXStepEvent querySecurityPoolByCustomer(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(SecurityPoolXValues.MsgType.querySecurityPoolByManagerResponse);
		try {
			request.setCurrentRow(0);
			if(request.hasField(XFields.System.clientMesssageID)){
				response.setString(XFields.System.clientMesssageID,request.getString(XFields.System.clientMesssageID));
			}
			// 分页
			CommonUtils.setPagingInfo(request, response);
			SecurityPoolModelExample example = new SecurityPoolModelExample();
			Criteria criteria = example.createCriteria();
			if(request.hasField(XFields.System.subGroupNumber) && request.getInt(XFields.System.subGroupNumber) > 0){
				int requestSize = request.getInt(XFields.System.subGroupNumber);
				List<String> underlyingList = new ArrayList<>();
				List<String> exchangeList = new ArrayList<>();
				for(int i = 0; i < requestSize; i++){
					request.setCurrentRow(i + 1);
					//证券代码
					if (request.hasField(SecurityPoolXFields.SecurityPool.Underlying)) {
						underlyingList.add(request.getString(SecurityPoolXFields.SecurityPool.Underlying));
					}
					//交易市场
					if (request.hasField(SecurityPoolXFields.SecurityPool.SecurityExchange)) {
						exchangeList.add(request.getString(SecurityPoolXFields.SecurityPool.SecurityExchange));
					}
				}
				//证券代码
				if (!underlyingList.isEmpty()) {
					criteria.andUnderlyingIn(underlyingList);
				//交易市场
				}else if(!exchangeList.isEmpty()){
					criteria.andSecurityexchangeIn(exchangeList);
				}
			}
			
			Date date = new Date();
			SecurityPoolModel spModel = securityPoolModelMapper.selectAllMaxDate();
			if(spModel != null && spModel.getDate() != null){
				date = spModel.getDate();
			}
			criteria.andDateEqualTo(date);
			example.or(criteria);
			List<SecurityPoolModel> securityPoolList = securityPoolModelMapper
					.selectByExample(example);
			//当前查询数量
			Integer currentNum = 0;
			//总数量
			Integer totalNum = 0;
			// 循环赋值，输出
			if (securityPoolList != null && !securityPoolList.isEmpty()) {
				currentNum = securityPoolList.size();
				for (SecurityPoolModel sp : securityPoolList) {
					response.addRowAndSetCurrent();
					//客户可见券息、剩余可借、证券代码、证券名称、市场交易代码
					sp.setId(null);
					sp.setLendableamount(null);
					sp.setLentamount(null);
					sp.setLockedamount(null);
					sp.setPosition(null);
					sp.setTotalamount(null);
					sp.setLastupdateuser(null);
					sp.setShortableamount(null);
					sp.setShortedamount(null);
					sp.setShortamount(null);
					CommonUtils.awesomeModelToIXStepEvent(sp, response);
				}
			}
			totalNum = securityPoolModelMapper.countByExample(example);
			response.setCurrentRow(0);
			response.setInt(XFields.System.subGroupNumber, currentNum);
			response.setLong(XFields.System.totalSize, totalNum);
			response.setInt(XFields.System.requestExeStatus,
					XValues.RequestExeStatus.success);
			response.setString(XFields.System.textDescription, "查询成功");
			return response;
		} catch (Exception e) {
			LOGGER.error("querySecurityPoolByCustomer error", e);
			response.setCurrentRow(0);
			response.setString(XFields.System.textDescription, e.getMessage());
			return response;
		}
	}

	@Override
	public Boolean modifyByOrderModel(OrderModel orderModel) {
		Boolean success = securityPoolHandler.modify(orderModel);
		return success;
	}

}
