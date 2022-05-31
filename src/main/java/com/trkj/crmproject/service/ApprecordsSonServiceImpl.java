package com.trkj.crmproject.service;

import com.trkj.crmproject.dao.ApprecordsSonDao;
import com.trkj.crmproject.entity.ApprecordsSon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprecordsSonServiceImpl implements ApprecordsSonService {

    @Autowired
    private ApprecordsSonDao apprecordsSonDao;

    @Override
    public int addspzb(int app_records_id, int userId) {
        ApprecordsSon a=new ApprecordsSon();
        a.setApp_records_id(app_records_id);
        a.setUser_id(userId);
        a.setApp_state("待审批");
        return apprecordsSonDao.insert(a);
    }
}
