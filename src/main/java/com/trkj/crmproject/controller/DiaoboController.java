package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Diaobo;
import com.trkj.crmproject.service.DiaoboService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.DiaoboVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DiaoboController {

    @Autowired
    private DiaoboService diaoboService;

    //分页
    @GetMapping("/finddb")
    public AjaxResponse finddb(int pageNum, int pageSize){
        PageInfo<DiaoboVo> info=diaoboService.finddb(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    //调拨详情  根据调拨id查询商品信息
    @GetMapping("/selectDbidproName")
    public AjaxResponse selectDbidproName(int dbId){
        return AjaxResponse.success(diaoboService.selectDbidproName(dbId));
    }
    //调拨详情 根据调拨id查询调拨信息
    @GetMapping("/selectDbidxq")
    public AjaxResponse selectDbidxq(int dbId){
        return AjaxResponse.success(diaoboService.selectDbidxq(dbId));
    }

    //调拨管理  修改
    @PutMapping("/updateDbidbz")
    public AjaxResponse updateDbidbz(@RequestBody Diaobo diaobo){
        log.debug("调拨修改数据"+diaobo);
        return AjaxResponse.success(diaoboService.updateDbidbz(diaobo));
    }
}
