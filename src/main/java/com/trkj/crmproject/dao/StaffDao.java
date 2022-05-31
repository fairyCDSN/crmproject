package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Staff;
import com.trkj.crmproject.entity.Users;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import com.trkj.crmproject.vo.StaffVo;
import com.trkj.crmproject.vo.cgyVo;
import com.trkj.crmproject.vo.staffnameVo;
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

    public List<StaffMp> selectStaffByNameAndId(String name,int id,int deptid);

    public List<StaffMp> selectStaffByDeptId(int deptid);

    List<StaffVo> countStaff();

    List<Users> checkPass(@Param("pass") String oldPass,@Param("name") String userName);

    //查询角色为1（采购审批类型）的员工
    staffnameVo selectsfattname(int roleId);

    cgyVo selectcgyname(int staffId);
}
