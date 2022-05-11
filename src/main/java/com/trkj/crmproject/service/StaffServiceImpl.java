package com.trkj.crmproject.service;

import com.trkj.crmproject.dao.StaffDao;
import com.trkj.crmproject.entity.Staff;
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
