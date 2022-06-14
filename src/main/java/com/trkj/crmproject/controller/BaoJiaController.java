package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.mybatis_plus.Product;
import com.trkj.crmproject.entity.product;
import com.trkj.crmproject.service.BaoJiaService;
import com.trkj.crmproject.service.CustomerService;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.BaoJiaVo;
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
        PageInfo<BaoJiaVo> info= baoJiaService.findBaojia(pageNum,pageSize,user_name,customer_name,state, time1,time2,salesperson_id);
        System.out.println(info+"ijsdbfjhasbdfjhabsfdja");
        return AjaxResponse.success(info);
    }

    @PostMapping("/insertProduct")
    public AjaxResponse insertProduct(@RequestBody product[] ss,int user_id,String jfstyle,String plan_jftime){
        System.out.println(ss[0]+"asdasdasfdjkvbasdjkbnglaskjdbfakl"+user_id+jfstyle+plan_jftime);
        baoJiaService.insertProduct(ss,user_id,jfstyle,plan_jftime);
        return AjaxResponse.success();
    }
}
