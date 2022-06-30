package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.CgcpDao;
import com.trkj.crmproject.entity.Cgcp;
import com.trkj.crmproject.service.cgcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class cgcpServiceImpl implements cgcpService {

    @Autowired
    private CgcpDao cgcpDao;

    @Override
    @Transactional
    public int addcgcp(Cgcp cgcp) {
        return cgcpDao.insert(cgcp);
    }

    @Override
    public List<Cgcp> findscgcp(int supplierId) {
        return cgcpDao.findscgcp(supplierId);
    }
}
