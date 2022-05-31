package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Apprecords;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApprecordsDao {
    int deleteByPrimaryKey(Integer app_records_id);

    int insert(Apprecords record);

    int insertSelective(Apprecords record);

    Apprecords selectByPrimaryKey(Integer app_records_id);

    int updateByPrimaryKeySelective(Apprecords record);

    int updateByPrimaryKey(Apprecords record);


}