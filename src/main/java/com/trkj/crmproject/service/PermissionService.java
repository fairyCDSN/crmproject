package com.trkj.crmproject.service;

//权限实现类

import com.trkj.crmproject.entity.mybatis.Sonmenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionService {
    public List<Sonmenu> getMenuByUname(String userName);

}
