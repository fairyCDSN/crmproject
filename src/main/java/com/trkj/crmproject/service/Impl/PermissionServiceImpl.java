package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.RoleDao;
import com.trkj.crmproject.dao.SonmenuDao;
import com.trkj.crmproject.entity.Sonmenu;
import com.trkj.crmproject.entity.mybatis_plus.SonmenuMp;
import com.trkj.crmproject.service.PermissionService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.util.MenuUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private SonmenuDao sonmenuDao;

    @Override
    public List<Sonmenu> getMenuByUname(String userName) {
        log.debug("getMenuByUname name"+userName);
        List<Sonmenu> list=sonmenuDao.findMenusByRoleNames(this.getRoleCodesByUname(userName));
        log.debug("直接找："+sonmenuDao.findMenusByRoleNames(this.getRoleCodesByUname(userName)).toString());
        log.debug("PermissionService:"+list.toString());
        return MenuUtil.assemberMenus(list);
    }
    private List<String> getRoleCodesByUname(String userName){
        log.debug("getRoleCodesByUname:"+roleDao.selectRoleByUserName(userName).toString());
        return roleDao.selectRoleByUserName(userName);
    }


    //查询所有菜单信息【分页】
    public List<SonmenuMp> selectAllMenus(){
//        Page<SonmenuMp> page=PageHelper.startPage(pageNum,pageSize);
        List<SonmenuMp> sonmenuMps=sonmenuDao.selectList(null);
//        Page<SonmenuMp> mps=new Page<>();
//        BeanTools.copyList(sonmenuMps,mps,SonmenuMp.class);
//        PageInfo<SonmenuMp> pageInfo=new PageInfo<>(mps);
//        log.debug("这是查询到的菜单分页信息:{}",pageInfo);
        return sonmenuMps;
    }

}
