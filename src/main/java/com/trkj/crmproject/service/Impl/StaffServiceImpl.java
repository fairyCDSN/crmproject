package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.StaffDao;
import com.trkj.crmproject.entity.Staff;
import com.trkj.crmproject.service.StaffService;
import com.trkj.crmproject.vo.cgyVo;
import com.trkj.crmproject.vo.staffnameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao dao;

    

    @Override
    public List<Staff> selectcgyid() {
        return dao.selectcgyid();
    }

    @Override
    public List<staffnameVo> selectsfattname(int[] roleId) {
        List<staffnameVo> list = new ArrayList<>();
        for (int i=0;i<=roleId.length-1;i++){
            staffnameVo l=dao.selectsfattname(roleId[i]);
            System.out.println("==========impl层"+l);
            list.add(l);
        }
        return list;
    }

    @Override
    public cgyVo selectcgyname(int staffId) {
        return dao.selectcgyname(staffId);
    }
}
