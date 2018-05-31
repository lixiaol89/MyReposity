package com.huatai.cube.server.ts.modules.lendingAccountPosition.dao;

import com.huatai.cube.server.ts.modules.lendingAccountPosition.model.LendingAccountPositionModel;
import com.huatai.cube.server.ts.modules.lendingAccountPosition.model.LendingAccountPositionModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LendingAccountPositionModelMapper {
    int countByExample(LendingAccountPositionModelExample example);

    int deleteByExample(LendingAccountPositionModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LendingAccountPositionModel record);

    int insertSelective(LendingAccountPositionModel record);

    List<LendingAccountPositionModel> selectByExample(LendingAccountPositionModelExample example);

    LendingAccountPositionModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LendingAccountPositionModel record, @Param("example") LendingAccountPositionModelExample example);

    int updateByExample(@Param("record") LendingAccountPositionModel record, @Param("example") LendingAccountPositionModelExample example);

    int updateByPrimaryKeySelective(LendingAccountPositionModel record);

    int updateByPrimaryKey(LendingAccountPositionModel record);
}