package com.huatai.cube.rms.modules.client.service;

import com.huatai.xtrade.xstep.event.IXStepEvent;

public interface IClientService {

	
	public IXStepEvent queryClient(IXStepEvent request);
	
	public IXStepEvent dealClient(IXStepEvent request);
	
}
