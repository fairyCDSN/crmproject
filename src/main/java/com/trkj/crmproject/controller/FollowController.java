package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Follow;
import com.trkj.crmproject.entity.jfjl;
import com.trkj.crmproject.service.CustomerService;
import com.trkj.crmproject.service.FollowService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.FollowVo;
import com.trkj.crmproject.vo.customerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@Slf4j
public class FollowController {
    @Autowired
    private FollowService followService;

    @GetMapping("/findFollow")
    public AjaxResponse findFollow(int pageNum, int pageSize,String user_name,String customer_name,String follow_title,
                                    String time1,String time2){
        PageInfo<FollowVo> info=followService.findFollow(pageNum,pageSize,user_name,customer_name,follow_title,
                                                        time1,time2);
        return AjaxResponse.success(info);
    }
    @PostMapping("/insertFollow")
    public AjaxResponse insertFollow(@RequestBody Follow follow,String user_name){
        followService.insertFollow(follow,user_name);
        return AjaxResponse.success();
    }
}
