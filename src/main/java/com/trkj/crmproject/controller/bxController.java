package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.reimbursement;
import com.trkj.crmproject.service.CostdetailsService;
import com.trkj.crmproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class bxController {
        @Autowired
        private CostdetailsService costdetailsService;

    //报销记录、根据传入的数据来查询并分页
    @RequestMapping("selectbx")
    public AjaxResponse selectbx(reimbursement vo, int pageNum, int pageSize){
        System.out.println(vo);
        PageInfo<reimbursement> info=costdetailsService.selectbx(vo.getReimbursementType(),pageNum,pageSize);
        return AjaxResponse.success(info);
    }
    //报销记录、加载页面调用该方法查询全部并分页
    @GetMapping("findrb")
    public AjaxResponse findrb(int pageNum,int pageSize){
        System.out.println("11111111");
        PageInfo<reimbursement> info=costdetailsService.findrb(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
            //报销记录、根据id查询单个数据
    @RequestMapping("selectmx")
    public AjaxResponse selectmx(int cdId){
        return AjaxResponse.success(costdetailsService.selectmx(cdId));
    }
    //报销记录、根据传的id和数值来修改报销状态
    @PutMapping("/updatebxtype")
    public AjaxResponse updatebxtype(@RequestBody reimbursement costdetails){
        System.out.println("============"+costdetails);
        return AjaxResponse.success(costdetailsService.updateup(costdetails.getUp(),costdetails.getCustomerId()));
    }

}
