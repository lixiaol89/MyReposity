package com.huatai.cube.server.ts.modules.accountposition.dao;

import com.huatai.cube.server.ts.modules.accountposition.model.LendingAccountPositionModel;
import com.huatai.cube.server.ts.modules.accountposition.model.LendingAccountPositionModelExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface LendingAccountPositionModelMapper {
    int countByExample(LendingAccountPositionModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LendingAccountPositionModel record);

    int insertSelective(LendingAccountPositionModel record);

    List<LendingAccountPositionModel> selectByExample(LendingAccountPositionModelExample example);

    LendingAccountPositionModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LendingAccountPositionModel record);

    int updateByPrimaryKey(LendingAccountPositionModel record);
    
    List<LendingAccountPositionModel> selectDetailAndPriorityByUnderlying(String underlying);
    
    LendingAccountPositionModel selectSumByUnderlying(LendingAccountPositionModel record);
    
    int updateByOnlyKeySelective(LendingAccountPositionModel record);
    /**
     * 查询所有明细的最新时间
     * @return
     */
    LendingAccountPositionModel selectAllMaxDate();
    /**
     * 查询某一持仓明细的最新时间
     * @param record
     * @return
     */
    LendingAccountPositionModel selectAccountPositionMaxDate (LendingAccountPositionModel record);
}