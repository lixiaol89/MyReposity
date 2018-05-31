package com.huatai.cube.server.ts.modules.securitypool.service;

import com.huatai.cube.server.ts.modules.order.model.OrderModel;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModel;
import com.huatai.xtrade.xstep.event.IXStepEvent;

public interface ISecurityPoolManageService {
    
    /**
     * 查询券池
     * @param request
     * @return
     */
    IXStepEvent querySecurityPoolByManager(IXStepEvent request);
    
    /**
     * 根据证券代码修改可借数量和利率
     * @param request
     * @return
     */
    IXStepEvent editAbleBorrowAmountAndInterestRate(IXStepEvent request);
    
    /**
     * 查询券池
     * @param request
     * @return
     */
    IXStepEvent querySecurityPoolByCustomer(IXStepEvent request);
    
    public SecurityPoolModel get(OrderModel orderModel);
    
    public Boolean modify(SecurityPoolModel securityPoolModel);
}
