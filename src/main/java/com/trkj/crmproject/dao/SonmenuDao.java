package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Sonmenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SonmenuDao {
    int deleteByPrimaryKey(Integer son_id);

    int insert(Sonmenu record);

    int insertSelective(Sonmenu record);

    Sonmenu selectByPrimaryKey(Integer son_id);

    int updateByPrimaryKeySelective(Sonmenu record);

    int updateByPrimaryKey(Sonmenu record);

    //根据角色查询菜单地址
    List<String> findAuthorityByRoleNames(@Param("roleNames") List<String> roleNames);

    //根据角色查询权限
    List<Sonmenu> findMenusByRoleNames(@Param("roleNames") List<String> roleNames);
}
