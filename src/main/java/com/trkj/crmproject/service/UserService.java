package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.mybatis_plus.DeptMp;
import com.trkj.crmproject.entity.mybatis_plus.PostMp;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import com.trkj.crmproject.vo.StaffVo;

import java.util.List;

public interface UserService {
    public PageInfo<StaffMp> selectAllStaff(int pageNum, int pageSize);
    public PageInfo<PostMp> selectAllPost(int pageNum, int pageSize);
    public PageInfo<DeptMp> selectAllDept(int pageNum, int pageSize);
    public List<StaffMp> selectAllStaff();
    public List<DeptMp> selectAllDept();
    public List<PostMp> selectAllPost();

    public List<StaffMp> selectDept(int deptid);

    public int insertStaff(StaffVo staffVo);
    //条件查询
    public PageInfo<StaffMp> selectStaffByNameOrNum(int pageNum, int pageSize,String name,int bianhao,int deptid);

    public List<StaffVo> selectCountStaff();
}
