package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.Sonmenu;
import com.trkj.crmproject.service.JwtAuthService;
import com.trkj.crmproject.service.PermissionService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.LoginVo;
import com.trkj.crmproject.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/user")
@Slf4j
public class customerController {
    @Autowired
    private JwtAuthService jwtAuthService;
    @Autowired
    private PermissionService permissionService;

    @PostMapping("/login")
    private AjaxResponse index(@RequestBody LoginVo loginVo){
        log.debug("开始验证,{}",loginVo.getUsername()+loginVo.getPassword());
        //获取页面上的用户名和密码
        String token =jwtAuthService.login(loginVo.getUsername(),loginVo.getPassword());
        //创建一个新的用户对象
        UserVo userVo=new UserVo();
        userVo.setUsername(loginVo.getUsername());
        userVo.setValidate(true);
        userVo.setToken(token);
        List<Sonmenu> sonMenus=permissionService.getMenuByUname(loginVo.getUsername());
        userVo.setMenus(sonMenus);
        log.debug(userVo+"这是Controller中的实体类");
        return AjaxResponse.success(userVo);
    }



}
