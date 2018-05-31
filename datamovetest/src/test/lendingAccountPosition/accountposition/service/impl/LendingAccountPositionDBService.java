package com.huatai.cube.server.ts.modules.accountposition.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huatai.cube.server.ts.modules.accountposition.dao.LendingAccountPositionModelMapper;
import com.huatai.cube.server.ts.modules.accountposition.model.LendingAccountPositionModel;
import com.huatai.cube.server.ts.modules.accountposition.model.LendingAccountPositionModelExample;
import com.huatai.cube.server.ts.modules.securitypool.dao.SecurityPoolModelMapper;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModel;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModelExample;

/**
 * 保存持仓明细入库操作
 * @author K0180007
 *
 */
@Service
public class LendingAccountPositionDBService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LendingAccountPositionDBService.class);
	
	@Autowired
	private LendingAccountPositionModelMapper securityDetailModelMapper;
	
	@Autowired
	private SecurityPoolModelMapper securityPoolModelMapper;
	
	
	@Transactional(readOnly=false,rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public String insertSecurityPoolDetail(LendingAccountPositionModel detail, String lastUpdateUser){
		LOGGER.info("insertSecurityPoolDetail");
		Date lastDate = new Date();
		int detailResult = -1;
		String resultMsg = null;
		//产品账户、资产账户、交易员账户、证券账户(股东代码)、证券代码、日期为一个Key
    	LendingAccountPositionModelExample example = new LendingAccountPositionModelExample();
		example.or().andProductaccountEqualTo(detail.getProductaccount())
		  		.andAssetaccountEqualTo(detail.getAssetaccount())
		  		.andTradingaccountEqualTo(detail.getTradingaccount())
				.andSecurityaccountEqualTo(detail.getSecurityaccount())
				.andUnderlyingEqualTo(detail.getUnderlying())
				.andDateEqualTo(detail.getDate());
    	List<LendingAccountPositionModel> spList = securityDetailModelMapper.selectByExample(example);
		if (spList != null && !spList.isEmpty()) {
			// 存在，更新
			detail.setId(spList.get(0).getId());
			// 锁券数量不更新
			detail.setLockedposition(null);
			detail.setLockedshortamount(null);
			detailResult = securityDetailModelMapper.updateByPrimaryKeySelective(detail);
			if(detailResult <= 0){
				return "更新持仓明细失败";
			}
		} else {
			//查询最近日期的锁券数量，若查询不到，则默认0
			int lockedPosition = 0;
			int lockedShortAmount = 0;
        	//最近时间
			LendingAccountPositionModel lastPositionModel = securityDetailModelMapper.selectAccountPositionMaxDate(detail);
			if(lastPositionModel != null && lastPositionModel.getDate() != null){
				lastDate = lastPositionModel.getDate();
			}
			LendingAccountPositionModelExample lastexample = new LendingAccountPositionModelExample();
			lastexample.or().andProductaccountEqualTo(detail.getProductaccount())
			  		.andAssetaccountEqualTo(detail.getAssetaccount())
			  		.andTradingaccountEqualTo(detail.getTradingaccount())
					.andSecurityaccountEqualTo(detail.getSecurityaccount())
					.andUnderlyingEqualTo(detail.getUnderlying())
					.andDateEqualTo(lastDate);
	    	List<LendingAccountPositionModel> lastList = securityDetailModelMapper.selectByExample(lastexample);
	    	if(lastList != null && !lastList.isEmpty()){
	    		lockedPosition = lastList.get(0).getLockedposition();
	    		lockedShortAmount = lastList.get(0).getLockedshortamount();
	    	}
			
        	detail.setLockedposition(lockedPosition);
        	detail.setLockedshortamount(lockedShortAmount);
			// 不存在，新增
			detailResult = securityDetailModelMapper.insert(detail);
			if(detailResult <= 0){
				return "新增持仓明细失败";
			}
		}
		// 持仓明细新增成功后，同步券池汇总
		SecurityPoolModelExample securityPoolExample = new SecurityPoolModelExample();
		securityPoolExample.or().andUnderlyingEqualTo(detail.getUnderlying()).andDateEqualTo(detail.getDate());
		List<SecurityPoolModel> securityPoolList = securityPoolModelMapper.selectByExample(securityPoolExample);
		// 先查询有无此日期的证券代码，没有，则新增，有，则更新
		if (securityPoolList != null && !securityPoolList.isEmpty()) {
			// 当前总数量
			int currentSumAmount = securityPoolList.get(0).getTotalamount();
			// 当前持仓
			int currentPosition = securityPoolList.get(0).getPosition();
			// 当前卖空数量
			int currentShortAmount = securityPoolList.get(0).getShortamount();
			LendingAccountPositionModel currentDetail = securityDetailModelMapper.selectSumByUnderlying(detail);
			if (currentDetail != null) {
				// 总数量=持仓 + 已借数量 + 卖空 + 已卖空数量
				currentSumAmount = currentDetail.getPosition() + currentDetail.getShortamount()
						+ securityPoolList.get(0).getLentamount() + securityPoolList.get(0).getShortedamount();
				currentPosition = currentDetail.getPosition();
				currentShortAmount = currentDetail.getShortamount();
				SecurityPoolModel securityPool = new SecurityPoolModel();
				securityPool.setTotalamount(currentSumAmount);
				securityPool.setPosition(currentPosition);
				securityPool.setShortamount(currentShortAmount);
				securityPool.setUnderlying(detail.getUnderlying());
				securityPool.setLastupdateuser(lastUpdateUser);
				securityPool.setLastupdatetime(new Date());
				securityPool.setDate(detail.getDate());
				// 更新
				securityPoolModelMapper.updateByUnderlyingSelective(securityPool);
			}
		} else {
			SecurityPoolModel securityPool = new SecurityPoolModel();
			String underlying = detail.getUnderlying();
			securityPool.setUnderlying(underlying);
			securityPool.setUnderlyingname(detail.getUnderlyingname());
			//证券代码格式：003293.sz
			if(underlying.contains(".")){
				String exchangeCode = underlying.substring(underlying.indexOf(".")+1, underlying.length());
				securityPool.setSecurityexchange(exchangeCode);
			}else{
				securityPool.setSecurityexchange("-");
			}
			securityPool.setPosition(detail.getPosition());
			securityPool.setShortamount(detail.getShortamount());
			securityPool.setTotalamount(detail.getPosition() + detail.getShortamount());
			// 可借数量、剩余可借、利率、已借、锁券,可卖空、已卖空 初始值为0
			int lendableamount= 0;
			int leftamount= 0;
			int lentamount= 0;
			int lockedamount= 0;
			int shortableamount= 0;
			int shortedamount = 0;
			BigDecimal interestrate = new BigDecimal(0);
			SecurityPoolModelExample lastPoolExample = new SecurityPoolModelExample();
			lastPoolExample.or().andUnderlyingEqualTo(detail.getUnderlying()).andDateEqualTo(lastDate);
			List<SecurityPoolModel> lastPoolList = securityPoolModelMapper.selectByExample(lastPoolExample);
			if(lastPoolList != null && !lastPoolList.isEmpty()){
				lendableamount = lastPoolList.get(0).getLendableamount(); 
				leftamount = lastPoolList.get(0).getLeftamount(); 
				lentamount = lastPoolList.get(0).getLentamount(); 
				lockedamount = lastPoolList.get(0).getLockedamount(); 
				shortableamount = lastPoolList.get(0).getShortableamount(); 
				shortedamount = lastPoolList.get(0).getShortedamount(); 
				interestrate = lastPoolList.get(0).getInterestrate();
			}
			securityPool.setLendableamount(lendableamount);
			securityPool.setLeftamount(leftamount);
			securityPool.setInterestrate(interestrate);
			securityPool.setLentamount(lentamount);
			securityPool.setLockedamount(lockedamount);
			securityPool.setShortableamount(shortableamount);
			securityPool.setShortedamount(shortedamount);
			securityPool.setLastupdateuser(lastUpdateUser);
			securityPool.setLastupdatetime(new Date());
			securityPool.setDate(new Date());
			//入库
			securityPoolModelMapper.insert(securityPool);
		}		
		return resultMsg;
	}

}
