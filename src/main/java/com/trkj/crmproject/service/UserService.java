package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.mybatis.Staff;
import com.trkj.crmproject.entity.mybatis_plus.DeptMp;
import com.trkj.crmproject.entity.mybatis_plus.PostMp;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import com.trkj.crmproject.vo.SelectParam;
import com.trkj.crmproject.vo.StaffVo;

import java.util.List;

public interface UserService {
    public PageInfo<StaffMp> selectAllStaff(int pageNum, int pageSize);
//    public List<PostMp> selectAllPost();
//    public List<DeptMp> selectAllDept();
    public int insertStaff(StaffVo staffVo);
    //条件查询
    public PageInfo<StaffMp> selectStaffByNameOrNum(int pageNum, int pageSize,String name,int bianhao);
}
