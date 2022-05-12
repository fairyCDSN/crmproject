package com.trkj.crmproject.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.DepartmentDao;
import com.trkj.crmproject.dao.PostDao;
import com.trkj.crmproject.dao.StaffDao;
import com.trkj.crmproject.entity.Caigou;
import com.trkj.crmproject.entity.mybatis.Staff;
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
import org.springframework.stereotype.Service;

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

//    //查询职务表【职务表post】
//    public List<PostMp> selectAllPost(){
//        return postDao.selectList(null);
//    }
//
//    //查询部门表【部门表department】
//    public List<DeptMp> selectAllDept(){
//        return departmentDao.selectList(null);
//    }

    //添加员工
    public int insertStaff(StaffVo staffVo){
        int row=0;
        //添加staff表
        row=staffDao.insert(staffVo);
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
