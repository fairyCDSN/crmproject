package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Pd;
import com.trkj.crmproject.service.PdService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.CkVo;
import com.trkj.crmproject.vo.PdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdController {

    @Autowired
    private PdService pdService;

    //盘点单  全部查询
    @GetMapping("/selectAllpd")
    public AjaxResponse selectAllpd(){
        return AjaxResponse.success(pdService.selectAllpd());
    }
    @GetMapping("/findpd")
    public AjaxResponse findpd(int pageNum, int pageSize){
        PageInfo<PdVo> info=pdService.findpd(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    //盘点单  查询全部（根据proId外键查询proName
    @GetMapping("/selectPdproName")
    public AjaxResponse selectPdproName(){
        return AjaxResponse.success(pdService.selectPdproName());
    }
}
