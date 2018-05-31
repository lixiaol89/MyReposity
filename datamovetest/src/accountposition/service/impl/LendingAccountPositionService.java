package com.huatai.cube.server.ts.modules.accountposition.service.impl;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htsc.libra.service.StockQueryService;
import com.huatai.cube.server.ts.core.IBussinessService;
import com.huatai.cube.server.ts.core.aop.annotation.MsgType;
import com.huatai.cube.server.ts.modules.accountposition.dao.LendingAccountPositionModelMapper;
import com.huatai.cube.server.ts.modules.accountposition.model.LendingAccountPositionModel;
import com.huatai.cube.server.ts.modules.accountposition.model.LendingAccountPositionModelExample;
import com.huatai.cube.server.ts.modules.accountposition.model.LendingAccountPositionModelExample.Criteria;
import com.huatai.cube.server.ts.modules.accountposition.service.ILendingAccountPositionService;
import com.huatai.cube.server.ts.modules.lendingaccount.dao.LendingAccountModelMapper;
import com.huatai.cube.server.ts.modules.lendingaccount.model.LendingAccountModel;
import com.huatai.cube.server.ts.util.CommonUtils;
import com.huatai.cube.server.ts.util.define.CommonXFields;
import com.huatai.cube.server.ts.util.define.UValues;
import com.huatai.cube.server.ts.util.define.lendingaccount.LendingAccountXValues;
import com.huatai.cube.server.ts.util.define.securitypool.SecurityPoolXFields;
import com.huatai.cube.server.ts.util.define.securitypool.SecurityPoolXValues;
import com.huatai.xtrade.xstep.app.field.XFields;
import com.huatai.xtrade.xstep.app.value.XValues;
import com.huatai.xtrade.xstep.event.IXStepEvent;
import com.huatai.xtrade.xstep.event.XStepEvent;

/**
 * 持仓明细
 *
 * @author K0180007
 */
@Service
public class LendingAccountPositionService implements ILendingAccountPositionService, IBussinessService{
	
    private static final Logger LOGGER = LoggerFactory.getLogger(LendingAccountPositionService.class);
	
	@Autowired
	private LendingAccountPositionModelMapper securityDetailModelMapper;
	
	@Autowired
	private LendingAccountPositionDBService lendingAccountPositionDBService;
	
	@Autowired
	private LendingAccountModelMapper lendingAccountModelMapper;
	
	@Autowired
	private StockQueryService stockQueryService;

