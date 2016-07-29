package com.geeku.dao.innovative;

import com.geeku.model.innovative.InnovativeProject;

public interface InnovativeProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InnovativeProject record);

    int insertSelective(InnovativeProject record);

    InnovativeProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InnovativeProject record);

    int updateByPrimaryKey(InnovativeProject record);
}