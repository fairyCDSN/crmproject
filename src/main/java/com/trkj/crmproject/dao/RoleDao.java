package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Role;
import com.trkj.crmproject.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleDao {
    int deleteByPrimaryKey(Integer role_id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer role_id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    //根据用户角色关系表联立用户表查询角色信息【多表查询】
    List<String> selectRoleByUserName(String username);

    //查询角色为采购审批的角色名称
    List<RoleVo> selectrolename();
}
