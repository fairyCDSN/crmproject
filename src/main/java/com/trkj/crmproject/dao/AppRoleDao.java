package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.AppRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface AppRoleDao {

    int insert(AppRole record);

    AppRole selectByPrimaryKey(Integer app_role_id);

    int delectAppRole(@Param("id") int id,@Param("appId")int appId);

    int delectById(@Param("id")int id);
}
