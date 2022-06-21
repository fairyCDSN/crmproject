package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Cgcp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CgcpDao {
    int deleteByPrimaryKey(Integer gd_id);

    int insert(Cgcp record);

    int insertSelective(Cgcp record);

    Cgcp selectByPrimaryKey(Integer gd_id);

    int updateByPrimaryKeySelective(Cgcp record);

    int updateByPrimaryKey(Cgcp record);

    List<Cgcp> findscgcp(int supplierId);


}