package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.jfjl;
import com.trkj.crmproject.service.BaoJiaService;
import com.trkj.crmproject.service.OrdertableService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.BaoJiaVo;
import com.trkj.crmproject.vo.OrderTableVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findOrderTableXq")
    public AjaxResponse findOrderTableXq(int order_id){
        return AjaxResponse.success(ordertableService.findOrderTableXq(order_id));
    }

    @GetMapping("/selectApp")
    public AjaxResponse selectApp(int sqid,int app_id){
        return AjaxResponse.success(ordertableService.selectApp(sqid,app_id));
    }
    @GetMapping("/selectStages")
    public AjaxResponse selectStages(int order_id){
        return AjaxResponse.success(ordertableService.selectStages(order_id));
    }
    @GetMapping("/selectCk")
    public AjaxResponse selectCk(){
        return AjaxResponse.success(ordertableService.selectCk());
    }
    @PostMapping("/updateJiaoFu")
    public AjaxResponse updateJiaoFu(@RequestBody jfjl jfjl,int ck_id){
        return AjaxResponse.success(ordertableService.updateJiaoFu(jfjl,ck_id));
    }

}