	/**
	 * 查询持仓明细
	 */
	@Override
	@MsgType(request = SecurityPoolXValues.MsgType.querySecurityPoolDetailByManagerRequest, 
    response = SecurityPoolXValues.MsgType.querySecurityPoolDetailByManagerResponse)
	public IXStepEvent querySecurityPoolDetailByManager(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(SecurityPoolXValues.MsgType.querySecurityPoolDetailByManagerResponse);
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
			if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.Underlying)) {
				response.setCurrentRow(0);
				response.setInt(XFields.System.requestExeStatus,UValues.ErrorType.paramsError);
				response.setString(XFields.System.textDescription, "证券代码不能为空");
				return response;
			}
			if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.Date)) {
				response.setCurrentRow(0);
				response.setInt(XFields.System.requestExeStatus,UValues.ErrorType.paramsError);
				response.setString(XFields.System.textDescription, "日期不能为空");
				return response;
			}
			String dateStr = request.getString(SecurityPoolXFields.SecurityPoolDetail.Date);
			Date date = CommonUtils.dateconvertString(dateStr);
			if(date == null){
				response.setCurrentRow(0);
				response.setInt(XFields.System.requestExeStatus,UValues.ErrorType.paramsError);
				response.setString(XFields.System.textDescription, "日期格式错误");
				return response;
			}
			//证券代码
			String underlying = request.getString(SecurityPoolXFields.SecurityPoolDetail.Underlying);
			// 分页
			CommonUtils.setPagingInfo(request, response);
			LendingAccountPositionModelExample example = new LendingAccountPositionModelExample();
			Criteria criteria = example.createCriteria();
			criteria.andUnderlyingEqualTo(underlying);
			criteria.andDateEqualTo(date);
			example.or(criteria);
			List<LendingAccountPositionModel> detailList = securityDetailModelMapper.selectByExample(example);
			//当前查询数量
			Integer currentNum = 0;
			//总数量
			Integer totalNum = 0;
			//循环赋值，输出
			if (detailList != null && !detailList.isEmpty()) {
				currentNum = detailList.size();
				for (LendingAccountPositionModel detail : detailList) {
					response.addRowAndSetCurrent();
					CommonUtils.awesomeModelToIXStepEvent(detail, response);
				}
			}
			totalNum = securityDetailModelMapper.countByExample(example);
			response.setCurrentRow(0);
			response.setInt(XFields.System.subGroupNumber, currentNum);
			response.setLong(XFields.System.totalSize, totalNum);
			response.setInt(XFields.System.requestExeStatus,
					XValues.RequestExeStatus.success);
			response.setString(XFields.System.textDescription, "查询成功");
			return response;			
		} catch (Exception e) {
			LOGGER.error("querySecurityPoolDetailByManager error", e);
			response.setCurrentRow(0);
			response.setString(XFields.System.textDescription, e.getMessage());
			return response;
		}
	}
	
	/**
	 * 保存持仓明细
	 */
	@Override
	@MsgType(request = SecurityPoolXValues.MsgType.saveSecurityPoolDetailRequest, 
    response = SecurityPoolXValues.MsgType.saveSecurityPoolDetailResponse)
	public IXStepEvent saveSecurityPoolDetail(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(LendingAccountXValues.MsgType.saveStockholderResponse);
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
			//出借股东
			List<LendingAccountModel> accountList = lendingAccountModelMapper.selectByExample(null);
			if(accountList == null || accountList.isEmpty()){
				response.setCurrentRow(0);
	        	response.setInt(CommonXFields.Completed, 0);
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.queryError);
				response.setString(XFields.System.textDescription, "查询不到出借股东");
				return response;
			}
			//证券个数
			int requestSize = request.getInt(XFields.System.subGroupNumber);
			
			int sucessnum = 0;
			
			for(int i = 0; i < requestSize; i++){
				LendingAccountPositionModel detail = new LendingAccountPositionModel();
				request.setCurrentRow(i + 1);				
				if (!request.hasField(CommonXFields.RequestID)) {
					response.addRowAndSetCurrent();
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "requestId不能为空");
					response.setInt(CommonXFields.Completed, 0);
	                continue;
	            }
				if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.ProductAccount)) {
	                setBackMessage(response, i, "产品账户");
	                response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                continue;
	            }
				if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.AssetAccount)) {
	                setBackMessage(response, i, "资产账户");
	                response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                continue;
	            }
				if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.TradingAccount)) {
	                setBackMessage(response, i, "交易账户");
	                response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                continue;
	            }
				if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.SecurityExchange)) {
	                setBackMessage(response, i, "交易市场");
	                response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                continue;
	            }
				if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.SecurityAccount)) {
	                setBackMessage(response, i, "证券账户");
	                response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                continue;
	            }
				if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.Underlying)) {
	                setBackMessage(response, i, "证券代码");
	                response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                continue;
	            }
				if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.UnderlyingName)) {
	                setBackMessage(response, i, "证券名称");
	                response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                continue;
	            }
				if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.ExecBroker)) {
	                setBackMessage(response, i, "broker信息");
	                response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                continue;
	            }
//				if (!request.hasField(SecurityPoolXFields.SecurityPoolDetail.Position)) {
//	                setBackMessage(response, i, "持仓数量");
//	                continue;
//	            }
//				
	        	CommonUtils.awesomeIXStepEventToModel(request, detail);
