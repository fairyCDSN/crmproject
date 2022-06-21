package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.BaoJiaService;
import com.trkj.crmproject.service.OrdertableService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.BaoJiaVo;
import com.trkj.crmproject.vo.OrderTableVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
@Slf4j
public class OrdertableController {
    @Autowired
    private OrdertableService ordertableService;

    @GetMapping("/findOrdertable")
    public AjaxResponse findOrdertable(int pageNum, int pageSize, String user_name,String order_bh,String order_title,
                                       String khqyr,String state,String time1,String time2){
        PageInfo<OrderTableVo> info= ordertableService.findOrdertable(pageNum,pageSize,user_name,order_bh,
                order_title,khqyr,state,time1,time2);
        return AjaxResponse.success(info);
    }


}
