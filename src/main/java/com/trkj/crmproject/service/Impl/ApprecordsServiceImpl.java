package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.ApprecordsDao;
import com.trkj.crmproject.dao.ApprovalDao;
import com.trkj.crmproject.dao.UsersDao;
import com.trkj.crmproject.entity.Apprecords;
import com.trkj.crmproject.service.ApprecordsService;
import com.trkj.crmproject.vo.ApprecordsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ApprecordsServiceImpl implements ApprecordsService {

    @Autowired
    private ApprecordsDao apprecordsDao;


    @Override
    @Transactional
    public int addApprecords(Apprecords apprecords) {
        System.out.println(apprecords+"========输出");
        return apprecordsDao.insert(apprecords);
    }

}
