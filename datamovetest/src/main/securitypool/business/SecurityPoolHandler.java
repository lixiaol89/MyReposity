package com.huatai.cube.server.ts.modules.securitypool.business;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huatai.cube.server.common.utils.CubeLibrary;
import com.huatai.cube.server.ts.modules.accountposition.dao.LendingAccountPositionModelMapper;
import com.huatai.cube.server.ts.modules.accountposition.model.LendingAccountPositionModel;
import com.huatai.cube.server.ts.modules.order.model.OrderModel;
import com.huatai.cube.server.ts.modules.securityholdingdetails.dao.SecurityHoldingDetailsModelMapper;
import com.huatai.cube.server.ts.modules.securityholdingdetails.model.SecurityHoldingDetailsModel;
import com.huatai.cube.server.ts.modules.securitypool.dao.SecurityPoolModelMapper;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModel;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModelExample;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModelExample.Criteria;

/**
 * 
 * @author 011697
 *
 */
@Component
public class SecurityPoolHandler {

	@Autowired
	private SecurityPoolModelMapper securityPoolModelMapper;
	
	@Autowired
	private LendingAccountPositionModelMapper accountPositionModelMapper;
	
	@Autowired
	private SecurityHoldingDetailsModelMapper securityHoldingDetailsModelMapper;
	
	public SecurityPoolModel get(OrderModel orderModel) {
		SecurityPoolModelExample securityPoolModelExample = new SecurityPoolModelExample();
		securityPoolModelExample.or().andDateEqualTo(orderModel.getTradedate()).andUnderlyingEqualTo(orderModel.getUnderlying());
		List<SecurityPoolModel> securityPoolList = securityPoolModelMapper.selectByExample(securityPoolModelExample);
		if(securityPoolList.size()==1){
			return securityPoolList.get(0);
		}else{
			throw new RuntimeException("券池中暂未存在该标的");
		}
	}
	
	public Boolean modify(SecurityPoolModel securityPoolModel) {
		boolean success = false;
//		SecurityPoolModelExample securityPoolModelExample = new SecurityPoolModelExample();
//		securityPoolModelExample.or().andDateEqualTo(securityPoolModel.getDate()).andUnderlyingEqualTo(securityPoolModel.getUnderlying());
		if(securityPoolModelMapper.updateByUnderlyingSelective(securityPoolModel)==1){
			success = true;
		}
		return success;
	}
	
	public BigDecimal queryByUnderling(String underling, Date date){
		SecurityPoolModelExample example = new SecurityPoolModelExample();
		example.or().andUnderlyingEqualTo(underling).andDateEqualTo(date);
		List<SecurityPoolModel> securityPoolModel = securityPoolModelMapper.selectByExample(example);
		if(securityPoolModel.size()==1){
			SecurityPoolModel model = securityPoolModel.get(0);
			BigDecimal interestrate = model.getInterestrate();
			return interestrate;
		}
			return new BigDecimal(0);
		
	}
	
	public List<SecurityPoolModel> querySecurityPoollist(String underLing, String securityExchange, String underlyingName, Date startDate, Date endDate, Date date){
		SecurityPoolModelExample example = new SecurityPoolModelExample();
		Criteria criteria = example.or();
		if(underLing != null){
			criteria.andUnderlyingEqualTo(underLing);
		}
		if(securityExchange != null){
			criteria.andSecurityexchangeEqualTo(securityExchange);
		}
		if(underlyingName != null){
			criteria.andUnderlyingnameEqualTo(underlyingName);
		}
		if(startDate != null){
			criteria.andDateGreaterThanOrEqualTo(startDate);
		}
		if(endDate != null){
			criteria.andDateLessThanOrEqualTo(endDate);	
		}
		if(date != null){
			criteria.andDateEqualTo(date);
		}
		List<SecurityPoolModel> securityPoollist = securityPoolModelMapper.selectByExample(example);
		//TotalAmount，= Position+ ShortAmount+ LentAmount+ ShortedAmount
		//Position，持仓 = sum（LendingAccountPosition中相同的Underlying的持仓数量）
		//LentAmount，已借数量=sum（SecurityHoldingDetails表中此Underlying所有的LentAmount）
		//ShortAmount，卖空数量 = sum（LendingAccountPosition中相同的Underlying 的卖空数量）
		//ShortedAmount，已卖空数量 =sum（SecurityHoldingDetails表中此Underlying所有的ShortedAmount）
		for(SecurityPoolModel securityPool : securityPoollist){
			String underling = securityPool.getUnderlying();
			int position = 0;
			int shortAmount  = 0;
			LendingAccountPositionModel positionModel = accountPositionModelMapper.sumPositonByUnderling(underling);
			if(positionModel != null){
				position = positionModel.getPosition();
				shortAmount = positionModel.getShortamount();
			}
			int lentAmount = 0;
			int shortedAmount = 0;
			SecurityHoldingDetailsModel holdingDetailsModel = securityHoldingDetailsModelMapper.sumLentAmountByUnderling(underling);
			if(holdingDetailsModel != null){
				lentAmount = holdingDetailsModel.getLentamount();
				shortedAmount = holdingDetailsModel.getShortedamount();
			}
			int totalAmount = position+ shortAmount+ lentAmount+ shortedAmount;
			securityPool.setTotalamount(totalAmount);
			securityPool.setPosition(position);
			securityPool.setShortamount(shortAmount);
			securityPool.setLentamount(lentAmount);
			securityPool.setShortedamount(shortedAmount);
			securityPool.setSecurityexchange(underling.substring(underling.length()-2));
		}
		return securityPoollist;
	}
	
	public Boolean modify(OrderModel model) {
		boolean success = false;
		SecurityPoolModelExample securityPoolModelExample = new SecurityPoolModelExample();
		securityPoolModelExample.or().andUnderlyingEqualTo(model.getUnderlying()).andDateEqualTo(model.getTradedate());
		SecurityPoolModel securityPoolModel = securityPoolModelMapper.selectByExample(securityPoolModelExample).get(0);
		if(model.getProducttype()==CubeLibrary.ProductType.EquitySwap && model.getOrderside()==CubeLibrary.OrderSide.buy){
			securityPoolModel.setLockedamount(securityPoolModel.getLockedamount()-model.getCommissionshares());
			securityPoolModel.setLeftamount(securityPoolModel.getLeftamount()+model.getCommissionshares());
		}else if(model.getProducttype()==CubeLibrary.ProductType.EquitySwap && model.getOrderside()==CubeLibrary.OrderSide.sale){
			
		}else if(model.getProducttype()==CubeLibrary.ProductType.Bond && model.getOrderside()==CubeLibrary.OrderSide.buy){
			
		}else if(model.getProducttype()==CubeLibrary.ProductType.Bond && model.getOrderside()==CubeLibrary.OrderSide.sale){
			
		}
		return success;
	}
	
	
}
