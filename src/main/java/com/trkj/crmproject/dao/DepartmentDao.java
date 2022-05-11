package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.mybatis.Department;
import com.trkj.crmproject.entity.mybatis_plus.DeptMp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
}
