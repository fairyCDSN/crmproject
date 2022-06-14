package com.trkj.crmproject.service;

//权限实现类

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Sonmenu;
import com.trkj.crmproject.entity.mybatis_plus.SonmenuMp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionService {
    public List<Sonmenu> getMenuByUname(String userName);

    //查询所有的菜单信息【分页】
    public List<SonmenuMp> selectAllMenus();

}
