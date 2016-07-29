package com.geeku.dao.innovative;

import com.geeku.model.innovative.MemberApply;

public interface MemberApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberApply record);

    int insertSelective(MemberApply record);

    MemberApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberApply record);

    int updateByPrimaryKey(MemberApply record);
}