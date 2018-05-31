package com.huatai.cube.server.ts.modules.securitypool.business;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huatai.cube.server.common.utils.CubeLibrary;
import com.huatai.cube.server.ts.modules.order.model.OrderModel;
import com.huatai.cube.server.ts.modules.securitypool.dao.SecurityPoolModelMapper;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModel;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModelExample;

/**
 * 
 * @author 011697
 *
 */
@Component
public class SecurityPoolHandler {

	@Autowired
	private SecurityPoolModelMapper securityPoolModelMapper;
	
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
	
}
