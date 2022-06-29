package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Corecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CorecordDao {
    int deleteByPrimaryKey(Integer co_id);

    int insert(Corecord record);

    int insertSelective(Corecord record);

    Corecord selectByPrimaryKey(Integer co_id);

    int updateByPrimaryKeySelective(Corecord record);

    int updateByPrimaryKey(Corecord record);

}