package com.trkj.crmproject.controller;

import com.trkj.crmproject.service.ApprecordsSonService;
import com.trkj.crmproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApprecordsDetailsController {

    @Autowired
    private ApprecordsSonService apprecordsSonService;

    //查询采购订单
    @GetMapping("/selectAppCgsq")
    private AjaxResponse selectAppCgsq(int sqid){
        return AjaxResponse.success(apprecordsSonService.selectAppCgsq(sqid));
    }

    //查询采购商品
    @GetMapping("/selectAppCgGoods")
    private AjaxResponse selectAppCgGoods(int sqid){
        return AjaxResponse.success(apprecordsSonService.selectAppCgGoods(sqid));
    }
    //查询调拨

    //查询

    //查询

    //查询

    //查询
}
