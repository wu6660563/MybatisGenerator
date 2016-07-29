package com.geeku.dao.innovative;

import com.geeku.model.innovative.RecruitMember;

public interface RecruitMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecruitMember record);

    int insertSelective(RecruitMember record);

    RecruitMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecruitMember record);

    int updateByPrimaryKey(RecruitMember record);
}