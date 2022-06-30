package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Department;
import com.trkj.crmproject.entity.Deptson;
import com.trkj.crmproject.vo.DeptUserVo;
import com.trkj.crmproject.vo.DeptVo;

import java.util.List;

public interface DeptService {
    public List<Deptson> selectDeptSon(int id);

    public PageInfo<DeptVo> selectDeptVoByname(int pageNum, int pageSize, String name);

    public int addDept(Department department,Deptson deptson);

    public DeptUserVo selectUser(int id);

    public List<DeptUserVo> selectDeptSonDetails(int id);
}