//	        	if(detail.getPosition() <= 0){
//	        		setBackMessage(response, i, "持仓数量需要大于0");
//	                continue;
//	        	}
	        	//持仓为空，则默认为0
	        	if(detail.getPosition() == null){
	        		detail.setPosition(0);
	        	}
	        	//卖空数量为空，则默认为0
	        	if(detail.getShortamount() == null){
	        		detail.setShortamount(0);
	        	}
	        	detail.setDate(new Date());
	        	detail.setLastupdateuser(lastUpdateUser);
	        	detail.setLastupdatetime(new Date());
	        	String resultMsg = null;
	        	//出借股东是否存在
	        	boolean exist = false;
	        	for(LendingAccountModel accountMode : accountList){
	        		if(detail.getProductaccount().equals(accountMode.getProductaccount())
	        				&& detail.getAssetaccount().equals(accountMode.getAssetaccount())
	        				&& detail.getTradingaccount().equals(accountMode.getTradingaccount())
	        				&& detail.getSecurityaccount().equals(accountMode.getSecurityaccount())){
	        			exist = true;
	        			break;
	        		}
	        	}
				if (!exist) {
					response.addRowAndSetCurrent();
					response.setInt(CommonXFields.Completed, 0);
					response.setString(CommonXFields.RequestID,	request.getString(CommonXFields.RequestID));
					response.setString(XFields.System.textDescription, "第"
							+ (i + 1) + "条," + "入库失败，原因：数据库不存在此股东信息");
					continue;
				}
				try {
					resultMsg = lendingAccountPositionDBService.insertSecurityPoolDetail(detail, lastUpdateUser);
				} catch (Exception e) {
					LOGGER.error("saveSecurityPoolDetail save Error", e);
					resultMsg = e.getMessage();
				}
	        	//入库成功
	        	if(resultMsg == null){
	        		++sucessnum;
	        		response.addRowAndSetCurrent();
		        	response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	        		response.setInt(CommonXFields.Completed, 1);
	        		response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "保存成功");
	        	}else{
	        		response.addRowAndSetCurrent();
	        		response.setInt(CommonXFields.Completed, 0);
	        		response.setString(CommonXFields.RequestID, request.getString(CommonXFields.RequestID));
	                response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + "入库失败，原因：" + resultMsg);
	        	}
			}
			response.setCurrentRow(0);
			response.setInt(XFields.System.subGroupNumber, requestSize);
        	response.setInt(XFields.System.requestExeStatus, XValues.RequestExeStatus.success);
        	response.setString(XFields.System.textDescription, "成功保存" + sucessnum + "个持仓明细信息");
        	return response;
		}catch (Exception e) {
			LOGGER.error("saveSecurityPoolDetail Error", e);
			response.setCurrentRow(0);
			response.setString(XFields.System.textDescription, e.getMessage());
			return response;
		}
	}
	
	/**
	 * 返回判空校验信息
	 * @param response
	 * @param i
	 * @param message
	 * @return
	 */
	private IXStepEvent setBackMessage(IXStepEvent response, int i, String message){
		response.addRowAndSetCurrent();
		response.setInt(CommonXFields.Completed, 0);
        response.setString(XFields.System.textDescription, "第" + (i+1) + "条," + message + "不能为空");
        
        return response;
	}
	
	/**
	 * 同步持仓
	 */
	@Override
	@MsgType(request = SecurityPoolXValues.MsgType.synchronizeSecurityPoolDetailRequest, 
    response = SecurityPoolXValues.MsgType.synchronizeSecurityPoolDetailResponse)
	public IXStepEvent synchronizeSecurityPoolDetail(IXStepEvent request) {
		IXStepEvent response = new XStepEvent(SecurityPoolXValues.MsgType.synchronizeSecurityPoolDetailResponse);
		try {
			request.setCurrentRow(0);
			if (request.hasField(XFields.System.clientMesssageID)) {
				response.setString(XFields.System.clientMesssageID,	request.getString(XFields.System.clientMesssageID));
			}
			if (!request.hasField(XFields.UserAccount.loginUserID)) {
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.paramsError);
				response.setString(XFields.System.textDescription, "loginUserID不能为空");
				return response;
			}
			String lastUpdateUser = request.getString(XFields.UserAccount.loginUserID);
			//出借股东
			List<LendingAccountModel> accountList = lendingAccountModelMapper.selectByExample(null);
			if(accountList == null || accountList.isEmpty()){
				response.setCurrentRow(0);
	        	response.setInt(CommonXFields.Completed, 0);
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.queryError);
				response.setString(XFields.System.textDescription, "查询不到出借股东");
				return response;
			}
			
			IXStepEvent detailRequest = new XStepEvent(SecurityPoolXValues.MsgType.dubboServicePositionRequest);
			//暂定,若有修改K0060003(汤界楼) 会通知
			String token = SecurityPoolXFields.PositionDubbo.TokenValue;
			Date currentDate = new Date();
			String tradeDate = CommonUtils.dateToString(currentDate, "yyyy-MM-dd");
