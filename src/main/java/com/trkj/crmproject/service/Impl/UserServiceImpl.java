package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.*;
import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.entity.mybatis_plus.DeptMp;
import com.trkj.crmproject.entity.mybatis_plus.PostMp;
import com.trkj.crmproject.entity.mybatis_plus.RoleMp;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.UserService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.DeptVo;
import com.trkj.crmproject.vo.StaffVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolePerDao rolePerDao;

    //

    //查询员工信息的所有信息【员工表staff】
    public PageInfo<StaffVo> selectAllStaff(int pageNum,int pageSize){
        //分页
        Page<StaffMp> page = PageHelper.startPage(pageNum,pageSize);
        List<StaffVo> staffMpList =staffDao.selectStaffVo();
        //查询部门名称
        Page<StaffVo> staffMps=new Page<>();
        BeanTools.copyList(staffMpList,staffMps,StaffVo.class);
        PageInfo<StaffVo> pageInfo=new PageInfo<>(staffMps);
        log.debug("staff:"+ pageInfo);
        return pageInfo;
    }

    public List<StaffMp> selectAllStaff(){
        List<StaffMp> staffMpList =staffDao.selectList(null);
        return staffMpList;
    }

    public PageInfo<DeptVo> selectAllDept(int pageNum,int pageSize){
        //分页
        Page<DeptVo> page = PageHelper.startPage(pageNum,pageSize);
        List<DeptVo> deptMps =departmentDao.selectAllDept();
        log.debug("这是部门查询所有的信息：{}",deptMps);
        Page<DeptVo> depts=new Page<>();
        BeanTools.copyList(deptMps,depts,DeptVo.class);
        PageInfo<DeptVo> pageInfo=new PageInfo<>(depts);
        log.debug("dept:"+ pageInfo);
        return pageInfo;
    }

    //查询职务表【职务表post】
    public PageInfo<PostMp> selectAllPost(int pageNum,int pageSize){
        //分页
        Page<PostMp> page = PageHelper.startPage(pageNum,pageSize);
        List<PostMp> postMpList =postDao.selectList(null);
        Page<PostMp> postMps=new Page<>();
        BeanTools.copyList(postMpList,postMps,PostMp.class);
        PageInfo<PostMp> pageInfo=new PageInfo<>(postMps);
        log.debug("post:"+ pageInfo);
        return pageInfo;
    }
