package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.mybatis.Staff;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import com.trkj.crmproject.vo.SelectParam;
import com.trkj.crmproject.vo.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
@Mapper
public interface StaffDao extends BaseMapper<StaffMp> {
    int deleteByPrimaryKey(Integer staff_id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staff_id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    public List<Staff> selectcgyid();

//    //条件查询
//    public List<StaffMp> selectStaffByName(String name);
//
//    public List<StaffMp> selectStaffById(int id);

    public List<StaffMp> selectStaffByNameAndId(String name,int id);
}
