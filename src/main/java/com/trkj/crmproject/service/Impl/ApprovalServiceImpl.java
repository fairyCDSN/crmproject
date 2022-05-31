package com.trkj.crmproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.crmproject.dao.ApprovalDao;
import com.trkj.crmproject.entity.Approval;
import com.trkj.crmproject.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    private ApprovalDao dao;

    @Override
    public Approval selectapptype() {
        QueryWrapper<Approval> qw=new QueryWrapper<>();
        String type="采购审批";
        qw.eq("app_type",type);
        Approval approval=dao.selectOne(qw);
        System.out.println("我在impl层"+approval);
        return approval;
    }
}
