package com.trkj.crmproject.service;

import com.trkj.crmproject.entity.Users;
import com.trkj.crmproject.vo.AddVo;

public interface UsersService {
    public Users[] findUserName(String user_name);
    public int selectUserId(String user_name);
}
