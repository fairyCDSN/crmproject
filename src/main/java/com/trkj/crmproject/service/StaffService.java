package com.trkj.crmproject.service;

import com.trkj.crmproject.entity.Staff;
import com.trkj.crmproject.vo.cgyVo;
import com.trkj.crmproject.vo.staffnameVo;

import java.util.List;

public interface StaffService {
    public List<Staff> selectcgyid();
    public List<staffnameVo> selectsfattname(int[] roleId);
    public cgyVo selectcgyname(int staffId);
}
