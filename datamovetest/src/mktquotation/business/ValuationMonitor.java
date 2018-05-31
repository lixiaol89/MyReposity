package com.huatai.cube.rms.modules.mktquotation.business;

import com.huatai.cube.rms.modules.client.dao.ClientModelMapper;
import com.huatai.cube.rms.modules.client.service.impl.ClientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by 012737 on 2018/3/5.
 */
public class ValuationMonitor {
    private final static Logger logger = LoggerFactory.getLogger(ValuationMonitor.class);

    @Resource(name="clientModelMapper")
    ClientModelMapper clientModelMapper;


}