//
//    //查询部门表【部门表department】
    public List<DeptMp> selectAllDept(){
        return departmentDao.selectList(null);
    }
    public List<PostMp> selectAllPost(){
        return postDao.selectList(null);
    }

    //查询部门表【计算每个部门有多少人】
    public List<StaffVo> selectDept(int deptid){
        List<StaffVo> staffMps=staffDao.selectStaffByDeptId(deptid);
        log.debug("这是查询出来的员工信息：{}",staffMps);
        return staffMps;
    }


    //添加员工
    @Transactional
    public int insertStaff(StaffVo staffVo){
        int row=0;
        //从传入的表单数据staffVo中提取出员工表的信息
        //创建一个staff对象
        Staff staff=new Staff();
        staff.setStaff_name(staffVo.getStaff_name());
        staff.setStaff_sex(staffVo.getStaff_sex());
        staff.setInduction_time(staffVo.getInduction_time());
        staff.setBirthday(staffVo.getBirthday());
        staff.setStaff_qq(staffVo.getStaff_qq());
        staff.setStaff_wx(staffVo.getStaff_wx());
        staff.setStaff_txdz(staffVo.getStaff_txdz());
        staff.setDeptment_id(staffVo.getDeptment_id());
        staff.setPost_id(staffVo.getPost_id());
//        staff.set
        //从传入的表单数据staffVo中用户表的信息
        //创建一个新用户对象
        Users users=new Users();
        users.setUser_name(staffVo.getUser_name());
        users.setPhone(staffVo.getPhone());
        users.set_use(staffVo.getState()==1?true:false);
        users.setOrg_id(1);
        users.setUser_pass("$2a$10$xPNoI0sBxOY6Y5Nj1bF6iO6OePqJ8tAJUsD5x5wh6G1BPphhSLcae");
        //添加用户表
        row=usersDao.insert(users);
        //查询出新增用户表中的id，绑定员工表
        int id=usersDao.selectMaxUserId();
        staff.setUser_id(id);
        //添加staff表
        if(row>0){
            row=staffDao.insert(staff);
        }
        return row;
    }


    //条件查询员工
    public PageInfo<StaffVo> selectStaffByNameOrNum(int pageNum, int pageSize, String name , int bianhao,int deptid){
        //分页
        Page<StaffMp> page = PageHelper.startPage(pageNum,pageSize);
        List<StaffVo> staffMpList =staffDao.selectStaffByNameAndId(name,bianhao,deptid);
        Page<StaffVo> staffMps=new Page<>();
        BeanTools.copyList(staffMpList,staffMps,StaffVo.class);
        PageInfo<StaffVo> pageInfo=new PageInfo<>(staffMps);
        log.debug("staff:"+ pageInfo);
        return pageInfo;
    }

    public PageInfo<DeptVo> selectDeptByNumOrDeptName(int pageNum,int pageSize,int number,int deptId ){
        //分页
        Page<DeptVo> page = PageHelper.startPage(pageNum,pageSize);
        log.debug("number:"+number);
        log.debug("deptId:"+deptId);
        List<DeptVo> staffMpList =departmentDao.selectDeptByNumOrDeptId(number,deptId);
        log.debug("xxxxxxxxxx:"+departmentDao.selectDeptByNumOrDeptId(number,deptId));
        Page<DeptVo> staffMps=new Page<>();
        BeanTools.copyList(staffMpList,staffMps,DeptVo.class);
        PageInfo<DeptVo> pageInfo=new PageInfo<>(staffMps);
        log.debug("staff:"+ pageInfo);
        return pageInfo;
    }

    //查询每个部门的人数
    public List<StaffVo> selectCountStaff(){
        return staffDao.countStaff();
    }
    //获取部门名称【查询全部员工】
    public List<StaffVo> selectStaffDeptName() {

        return null;
    }

    //验证密码是否正确
    public List<Users> checkPass(String oldPass,String userName){
        log.debug("这是检查旧密码的实现类！");
        String pass=passwordEncoder.encode(oldPass);
        log.debug(oldPass);
        log.debug("这是根据用户名查询出来的密码：{}",staffDao.getOldPass(userName));
        log.debug("比较密码是否可以转为jwt加密模式：{}",passwordEncoder.matches(oldPass,staffDao.getOldPass(userName)));
        List<Users> list;
        if(passwordEncoder.matches(oldPass,staffDao.getOldPass(userName))){
            list=staffDao.checkPass(staffDao.getOldPass(userName),userName);
        }else{
            list=staffDao.checkPass(oldPass,userName);
        }
        return list;
    }

    //修改密码
    public int updatePass(String userName,String pass){
        int row=0;
        //密码加密
        log.debug("这是修改后的状态：{}",staffDao.updatePass(userName,staffDao.getOldPass(userName),passwordEncoder.encode(pass)));
        row=staffDao.updatePass(userName,staffDao.getOldPass(userName),passwordEncoder.encode(pass));
        if(row==0){
            throw new CustomError(CustomErrorType.ACCOUNT_ERROR,"数据更新异常");
        }
        return row;
    }

    public Role selectRoleIdAndName(String username){
        log.debug("前端传来的用户名：{}",username);
        int roleId=roleDao.selectRoleIdByUserName(username);
        String roleName=roleDao.selectRoleName(roleId);
        Role role=new Role();
        role.setRole_id(roleId);
        role.setRole_name(roleName);
        log.debug("实现类查询出来的角色信息role:{}",role);
        return role;
    }

    //查询角色
    public PageInfo<RoleMp> selectRole(int pageNum, int pageSize){
        Page<RoleMp> page=PageHelper.startPage(pageNum,pageSize);
        List<RoleMp> roleMps=roleDao.selectList(null);
        Page<RoleMp> roles=new Page<>();
        BeanTools.copyList(roleMps,roles,RoleMp.class);
        PageInfo<RoleMp> pageInfo=new PageInfo<>(roles);
        log.debug("role:{}",pageInfo);
        return pageInfo;
    }
    //查询部门和职务信息
    public StaffVo selectDeptNameAndPostNameByRole(String name){
        StaffVo staffVo=staffDao.selectDeptNameAndPostNameByRole(name);
        return staffVo;
    }

    //修改权限状态
    public int updateRole(RoleMp roleMp){
        int state=0;
        log.debug("这是修改前的状态：{}",roleMp.getIsUse());
        if(roleMp.getIsUse()==1){
            state=0;
        }else {
            state=1;
        }
        int row=roleDao.updateState(roleMp.getRoleId(),state);

        return row;
    }

    //根据角色id查询用户
    public PageInfo<StaffVo> selectUserByRoleId(int pageNum,int pageSize,int id){
        log.debug("这是实现类中的用户id:{}",id);
        Page<StaffVo> page=PageHelper.startPage(pageNum,pageSize);
        List<StaffVo> staffVos=staffDao.selectByRoleId(id);
        Page<StaffVo> staffVoPage=new Page<>();
        log.debug(staffVos.toString());
        BeanTools.copyList(staffVos,staffVoPage,StaffVo.class);
        PageInfo<StaffVo> pageInfo=new PageInfo<>(staffVoPage);
        log.debug("role:{}",pageInfo);
        return pageInfo;
    }

    //添加角色
    @Transactional
    public int insertRole(Role role){
        int row=0;
        log.debug("这是实现类接收到的role参数:{}",role);
        Role r=new Role();
        r.setRole_name(role.getRole_name());
//        获取到角色和权限id
        row=roleDao.insert(role);
        if(row==0 && role.getRole_name()==null){
            throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
        }
        //获取到角色id
        log.debug(role.getRole_id()+"这是角色id");
        //添加菜单权限
        for(int i=0;i<role.getRole_menus().size();i++){
            //循环添加
            RolePer rolePer=new RolePer();
            rolePer.setRole_id(role.getRole_id());
            rolePer.setSon_id(role.getRole_menus().get(i));
            log.debug("这是角色和菜单的中间表："+rolePer);
            //添加数据
            row=rolePerDao.insert(rolePer);
            if(row==0 && rolePer==null){
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
            }
        }
        return row;
    }

    //按角色标识符查询菜单
    public List<Integer> selectMenusByRole_name(int id){
        List<Integer> sonmenuList=rolePerDao.selectMenusByRole_name(id);
        log.debug("菜单id"+sonmenuList);
        return sonmenuList;
    }

    public int updateRoleMenus(List<Integer> ids,int roleId){
        int row=0;
        log.debug("开始删除");
        //先根据id删除菜单权限
        row=rolePerDao.deleteMenus(roleId);
        if(row==0 && roleId==0){
            throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
        }
        log.debug("删除成功");
        log.debug("开始添加");
        //再根据新的id添加新菜单权限
        for(int i=0;i<ids.size();i++){
            //循环添加
            RolePer rolePer=new RolePer();
            rolePer.setRole_id(roleId);
            rolePer.setSon_id(ids.get(i));
            log.debug("这是角色和菜单的中间表："+rolePer);
            //添加数据
            row=rolePerDao.insert(rolePer);
            if(row==0 && rolePer==null){
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR);
            }
        }
        log.debug("添加成功");

        return row;
    }
}
