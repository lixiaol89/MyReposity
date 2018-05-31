package com.huatai.cube.rms.modules.client.dao;

import com.huatai.cube.rms.modules.client.model.ClientPricingModel;
import com.huatai.cube.rms.modules.client.model.ClientPricingModelExample;
import com.huatai.cube.rms.modules.client.model.ClientPricingModelWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientPricingModelMapper {
    int countByExample(ClientPricingModelExample example);

    int deleteByExample(ClientPricingModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClientPricingModelWithBLOBs record);

    int insertSelective(ClientPricingModelWithBLOBs record);

    List<ClientPricingModelWithBLOBs> selectByExampleWithBLOBs(ClientPricingModelExample example);

    List<ClientPricingModel> selectByExample(ClientPricingModelExample example);

    ClientPricingModelWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClientPricingModelWithBLOBs record, @Param("example") ClientPricingModelExample example);

    int updateByExampleWithBLOBs(@Param("record") ClientPricingModelWithBLOBs record, @Param("example") ClientPricingModelExample example);

    int updateByExample(@Param("record") ClientPricingModel record, @Param("example") ClientPricingModelExample example);

    int updateByPrimaryKeySelective(ClientPricingModelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ClientPricingModelWithBLOBs record);

    int updateByPrimaryKey(ClientPricingModel record);
}