package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Follow;
import com.trkj.crmproject.vo.FollowVo;

public interface FollowService {
    PageInfo<FollowVo> findFollow(int pageNum, int pageSize, String user_name,String customer_name,
                                  String follow_title,String time1,String time2);
    int insertFollow(Follow follow,String user_name);
}
