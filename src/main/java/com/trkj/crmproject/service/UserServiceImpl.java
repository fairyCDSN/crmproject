package com.trkj.crmproject.service;

import com.trkj.crmproject.dao.DepartmentDao;
import com.trkj.crmproject.dao.PostDao;
import com.trkj.crmproject.dao.StaffDao;
import com.trkj.crmproject.entity.mybatis_plus.DeptMp;
import com.trkj.crmproject.entity.mybatis_plus.PostMp;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
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
    public List<StaffMp> selectAllStaff(){
        List<StaffMp> staffMpList =staffDao.selectList(null);
        log.debug("staff:"+ staffMpList);
        return staffMpList;
    }

    //查询职务表【职务表post】
    public List<PostMp> selectAllPost(){
        return postDao.selectList(null);
    }

    //查询部门表【部门表department】
    public List<DeptMp> selectAllDept(){
        return departmentDao.selectList(null);
    }

    //添加员工
    public int insertStaff(StaffVo staffVo){
        int row=0;
        //添加staff表
        row=staffDao.insert(staffVo);
        return row;
    }

}
