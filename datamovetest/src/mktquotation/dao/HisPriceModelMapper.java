package com.huatai.cube.rms.modules.mktquotation.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.huatai.cube.rms.modules.mktquotation.model.HisPriceModel;
import com.huatai.cube.rms.modules.mktquotation.model.HisPriceModelExample;
@Component
public interface HisPriceModelMapper {
    int countByExample(HisPriceModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HisPriceModel record);

    int insertSelective(HisPriceModel record);

    List<HisPriceModel> selectByExample(HisPriceModelExample example);

    HisPriceModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisPriceModel record);

    int updateByPrimaryKey(HisPriceModel record);
}