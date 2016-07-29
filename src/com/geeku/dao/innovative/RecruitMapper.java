package com.geeku.dao.innovative;

import com.geeku.model.innovative.Recruit;

public interface RecruitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recruit record);

    int insertSelective(Recruit record);

    Recruit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recruit record);

    int updateByPrimaryKey(Recruit record);
}