//			int businessType = 100; //清算类型：100->A股，300->港股
			int posReqType = 0; //position=0 交易账户持仓  portfolioPosition=9 组合持仓
			int pageNo = 0; //页码（默认0时返回所有记录, 其它为页码，从1递增，默认每页最多1K条记录）
			int pageSize = 10000; //分页大小（默认1K条记录/页）
			detailRequest.setString(SecurityPoolXFields.PositionDubbo.TokenKey, token);
			detailRequest.setString(SecurityPoolXFields.PositionDubbo.TradeDate, tradeDate);
			detailRequest.setInt(SecurityPoolXFields.PositionDubbo.PageNo, pageNo);
			detailRequest.setInt(SecurityPoolXFields.PositionDubbo.PageSize, pageSize);
			detailRequest.setInt(SecurityPoolXFields.PositionDubbo.PosReqType, posReqType);
//			detailRequest.setInt(SecurityPoolXFields.PositionDubbo.BusinessType, businessType);
//		    request.setString(10112, assetAccount);
//		    request.setString(10114, tradingAccount);
	        IXStepEvent detailResponse = null;
	        detailResponse = stockQueryService.getStockSummary(detailRequest);
	        
	        detailResponse.setCurrentRow(0);
	        //返回值，参见字典 （0 - 成功, 其它 - 错误编码）
	        int requestExeStatus = detailResponse.getInt(XFields.System.requestExeStatus);
	        int errorMsg = SecurityPoolXFields.PositionDubbo.ErrorMsg;
	        if(requestExeStatus != 0){
	        	response.setCurrentRow(0);
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.queryError);
				response.setInt(CommonXFields.Completed, 0);
				response.setString(XFields.System.textDescription, "同步持仓接口异常，" + detailResponse.getString(errorMsg));
				return response;
	        }
	        if(!detailResponse.hasField(XFields.System.subGroupNumber) || 
	        		detailResponse.getInt(XFields.System.subGroupNumber) <= 0){
	        	response.setCurrentRow(0);
	        	response.setInt(CommonXFields.Completed, 0);
				response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.queryError);
				response.setString(XFields.System.textDescription, "持仓接口返回数据为0");
				return response;
			}
	        //证券个数
			int detailResponseSize = detailResponse.getInt(XFields.System.subGroupNumber);
			int sucessnum = 0;
			for(int i = 0; i < detailResponseSize; i++){
				LendingAccountPositionModel detailModel = new LendingAccountPositionModel();
				detailResponse.setCurrentRow(i + 1);
				CommonUtils.awesomeIXStepEventToModel(detailResponse, detailModel);
	        	//卖空数量为空，则默认为0
	        	if(detailModel.getShortamount() == null){
	        		detailModel.setShortamount(0);
	        	}
	        	//证券代码
	        	int underlyingId = SecurityPoolXFields.PositionDubbo.UnderlyingId;
	        	detailModel.setUnderlying(detailResponse.getString(underlyingId));
	        	if(detailModel.getUnderlying() != null && 
	        			!detailModel.getUnderlying().contains(".") &&
	        			detailModel.getSecurityexchange() != null){
	        		//获取交易市场名称
	        		String exchangeName = getExchangeName(detailModel.getSecurityexchange());
	        		String underlying = detailModel.getUnderlying() + "." + exchangeName;
	        		detailModel.setUnderlying(underlying);
	        		detailModel.setSecurityexchange(exchangeName);
	        	}
	        	//证券名称
	        	if(detailModel.getUnderlyingname() == null){
	        		detailModel.setUnderlyingname("-");
	        	}
	        	int brokerId = SecurityPoolXFields.PositionDubbo.BrokerId;
	        	//broker信息
	        	detailModel.setExecbroker(detailResponse.getString(brokerId));
	        	//持仓
	        	int positionId = SecurityPoolXFields.PositionDubbo.PositionId;
	        	Double positionD = detailResponse.getDouble(positionId);
	        	if(positionD != null){
	        		detailModel.setPosition(positionD.intValue());    				        		
	        	}else{
	        		detailModel.setPosition(0);    				        		
	        	}
	        	detailModel.setDate(currentDate);
	        	detailModel.setLastupdateuser(lastUpdateUser);
	        	detailModel.setLastupdatetime(new Date());
	        	//出借股东是否存在
	        	boolean exist = false;
	        	for(LendingAccountModel accountMode : accountList){
	        		if(detailModel.getProductaccount().equals(accountMode.getProductaccount())
	        				&& detailModel.getAssetaccount().equals(accountMode.getAssetaccount())
	        				&& detailModel.getTradingaccount().equals(accountMode.getTradingaccount())
	        				&& detailModel.getSecurityaccount().equals(accountMode.getSecurityaccount())){
	        			exist = true;
	        			break;
	        		}
	        	}
	        	if(!exist){
	        		continue;
	        	}
				try {
					lendingAccountPositionDBService.insertSecurityPoolDetail(detailModel, lastUpdateUser);
					sucessnum++;
				} catch (Exception e) {
					LOGGER.error("saveSecurityPoolDetail save Error", e);
				}
			}
	        response.setInt(CommonXFields.Completed, 1);
	        response.setInt(XFields.System.requestExeStatus, XValues.RequestExeStatus.success);
			response.setString(XFields.System.textDescription, "同步持仓完成, 共计同步" + sucessnum +"条明细");
			return response;
		} catch (Exception e) {
			LOGGER.error("synchronizeSecurityPoolDetail error", e);
			response.setCurrentRow(0);
			response.setInt(XFields.System.requestExeStatus, UValues.ErrorType.queryError);
			response.setString(XFields.System.textDescription, e.getMessage());
			return response;
		}
	}
	
	/**
	 * 市场交易代码转名称
	 * 上海     SHA   ---》 SH
	 * 深圳     SZA   ---》 SZ
	 * 沪B   SHB   ---》  SH
	 * 深B   SZB   ---》  SZ
	 * 香港     HK    ---》 HK
	 * 深HK  SHK   ---》 HK
	 * 沪HK  HHK   ---》 HK
	 * 中金     ZJS   ---》CF
	 * 上期     SQS   ---》SHF
	 * 郑商     ZSS   ---》ZCE
	 * 大商     DSS   ---》DCE
	 * 特转A  BJA   
	 * 特转B  BJB   
	 * 基金      JJ
	 * @param code
	 * @return
	 */
	private String getExchangeName(String code){
		String exchangeName ="-";
		if("1".equals(code)){
			exchangeName = "SH";//上海
		}else if("2".equals(code)){
			exchangeName = "SZ";//深圳
		}else if("9".equals(code)){
			exchangeName = "BJA";//特转A
		}else if("A".equals(code)){
			exchangeName = "BJB";//特转B
		}else if("B".equals(code)){
			exchangeName = "-";//特转B银行间
		}else if("C".equals(code)){
			exchangeName = "JJ";//基金
		}else if("D".equals(code)){
			exchangeName = "SH";//沪B
		}else if("G".equals(code)){
			exchangeName = "HK";//沪HK
		}else if("H".equals(code)){
			exchangeName = "SZ";//深B
		}else if("HK".equals(code)){
			exchangeName = "HK";//香港
		}else if("M".equals(code)){
			exchangeName = "CF";//中金
		}else if("N".equals(code)){
			exchangeName = "SHF";//上期
		}else if("O".equals(code)){
			exchangeName = "ZCE";//郑商
		}else if("P".equals(code)){
			exchangeName = "DCE";//大商
		}else if("S".equals(code)){
			exchangeName = "HK";//深HK
		}
		
		return exchangeName;
	}

}
