package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Cgcp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CgcpDao {
    int deleteByPrimaryKey(Integer gd_id);

    int insert(Cgcp record);

    int insertSelective(Cgcp record);

    Cgcp selectByPrimaryKey(Integer gd_id);

    int updateByPrimaryKeySelective(Cgcp record);

    int updateByPrimaryKey(Cgcp record);
}