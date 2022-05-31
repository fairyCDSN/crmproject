package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Pd;
import com.trkj.crmproject.service.PdService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.PdVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
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


    //盘点单  查询userName当前登录的人的staffId
    @GetMapping("/selectPdUserName")
    public AjaxResponse selectPdUserName(String userName){
        return AjaxResponse.success(pdService.selectPdUserName(userName));
    }
    //盘点单  添加
    @PostMapping("/insertPd")
    public AjaxResponse insertPd(@RequestBody Pd pd){
        log.debug("盘点单传回的数据"+pd);
        return AjaxResponse.success(pdService.insertPd(pd));
    }


    //盘点单 根据盘点ID查询盘点信息
    @GetMapping("/selectPdId")
    public AjaxResponse selectPdId(int pdId){
        return AjaxResponse.success(pdService.selectPdId(pdId));
    }

    //盘点单 修改,四表改
    @PutMapping("/updatePd")
    public AjaxResponse updatePd(@RequestBody Pd pd){
        log.debug("盘点单修改数据："+pd);
        return AjaxResponse.success(pdService.updatePd(pd));
    }
}
