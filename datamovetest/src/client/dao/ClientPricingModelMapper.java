package com.huatai.cube.rms.modules.client.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.huatai.cube.rms.modules.client.model.ClientPricingModel;
import com.huatai.cube.rms.modules.client.model.ClientPricingModelExample;
@Component
public interface ClientPricingModelMapper {
    int countByExample(ClientPricingModelExample example);

    int deleteByExample(ClientPricingModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClientPricingModel record);

    int insertSelective(ClientPricingModel record);

    List<ClientPricingModel> selectByExample(ClientPricingModelExample example);

    ClientPricingModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClientPricingModel record, @Param("example") ClientPricingModelExample example);

    int updateByExample(@Param("record") ClientPricingModel record, @Param("example") ClientPricingModelExample example);

    int updateByPrimaryKeySelective(ClientPricingModel record);

    int updateByPrimaryKey(ClientPricingModel record);
}