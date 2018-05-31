package com.huatai.cube.rms.modules.client.service;

import com.huatai.xtrade.xstep.event.IXStepEvent;

public interface IClientPricingService {
	
	public IXStepEvent queryClientPricings(IXStepEvent request); 
	
	public IXStepEvent dealClientPricings(IXStepEvent request); 

}
