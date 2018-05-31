package com.huatai.cube.rms.modules.mktquotation.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModel;
import com.huatai.cube.rms.modules.mktquotation.model.LivePriceModelExample;

@Component
public interface LivePriceModelMapper {
    int countByExample(LivePriceModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LivePriceModel record);

    int insertSelective(LivePriceModel record);

    List<LivePriceModel> selectByExample(LivePriceModelExample example);

    List<LivePriceModel> selectRandomByExample(LivePriceModelExample example);

    LivePriceModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LivePriceModel record);

    int updateByPrimaryKey(LivePriceModel record);
}