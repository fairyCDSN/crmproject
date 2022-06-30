package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.CorecordDao;
import com.trkj.crmproject.entity.Corecord;
import com.trkj.crmproject.service.CorecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorecordServiceImpl implements CorecordService {

    @Autowired
    private CorecordDao corecordDao;

    @Override
    public int insert(Corecord record) {
        return corecordDao.insert(record);
    }
}
