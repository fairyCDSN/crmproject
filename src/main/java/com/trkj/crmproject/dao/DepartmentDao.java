package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Department;
import com.trkj.crmproject.entity.mybatis_plus.DeptMp;
import com.trkj.crmproject.vo.DeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
@Mapper
public interface DepartmentDao extends BaseMapper<DeptMp> {
    int deleteByPrimaryKey(Integer department_id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer department_id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    //查询部门数量
    List<DeptVo> selectAllDept();

    List<DeptVo> selectDeptByNumOrDeptId(int number,int deptId);

    List<DeptVo> selectDeptVoByname(@Param("name")String name);

}
