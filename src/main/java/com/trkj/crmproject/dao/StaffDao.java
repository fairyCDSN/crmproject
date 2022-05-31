package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Staff;
import com.trkj.crmproject.entity.Users;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
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

    int insert(Staff record);

    public List<Staff> selectcgyid();

    public List<StaffVo> selectStaffByNameAndId(String name,int id,int deptid);

    public List<StaffVo> selectStaffByDeptId(int deptid);

    List<StaffVo> countStaff();

    String getOldPass(@Param("name") String userName);

    List<Users> checkPass(@Param("pass") String oldPass,@Param("name") String userName);

    int updatePass(@Param("name") String userName,@Param("pass") String oldPass,@Param("newPass") String NewPass);

    List<StaffVo> selectByRoleId();

    List<StaffVo> selectByRoleId(@Param("id") int id);

    List<StaffVo> selectStaffVo();

    StaffVo selectDeptNameAndPostNameByRole(@Param("name") String name);

}
