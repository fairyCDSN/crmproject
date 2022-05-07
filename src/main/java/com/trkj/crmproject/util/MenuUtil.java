package com.trkj.crmproject.util;

import com.trkj.crmproject.entity.Sonmenu;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MenuUtil {
    public static List<Sonmenu> assemberMenus(List<Sonmenu> menus){
        //筛选出父类id=0的菜单集合
        log.debug("assemberMenus:"+menus.toString());
        List<Sonmenu> one=menus.stream().filter(u -> u.getFather_id()==0).collect(Collectors.toList());
        log.debug(one.toString());
        one.forEach(o->{
            //筛选侧边子菜单
            List<Sonmenu> two=menus.stream().filter(u -> u.getFather_id()==o.getSon_id()).collect(Collectors.toList());
            o.setAsideChildren(two);
            log.debug(o+"");
        });
        return one;
    }
    public static List<String> assemberAuthorities(List<Sonmenu> menus){
        List<String> authorities=menus.stream().map(u->u.getUrl()).collect(Collectors.toList());
        return authorities;
    }
}

