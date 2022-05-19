package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.StaffDao;
import com.trkj.crmproject.entity.Staff;
import com.trkj.crmproject.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao dao;

    @Override
    public List<Staff> selectcgyid() {
        return dao.selectcgyid();
    }
}
