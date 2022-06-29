package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.DepartmentDao;
import com.trkj.crmproject.dao.DeptsonDao;
import com.trkj.crmproject.entity.Department;
import com.trkj.crmproject.entity.Deptson;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.DeptService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.DeptUserVo;
import com.trkj.crmproject.vo.DeptVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptsonDao deptsonDao;
    @Autowired
    private DepartmentDao departmentDao;

    public List<Deptson> selectDeptSon(int id){
        List<Deptson> deptsons=deptsonDao.selectDeptSon(id);
        return deptsons;
    }

    public PageInfo<DeptVo> selectDeptVoByname(int pageNum,int pageSize,String name){
//        List<DeptVo> deptVos=departmentDao.selectDeptVoByname(name);
//        return deptVos;
        Page<DeptVo> page = PageHelper.startPage(pageNum,pageSize);
        List<DeptVo> deptMps =departmentDao.selectDeptVoByname(name);
        log.debug("这是部门查询所有的信息：{}",deptMps);
        Page<DeptVo> depts=new Page<>();
        BeanTools.copyList(deptMps,depts,DeptVo.class);
        PageInfo<DeptVo> pageInfo=new PageInfo<>(depts);
        log.debug("dept:"+ pageInfo);
        return pageInfo;
    }

    public int addDept(Department department, Deptson deptson){
        int row=0;
        if(department==null){
            log.debug("开始添加子部门");
            row=departmentDao.insert(department);
            if(row<=0){
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败");
            }
        }else{
            log.debug("开始添加父部门表");
            row=deptsonDao.insert(deptson);
            if(row<=0){
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败");
            }
        }
        log.debug("添加部门成功");
        return row;
    }

    public DeptUserVo selectUser(int id){
        return deptsonDao.selectUser(id);
    }

    public List<DeptUserVo> selectDeptSonDetails(int id){
        return deptsonDao.selectDeptSonDetails(id);
    }
}
