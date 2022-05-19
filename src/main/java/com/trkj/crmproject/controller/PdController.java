package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.PdService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.PdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdController {

    @Autowired
    private PdService pdService;

    //盘盘点单  查询全部（根据ckId中间表外键查询ckName
    @GetMapping("/selectPdckNameAll")
    public AjaxResponse selectPdckNameAll(){
        return AjaxResponse.success(pdService.selectPdckNameAll());
    }
    //分页
    @GetMapping("/findpd")
    public AjaxResponse findpd(int pageNum, int pageSize){
        PageInfo<PdVo> info=pdService.findpd(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    //盘点单  查询全部（根据仓库名称查询）
    @GetMapping("/selectPdckName")
    public AjaxResponse selectPdckName(String ckName){
        return AjaxResponse.success(pdService.selectPdckName(ckName));
    }
}
