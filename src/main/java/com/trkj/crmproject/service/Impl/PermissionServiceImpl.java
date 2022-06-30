package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.RoleDao;
import com.trkj.crmproject.dao.RolePerDao;
import com.trkj.crmproject.dao.SonmenuDao;
import com.trkj.crmproject.entity.RolePer;
import com.trkj.crmproject.entity.Sonmenu;
import com.trkj.crmproject.entity.mybatis_plus.SonmenuMp;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.PermissionService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.util.MenuUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private SonmenuDao sonmenuDao;
    @Autowired
    private RolePerDao rolePerDao;

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

    @Transactional
    public int addMenus(Sonmenu sonmenu){
        //添加菜单
        int row= sonmenuDao.insert(sonmenu);
        //根据当前添加的父类菜单id
        log.debug("菜单子类id：，{}",sonmenu.getSon_id());
        //如果是父类菜单，则直接添加Boss权限
        if(sonmenu.getFather_id()==0){
            RolePer rolePer= new RolePer();
            rolePer.setSon_id(sonmenu.getSon_id());
            rolePer.setRole_id(1);
            row=rolePerDao.insert(rolePer);
            if(row<=0){
                throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
            }
            log.debug("父类菜单添加成功！");
        }else{
            //添加子类菜单
            //根据父类菜单id查询所有拥有父类权限的子菜单
            List<Integer> role_ids=rolePerDao.selectRoleIds(sonmenu.getFather_id());
            for(int c=0;c<role_ids.size();c++){
                RolePer rolePer=new RolePer();
                rolePer.setSon_id(sonmenu.getSon_id());
                rolePer.setRole_id(role_ids.get(c));
                row=rolePerDao.insert(rolePer);
                if(row<=0){
                    throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
                }
            }
            log.debug("子类菜单权限添加成功！");
        }
        return row;
    }

}
