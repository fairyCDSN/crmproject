package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.JiaoFuService;
import com.trkj.crmproject.service.PcPlanService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.JiaoFuVo;
import com.trkj.crmproject.vo.PcPlanVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
@Slf4j
public class JiaoFuController {
    @Autowired
    private JiaoFuService jiaoFuService;

    @GetMapping("/findJiaoFu")
    public AjaxResponse findJiaoFu(int pageNum, int pageSize){
        PageInfo<JiaoFuVo> info= jiaoFuService.findJiaoFu(pageNum,pageSize);
        return AjaxResponse.success(info);
    }
}
