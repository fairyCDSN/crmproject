package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CustomerDao;
import com.trkj.crmproject.dao.FollowDao;
import com.trkj.crmproject.entity.Follow;
import com.trkj.crmproject.entity.customer;
import com.trkj.crmproject.service.FollowService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.FollowVo;
import com.trkj.crmproject.vo.customerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowDao followDao;
    @Override
    public PageInfo<FollowVo> findFollow(int pageNum, int pageSize, String user_name,String customer_name,
                                         String follow_title, String time1,String time2) {
        Page<Follow> page= PageHelper.startPage(pageNum,pageSize);
        List<Follow> list = followDao.findFollow(user_name,customer_name,follow_title,time1,time2);
        Page<FollowVo> follows=new Page<>();
        BeanTools.copyList(list,follows,FollowVo.class);
        PageInfo<FollowVo> pageInfo=new PageInfo<>(follows);
        return pageInfo;
    }

    @Override
    public int insertFollow(Follow follow, String user_name) {
        System.out.println("aaaaaaa"+follow);
        followDao.insertFollow(follow.getFollowTitle(),follow.getCustomerId(),follow.getContact(),
                follow.getFollowDate(),follow.getFollowManner(),follow.getFollowContent(),user_name);
        return 0;
    }
}
