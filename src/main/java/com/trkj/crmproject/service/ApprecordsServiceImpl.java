package com.trkj.crmproject.service;

import com.trkj.crmproject.dao.ApprecordsDao;
import com.trkj.crmproject.dao.ApprovalDao;
import com.trkj.crmproject.entity.Apprecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprecordsServiceImpl implements ApprecordsService {

    @Autowired
    private ApprecordsDao apprecordsDao;

    @Override
    public int addApprecords(Apprecords apprecords) {
        return apprecordsDao.insert(apprecords);
    }
}
