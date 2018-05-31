package com.huatai.cube.server.ts.modules.securitypool.dao;

import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModel;
import com.huatai.cube.server.ts.modules.securitypool.model.SecurityPoolModelExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface SecurityPoolModelMapper {
    int countByExample(SecurityPoolModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecurityPoolModel record);

    int insertSelective(SecurityPoolModel record);

    List<SecurityPoolModel> selectByExample(SecurityPoolModelExample example);

    SecurityPoolModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecurityPoolModel record);

    int updateByPrimaryKey(SecurityPoolModel record);
    
    int updateByUnderlyingSelective(SecurityPoolModel record);
    
    SecurityPoolModel selectAllMaxDate();
}