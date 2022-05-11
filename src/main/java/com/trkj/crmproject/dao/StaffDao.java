package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffDao {
    int deleteByPrimaryKey(Integer staff_id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staff_id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    public List<Staff> selectcgyid();
}