package com.geeku.dao.innovative;

import com.geeku.model.innovative.InProjectFile;

public interface InProjectFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InProjectFile record);

    int insertSelective(InProjectFile record);

    InProjectFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InProjectFile record);

    int updateByPrimaryKey(InProjectFile record);
}