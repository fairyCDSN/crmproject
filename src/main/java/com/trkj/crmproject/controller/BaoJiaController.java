package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.ProductXq;
import com.trkj.crmproject.entity.jfjl;
import com.trkj.crmproject.entity.mybatis_plus.Product;
import com.trkj.crmproject.entity.product;
import com.trkj.crmproject.service.BaoJiaService;
import com.trkj.crmproject.service.CustomerService;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.BaoJiaVo;
import com.trkj.crmproject.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@Slf4j
public class BaoJiaController {
    @Autowired
    private BaoJiaService baoJiaService;

    @GetMapping("/findBaojia")
    public AjaxResponse findBaojia(int pageNum, int pageSize,String user_name, String customer_name,String state,
                                     String time1, String time2,int salesperson_id){
        PageInfo<BaoJiaVo> info= baoJiaService.findBaojia(pageNum,pageSize,user_name,customer_name,
                state, time1,time2,salesperson_id);
        return AjaxResponse.success(info);
    }

    @PostMapping("/insertProduct")
    public AjaxResponse insertProduct(@RequestBody ProductVo[] ss,int contact_id,int user_id, String jfstyle, String plan_jftime,int customer_id,String title){
        baoJiaService.insertProduct(ss,user_id,jfstyle,plan_jftime,customer_id,title,contact_id);
        return AjaxResponse.success();
    }

    @PostMapping("/insertProduct1")
    public AjaxResponse insertProduct1(@RequestBody ProductVo[] ss,int bjid){
        baoJiaService.insertProduct1(ss,bjid);
        return AjaxResponse.success();
    }

    @GetMapping("/findConName")
    public AjaxResponse findConName(int customer_id){
        return AjaxResponse.success(baoJiaService.findConName(customer_id));
    }

    @GetMapping("/findConXq1")
    public AjaxResponse findConXq1(int contact_id){
        return AjaxResponse.success(baoJiaService.findConXq1(contact_id));
    }

    @GetMapping("/findProXq")
    public AjaxResponse findProXq(int bjid){
        return AjaxResponse.success(baoJiaService.findProXq(bjid));
    }

    @GetMapping("/findProXq1")
    public AjaxResponse findProXq1(int pro_id){
        return AjaxResponse.success(baoJiaService.findProXq1(pro_id));
    }

    @DeleteMapping("/deletepro")
    public AjaxResponse deletepro(int pro_id,int bjid){
        return AjaxResponse.success(baoJiaService.deletepro(pro_id,bjid));
    }

    @PostMapping("/updatepro")
    public AjaxResponse updatepro(@RequestBody ProductXq[] ss, int bjid){
        return AjaxResponse.success(baoJiaService.updatepro(ss,bjid));
    }
    @GetMapping("/findjfjl")
    public AjaxResponse findjfjl(int bjid){
        return AjaxResponse.success(baoJiaService.findjfjl(bjid));
    }
    @GetMapping("/findjfjl1")
    public AjaxResponse findjfjl1(int bjid,String user_name){
        return AjaxResponse.success(baoJiaService.findjfjl1(bjid,user_name));
    }

    @PostMapping("/insertjiaofu")
    public AjaxResponse insertjiaofu(int bjid,String user_name){
        baoJiaService.insertjiaofu(bjid,user_name);
        return AjaxResponse.success();
    }

    @DeleteMapping("/delectjiaofu")
    public AjaxResponse delectjiaofu(int jf_id,int state_id){
        return AjaxResponse.success(baoJiaService.delectjiaofu(jf_id,state_id));
    }
    @PostMapping("/insertordertable")
    public AjaxResponse insertordertable(@RequestBody jfjl[] jfjl,String fk, String user_name,String beizhu,
                                         String order_bh,String order_title){
        baoJiaService.insertordertable(jfjl,fk,user_name,beizhu,order_bh,order_title);
        return AjaxResponse.success();
    }

}
