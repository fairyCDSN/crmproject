package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.entity.mybatis_plus.RoleMp;
import com.trkj.crmproject.service.DeptService;
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
//@RequestMapping("/Config")
public class ConfigController {
    @Autowired
    private JwtAuthService jwtAuthService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserService userService;
    @Autowired
    private DeptService deptService;

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
        log.debug("这是控制层的部门信息：{}",userService.selectAllDept(pageNum,pageSize));
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

    @GetMapping("/selectDeptByNumOrDeptName")
    public AjaxResponse selectDeptByNumOrDeptName(int pageNum,int pageSize,int number,int deptId){
        log.debug("不知道这是什么："+userService.selectDeptByNumOrDeptName(pageNum,pageSize,number,deptId));
        return AjaxResponse.success(userService.selectDeptByNumOrDeptName(pageNum,pageSize,number,deptId));
    }

    //查询每个部门多少人数
    @GetMapping("/selectCountStaff")
    public AjaxResponse selectCountStaff(){
        return AjaxResponse.success(userService.selectCountStaff());
    }

    //根据登录的人查询角色id和角色名称
    @GetMapping("/selectRoleId")
    public AjaxResponse selectRole(String username){
        log.debug("controller中的role:{}",userService.selectRoleIdAndName(username));
        return AjaxResponse.success(userService.selectRoleIdAndName(username));
    }

    //根据登录的人查询部门和职务名称
    @GetMapping("/selectDeptNameAndPostNameByRole")
    public AjaxResponse selectDeptNameAndPostNameByRole(String username){
        log.debug("这是查询部门和职务：{}",userService.selectDeptNameAndPostNameByRole(username));
        return AjaxResponse.success(userService.selectDeptNameAndPostNameByRole(username));
    }

    //新增一个用户【同时关联职务表、部门表、用户表】
    @PostMapping("/insertUser")
    public AjaxResponse insertUser(@RequestBody StaffVo staffVo){
        log.debug("==========================");
        log.debug(staffVo+"验证一下有没有传参啊");
//        log.debug("添加验证："+userService.insertStaff(staffVo));
        return AjaxResponse.success(userService.insertStaff(staffVo));
    }

    //查询旧密码是否正确
    @GetMapping("/checkPass")
    public AjaxResponse checkPass(String oldPass,String userName){
        log.debug("进入检查旧密码的方法！");
        return AjaxResponse.success(userService.checkPass(oldPass,userName));
    }

    //修改密码
    @PostMapping("/updatePass")
    public AjaxResponse updatePass(@RequestBody Users user){
        log.debug("查看传的参数：{}，{}",user.getUser_name(),user.getUser_pass());
        return AjaxResponse.success(userService.updatePass(user.getUser_name(),user.getUser_pass()));
    }

    //查询角色信息
    @GetMapping("/selectRole")
    public AjaxResponse selectRole(int pageNum,int pageSize){
        PageInfo<RoleMp> roleMpPageInfo=userService.selectRole(pageNum,pageSize);
        log.debug("这是controller中接收到的实体类：{}",roleMpPageInfo);
        return AjaxResponse.success(roleMpPageInfo);
    }

    //修改角色状态
    @PutMapping("/updateRole")
    public AjaxResponse updateRole(@RequestBody RoleMp role){
        log.debug("这是controller中接收到的修改对象：{}",role);
        return AjaxResponse.success(userService.updateRole(role));
    }

    //查询用户根据角色id
    @GetMapping("/selectUserByRoleId")
    public AjaxResponse selectUserByRoleId(int pageNum,int pageSize,int id){
        log.debug("这是角色id:{}",id);
        return AjaxResponse.success(userService.selectUserByRoleId(pageNum,pageSize,id));
    }

    //添加角色
    @PostMapping("/insertRole")
    public AjaxResponse insertRole(@RequestBody Role role){
        log.debug("这是controller中接收到的role参数:{}",role);
//        Role r=new Role();
//        log.debug(r.getRole_id()+"这是角色id");
        return AjaxResponse.success(userService.insertRole(role));
    }

    //按角色标识符查询菜单
    @GetMapping("/selectMenusByRole_name")
    public AjaxResponse selectMenusByRole_name(int roleId){
        return AjaxResponse.success(userService.selectMenusByRole_name(roleId));
    }

    //修改角色菜单权限
    @PostMapping("/updateRoleMenus")
    public AjaxResponse updateRoleMenus(@RequestBody Map<String,Object> datas){
        log.debug("这是新的菜单id集合:{}",datas.get("ids"));
        log.debug("这是role_id:{}",datas.get("roleId"));
        List<Integer> ids= (List<Integer>) datas.get("ids");
        int role_id= (int) datas.get("roleId");
        return AjaxResponse.success(userService.updateRoleMenus(ids,role_id));
    }

    //查询子部门信息
    @GetMapping("/selectDeptSon")
    public AjaxResponse selectDeptSon(int id){
        return AjaxResponse.success(deptService.selectDeptSon(id));
    }

    @GetMapping("/selectByName")
    public AjaxResponse selectByName(int pageNum, int pageSize, String name){
        return AjaxResponse.success(deptService.selectDeptVoByname(pageNum,pageSize,name));
    }

    @PostMapping("/addDept")
    public AjaxResponse addDept(@RequestBody Map<String,Object> maps){
        //判断是否存在 父id
        Department department=new Department();
        Deptson deptson=new Deptson();
        if(Integer.parseInt(String.valueOf(maps.get("father_id")))==0){
            //没有父类id【添加父类部门表】
            department=new Department();
            department.setDepartment_name(String.valueOf(maps.get("dept_name")));
            department.setDepartment_address(String.valueOf(maps.get("bz")));
        }else{
            //添加子表
            deptson=new Deptson();
            deptson.setDept_id(Integer.parseInt(String.valueOf(maps.get("father_id"))));
            deptson.setDept_son_name(String.valueOf(maps.get("dept_name")));
            deptson.setState(Integer.parseInt(String.valueOf(maps.get("state"))));
            deptson.setBz(String.valueOf(maps.get("bz")));
            deptson.setUser_id(1);
        }
        return AjaxResponse.success(deptService.addDept(department,deptson));
    }

    @GetMapping("/selectUser")
    public AjaxResponse selectUser(int son_id){
        return  AjaxResponse.success(deptService.selectUser(son_id));
    }

    @GetMapping("/selectDeptSonDetails")
    public AjaxResponse selectDeptSonDetails(int son_id){
        return AjaxResponse.success(deptService.selectDeptSonDetails(son_id));
    }

    //验证用户名是否重复
    @GetMapping("/validateUser")
    public AjaxResponse validateUser(String userName){
        return AjaxResponse.success(userService.validateUser(userName));
    }

    @GetMapping("/selectUserStaff")
    public AjaxResponse selectUser(String username){
        return AjaxResponse.success(userService.selectUser(username));
    }

}
