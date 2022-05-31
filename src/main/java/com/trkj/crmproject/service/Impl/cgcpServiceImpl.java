package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.CgcpDao;
import com.trkj.crmproject.entity.Cgcp;
import com.trkj.crmproject.service.cgcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cgcpServiceImpl implements cgcpService {

    @Autowired
    private CgcpDao cgcpDao;

    @Override
    public int addcgcp(Cgcp cgcp) {
        return cgcpDao.insert(cgcp);
    }
}
