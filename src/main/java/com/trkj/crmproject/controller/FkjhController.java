package com.trkj.crmproject.controller;

import com.trkj.crmproject.service.ParecordService;
import com.trkj.crmproject.service.PaymentService;
import com.trkj.crmproject.service.StaffService;
import com.trkj.crmproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FkjhController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private ParecordService parecordService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/selectsgyname")
    public AjaxResponse selectsgyname(int staffId){
        return AjaxResponse.success(staffService.selectcgyname(staffId));
    }

    @GetMapping("/findfkjh")
    public AjaxResponse findfkjh(int pageNum,int pageSize){
        return AjaxResponse.success(parecordService.findfkjh(pageNum,pageSize));
    }

    @GetMapping("/selectfkjh")
    public AjaxResponse selectfkjh(int pageNum,int pageSize,String cgDh,Integer total){
        return AjaxResponse.success(parecordService.selectfkjh(pageNum,pageSize,cgDh,total));
    }

    @GetMapping("/tjqc")
    public AjaxResponse tjqc(int paId){
        System.out.println("我是传进来的paid:"+paId);
        return AjaxResponse.success(paymentService.tjqc(paId));
    }

    @GetMapping("/selectpayment")
    public AjaxResponse selectpayment(int paId){
        return AjaxResponse.success(parecordService.selectpayment(paId));
    }
}
