package com.huatai.cube.server.ts.modules.accountposition.service;

import com.huatai.xtrade.xstep.event.IXStepEvent;

public interface ILendingAccountPositionService {

	/**
	 * 查询持仓明细
	 * 
	 * @param request
	 * @return
	 */
	IXStepEvent querySecurityPoolDetailByManager(IXStepEvent request);

	/**
	 * 保存持仓明细
	 * 
	 * @param request
	 * @return
	 */
	IXStepEvent saveSecurityPoolDetail(IXStepEvent request);
	
	/**
	 * 同步持仓明细
	 * @param request
	 * @return
	 */
	IXStepEvent synchronizeSecurityPoolDetail(IXStepEvent request);

}
