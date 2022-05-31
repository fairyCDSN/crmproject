package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.ApprecordsSon;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApprecordsSonDao {
    int deleteByPrimaryKey(Integer apprecords_son_id);

    int insert(ApprecordsSon record);

    int insertSelective(ApprecordsSon record);

    ApprecordsSon selectByPrimaryKey(Integer apprecords_son_id);

    int updateByPrimaryKeySelective(ApprecordsSon record);

    int updateByPrimaryKey(ApprecordsSon record);
}