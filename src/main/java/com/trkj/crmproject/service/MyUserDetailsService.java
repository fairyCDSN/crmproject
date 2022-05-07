package com.trkj.crmproject.service;


import com.trkj.crmproject.dao.RoleDao;
import com.trkj.crmproject.dao.SonmenuDao;
import com.trkj.crmproject.dao.UsersDao;
import com.trkj.crmproject.entity.Sonmenu;
import com.trkj.crmproject.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:自定义的UserDetailsService业务实现类
 * @version 1.0
 */
@Slf4j
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private SonmenuDao sonmenuDao;
    //重写loadUserByUsername方法
    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("已经进入了MyUserDetailService");
        log.debug(username);
        //接收表单传来的用户信息进行查询
        Users myUserDetails = usersDao.selectByUserName(username);
        log.debug("这是myUserDetails"+myUserDetails.toString());
        //如果该用户不存在
        if(myUserDetails==null){
            //抛出错误信息
            throw new UsernameNotFoundException("用户不存在");
        }
        //开始查询该用户的角色信息【多表联查】
        List<String> roleNames=roleDao.selectRoleByUserName(myUserDetails.getUser_name());
        log.debug(roleNames+"这是角色信息的名称");
        //多表联查权限信息【根据权限名称】
        List<String> authorities=sonmenuDao.findAuthorityByRoleNames(roleNames);
        log.debug("这是权限信息:"+authorities);
//      为角色标识加上ROLE_前缀（Spring Security规范）
        roleNames = roleNames.stream()
                .map(rc -> "ROLE_" + rc)
                .collect(Collectors.toList());
        log.debug("这是规范后的角色前缀"+roleNames);
        //将规范好的角色标识存入权限当中
        authorities.addAll(roleNames);
        log.debug("这是规范好的权限信息:"+authorities);
        //设置用户权限，成用逗号分隔的字符串，为用户设置权限标识
        myUserDetails.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(
                String.join(",",authorities)
        ));
        log.debug("设置用户权限:"+myUserDetails);
        return myUserDetails;
    }
}
