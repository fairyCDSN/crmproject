package com.trkj.crmproject.service;

import com.trkj.crmproject.entity.mybatis_plus.DeptMp;
import com.trkj.crmproject.entity.mybatis_plus.PostMp;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import com.trkj.crmproject.vo.StaffVo;

import java.util.List;

public interface UserService {
    public List<StaffMp> selectAllStaff();
    public List<PostMp> selectAllPost();
    public List<DeptMp> selectAllDept();
    public int insertStaff(StaffVo staffVo);
}
