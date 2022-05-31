package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.CustomerDao;
import com.trkj.crmproject.dao.UsersDao;
import com.trkj.crmproject.entity.Users;
import com.trkj.crmproject.service.UsersService;
import com.trkj.crmproject.vo.AddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;

    @Override
    public Users[] findUserName(String user_name) {
        return usersDao.findUserName(user_name);
    }

    @Override
    public int selectUserId(String user_name) {
        return usersDao.selectUserId(user_name);
    }

}
