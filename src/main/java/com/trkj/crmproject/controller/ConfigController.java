package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.mybatis.Sonmenu;
import com.trkj.crmproject.service.JwtAuthService;
import com.trkj.crmproject.service.PermissionService;
import com.trkj.crmproject.service.UserService;
import com.trkj.crmproject.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ConfigController {
    @Autowired
    private JwtAuthService jwtAuthService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserService userService;

    //登录方法
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

    //查询所有员工、部门、职务
    @GetMapping("/selectAllStaff")
    public AjaxResponse selectAllStaff(int pageNum,int pageSize){
//        log.debug(userService.selectAllStaff()+"这是查询出来的所有员工");
//        log.debug(userService.selectAllDept()+"这是查询出来的所有部门");
//        log.debug(userService.selectAllPost()+"这是查询出来的所有职务");
        return AjaxResponse.success(userService.selectAllStaff(pageNum,pageSize));
    }
    //按条件查询员工共
    @GetMapping("/selectStaffByNameOrNum")
    public AjaxResponse selectStaffByNameOrNum(int pageNum,int pageSize,String name,int bianhao){
        return AjaxResponse.success(userService.selectStaffByNameOrNum(pageNum,pageSize,name,bianhao));
    }

    //新增一个用户【同时关联职务表、部门表、用户表】
    @PostMapping("/insertUser")
    public AjaxResponse insertUser(@RequestBody StaffVo staffVo){
        log.debug("==========================");
        log.debug(staffVo+"验证一下有没有传参啊");
        log.debug("添加验证："+userService.insertStaff(staffVo));
        return AjaxResponse.success(userService.insertStaff(staffVo));
    }

    //根据用户id修改信息

    //删除用户【修改用户使用状态】

    //新增一个职务

    //删除一个职务

    //新增一个部门


}
