package com.trkj.crmproject.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.DepartmentDao;
import com.trkj.crmproject.dao.PostDao;
import com.trkj.crmproject.dao.StaffDao;
import com.trkj.crmproject.dao.UsersDao;
import com.trkj.crmproject.entity.Caigou;
import com.trkj.crmproject.entity.mybatis.Staff;
import com.trkj.crmproject.entity.mybatis.Users;
import com.trkj.crmproject.entity.mybatis_plus.DeptMp;
import com.trkj.crmproject.entity.mybatis_plus.PostMp;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.SelectParam;
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

    //

    //查询员工信息的所有信息【员工表staff】
    public PageInfo<StaffMp> selectAllStaff(int pageNum,int pageSize){
        //分页
        Page<StaffMp> page = PageHelper.startPage(pageNum,pageSize);
        List<StaffMp> staffMpList =staffDao.selectList(null);
        Page<StaffMp> staffMps=new Page<>();
        BeanTools.copyList(staffMpList,staffMps,StaffMp.class);
        PageInfo<StaffMp> pageInfo=new PageInfo<>(staffMps);
        log.debug("staff:"+ pageInfo);
        return pageInfo;
    }
    public PageInfo<DeptMp> selectAllDept(int pageNum,int pageSize){
//        System.out.println("这是调用了密码加密后，原密码为：12dajslhkd 加密后为："+passwordEncoder.encode("12dajslhkd"));
        //分页
        Page<DeptMp> page = PageHelper.startPage(pageNum,pageSize);
        List<DeptMp> deptMps =departmentDao.selectList(null);
        Page<DeptMp> depts=new Page<>();
        BeanTools.copyList(deptMps,depts,DeptMp.class);
        PageInfo<DeptMp> pageInfo=new PageInfo<>(depts);
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
    public PageInfo<StaffMp> selectStaffByNameOrNum(int pageNum, int pageSize, String name , int bianhao){
        //分页
        Page<StaffMp> page = PageHelper.startPage(pageNum,pageSize);
        List<StaffMp> staffMpList =staffDao.selectStaffByNameAndId(name,bianhao);
        Page<StaffMp> staffMps=new Page<>();
        BeanTools.copyList(staffMpList,staffMps,StaffMp.class);
        PageInfo<StaffMp> pageInfo=new PageInfo<>(staffMps);
        log.debug("staff:"+ pageInfo);
        return pageInfo;
    }

}
