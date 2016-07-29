package com.geeku.dao.innovative;

import com.geeku.model.innovative.InComments;

public interface InCommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InComments record);

    int insertSelective(InComments record);

    InComments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InComments record);

    int updateByPrimaryKey(InComments record);
}