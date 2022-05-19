package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Cggoods;
import com.trkj.crmproject.service.CggoodsService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.CggoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class goodsController {

    @Autowired
    private CggoodsService service;
    //采购商品查询全部商品
    @GetMapping("/findgoods")
    public AjaxResponse findgoods(int pageNum,int pageSize){
        PageInfo<CggoodsVo> list=service.findgoods(pageNum,pageSize);
        System.out.println("=========="+list);
        return AjaxResponse.success(list);
    }

    @GetMapping("/selectgoods")
    public AjaxResponse selectgoods(int pageNum,int pageSize,String gdName){
        PageInfo<CggoodsVo> pageInfo=service.selectgoods(pageNum,pageSize,gdName);
        return AjaxResponse.success(pageInfo);
    }

    @RequestMapping("/updategoods")
    public AjaxResponse updategoods(Cggoods cggoods,int pageNum,int pageSize,String gdname){
        PageInfo<CggoodsVo> row=service.updategoods(cggoods.getGdNumber(),cggoods.getGdId(),pageNum,pageSize,gdname);
        return AjaxResponse.success(row);
    }

    @RequestMapping("/updategoodsjs")
    public AjaxResponse updategoodsjs(Cggoods cggoods,int pageNum,int pageSize,String gdname){
        PageInfo<CggoodsVo> row=service.updategoodsjs(cggoods.getGdNumber(),cggoods.getGdId(),pageNum,pageSize,gdname);
        return AjaxResponse.success(row);
    }

}
