package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.Sonmenu;
import com.trkj.crmproject.service.Impl.JwtAuthService;
import com.trkj.crmproject.service.PermissionService;
import com.trkj.crmproject.service.UserService;
import com.trkj.crmproject.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        //获取页面上的用户名和密码[生成token]
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
        return AjaxResponse.success(userService.selectAllStaff(pageNum,pageSize));
    }
    @GetMapping("/selectStaff")
    public AjaxResponse selectAllStaff(){
        return AjaxResponse.success(userService.selectAllStaff());
    }
    @GetMapping("/selectAllDept")
    public AjaxResponse selectAllDept(int pageNum,int pageSize){
        return AjaxResponse.success(userService.selectAllDept(pageNum,pageSize));
    }
    @GetMapping("/selectAllPost")
    public AjaxResponse selectAllPost(int pageNum,int pageSize){
        return AjaxResponse.success(userService.selectAllPost(pageNum,pageSize));
    }
    @GetMapping("/selectDept")
    public AjaxResponse selectAllDept(){
        return AjaxResponse.success(userService.selectAllDept());
    }
    @GetMapping("/selectPost")
    public AjaxResponse selectAllPost(){
        return AjaxResponse.success(userService.selectAllPost());
    }
    //根据部门查询员工
    @GetMapping("/selectStaffByDept")
    public AjaxResponse selectStaffByDept(int DeptId){
        return AjaxResponse.success(userService.selectDept(DeptId));
    }


    //按条件查询员工[名字或id的模糊查询]
    @GetMapping("/selectStaffByNameOrNum")
    public AjaxResponse selectStaffByNameOrNum(int pageNum,int pageSize,String name,int bianhao,int deptId){
        log.debug(deptId+"这是条件查询钟的部门id");
        return AjaxResponse.success(userService.selectStaffByNameOrNum(pageNum,pageSize,name,bianhao,deptId));
    }

    //查询每个部门多少人数
    @GetMapping("/selectCountStaff")
    public AjaxResponse selectCountStaff(){
        return AjaxResponse.success(userService.selectCountStaff());
    }

    //新增一个用户【同时关联职务表、部门表、用户表】
    @PostMapping("/insertUser")
    public AjaxResponse insertUser(@RequestBody StaffVo staffVo){
        log.debug("==========================");
        log.debug(staffVo.getDeptment_id()+"验证一下有没有传参啊");
        log.debug("添加验证："+userService.insertStaff(staffVo));
        return AjaxResponse.success();
    }

    //查询旧密码是否正确
    @GetMapping("/checkPass")
    public AjaxResponse checkPass(String oldPass,String userName){
        return AjaxResponse.success(userService.checkPass(oldPass,userName));
    }

    //修改密码
//    @PostMapping("/updateUser")
//    public AjaxResponse updataUser(@RequestBody){
//        return AjaxResponse.success();
//    }


}
