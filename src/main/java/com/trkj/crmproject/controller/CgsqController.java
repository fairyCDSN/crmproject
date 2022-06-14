package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Caigousq;
import com.trkj.crmproject.service.CaigousqService;
import com.trkj.crmproject.service.RoleService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.CaigousqVo;
import com.trkj.crmproject.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CgsqController {

    @Autowired
    private CaigousqService caigousqService;


    @GetMapping("/findcgsq")
    public AjaxResponse findcgsq(int pageNum,int pageSize){
        PageInfo<Caigousq> caigousqPageInfo=caigousqService.findpur(pageNum,pageSize);
        return AjaxResponse.success(caigousqPageInfo);
    }

    @GetMapping("/selectcgsqdd")
    public AjaxResponse selectcgsqdd(int pageNum,int pageSize,String cgDh,Integer total){
        System.out.println("==============="+total+cgDh);
        PageInfo<Caigousq> caigousqPageInfo=caigousqService.selectcgsqdd(pageNum,pageSize,cgDh,total);
        return AjaxResponse.success(caigousqPageInfo);
    }
    //查询采购明细
    @GetMapping("/selectcgmx")
    public AjaxResponse selectcgmx(int sqid){
        System.out.println("=========我是selectcgmx方法:"+sqid);
        List<CaigousqVo> list=caigousqService.selectcgmx(sqid);
        System.out.println("这里是controller++++="+list);
        return AjaxResponse.success(list);
    }
    @GetMapping("/selectcgsqid")
    public AjaxResponse selectcgsqid(int sqid){
        Caigousq caigousq=caigousqService.selectcgsqid(sqid);
        return AjaxResponse.success(caigousq);
    }

}
