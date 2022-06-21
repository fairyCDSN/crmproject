package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.OrdertableService;
import com.trkj.crmproject.service.PcPlanService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.OrderTableVo;
import com.trkj.crmproject.vo.PcPlanVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
@Slf4j
public class PcPlanController {
    @Autowired
    private PcPlanService pcPlanService;

    @GetMapping("/findPcplan")
    public AjaxResponse findPcplan(int pageNum, int pageSize,String qs, String state,String monery1,String monery2,String user_name){
        PageInfo<PcPlanVo> info= pcPlanService.findPcplan(pageNum,pageSize,qs,state,monery1,monery2,user_name);
        return AjaxResponse.success(info);
    }
}
