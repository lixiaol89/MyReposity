/**
 * 
 */
package com.huatai.cube.rms.modules.mktquotation.service;

import com.huatai.xtrade.xstep.event.IXStepEvent;

/**
 * @author 006562
 *
 */
public interface IPriceService {
	
	public IXStepEvent queryPriceDetails(IXStepEvent request);
	
}
