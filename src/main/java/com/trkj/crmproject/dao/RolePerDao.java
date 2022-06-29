package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.RolePer;
import com.trkj.crmproject.entity.Sonmenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
@Component
public interface RolePerDao extends BaseMapper<RolePer> {
    int deleteByPrimaryKey(Integer role_pre_id);

    int insert(RolePer record);

    int insertSelective(RolePer record);

    RolePer selectByPrimaryKey(Integer role_pre_id);

    int updateByPrimaryKeySelective(RolePer record);

    int updateByPrimaryKey(RolePer record);

    List<Integer> selectMenusByRole_name(@Param("id") int id);

    int deleteMenus(@Param("id") int id);

    List<Integer> selectRoleIds(@Param("id") int id);
}
