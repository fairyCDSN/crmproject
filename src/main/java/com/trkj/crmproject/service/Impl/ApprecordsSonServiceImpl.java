package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.ApprecordsSonDao;
import com.trkj.crmproject.dao.UsersDao;
import com.trkj.crmproject.entity.ApprecordsSon;
import com.trkj.crmproject.service.ApprecordsSonService;
import com.trkj.crmproject.vo.ApprecordsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ApprecordsSonServiceImpl implements ApprecordsSonService {

    @Autowired
    private ApprecordsSonDao apprecordsSonDao;
    @Autowired
    private UsersDao usersDao;

    @Override
    public int addspzb(int app_records_id, int userId) {
        ApprecordsSon a=new ApprecordsSon();
        a.setApp_records_id(app_records_id);
        a.setUser_id(userId);
        a.setApp_state("待审批");
        return apprecordsSonDao.insert(a);
    }
    public List<ApprecordsSon> selectApprecordsByName(String username, String state){
        //根据用户名查出用户id
        int id=usersDao.selectUserId(username);
        log.debug("这是审核子记录表当中使用的用户id：{}",id);
        //根据用户id和状态查询审核子记录表
        List<ApprecordsSon> apprecordsVos=apprecordsSonDao.selectApprecordsByName(id,state);
        log.debug("查询出来的审核记录子表：{}",apprecordsVos);
        return apprecordsVos;
    }
}
