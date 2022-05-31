package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.RoleDao;
import com.trkj.crmproject.service.RoleService;
import com.trkj.crmproject.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleVo> selectrolename() {
        return roleDao.selectrolename();
    }
}
