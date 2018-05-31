package com.huatai.cube.rms.modules.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.huatai.cube.rms.modules.client.model.ClientModel;
import com.huatai.cube.rms.modules.client.model.ClientModelExample;

@Component
public interface ClientModelMapper {
    int countByExample(ClientModelExample example);

    int deleteByExample(ClientModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClientModel record);

    int insertSelective(ClientModel record);

    List<ClientModel> selectByExample(ClientModelExample example);

    ClientModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClientModel record, @Param("example") ClientModelExample example);

    int updateByExample(@Param("record") ClientModel record, @Param("example") ClientModelExample example);

    int updateByPrimaryKeySelective(ClientModel record);

    int updateByPrimaryKey(ClientModel record);
}