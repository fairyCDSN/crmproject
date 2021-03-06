package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Cggoods;
import com.trkj.crmproject.service.CggoodsService;
import com.trkj.crmproject.service.SupplierService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.CggoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class goodsController {

    @Autowired
    private CggoodsService service;

    @Autowired
    private SupplierService supplierService;
    //采购商品查询全部商品
    @GetMapping("/findgoods")
    public AjaxResponse findgoods(int pageNum,int pageSize){
        PageInfo<CggoodsVo> list=service.findgoods(pageNum,pageSize);
        System.out.println("=========="+list);
        return AjaxResponse.success(list);
    }

    @GetMapping("/selectgoods")
    public AjaxResponse selectgoods(int pageNum,int pageSize,String gdName,String type,String name){
        if (gdName==""){
            gdName=null;
        }
        if (type==""){
            type=null;
        }
        if (name==""){
            name=null;
        }
        PageInfo<CggoodsVo> pageInfo=service.selectgoods(pageNum,pageSize,gdName,type,name);
        return AjaxResponse.success(pageInfo);
    }

    @RequestMapping("/updategoods")
    public AjaxResponse updategoods(Cggoods cggoods,int pageNum,int pageSize,String gdname,String type,String name){
        if (gdname==""){
            gdname=null;
        }
        if (type==""){
            type=null;
        }
        if (name==""){
            name=null;
        }
        PageInfo<CggoodsVo> row=service.updategoods(cggoods.getCgNumber(),cggoods.getGdId(),pageNum,pageSize,gdname,type,name);
        return AjaxResponse.success(row);
    }

    @RequestMapping("/updategoodsjs")
    public AjaxResponse updategoodsjs(Cggoods cggoods,int pageNum,int pageSize,String gdname,String type,String name){
        if (gdname==""){
            gdname=null;
        }
        if (type==""){
            type=null;
        }
        if (name==""){
            name=null;
        }
        PageInfo<CggoodsVo> row=service.updategoodsjs(cggoods.getCgNumber(),cggoods.getGdId(),pageNum,pageSize,gdname,type,name);
        return AjaxResponse.success(row);
    }

    @GetMapping("/findgoodstype")
    public AjaxResponse findgoodstype(){
        List<String> a=service.findgoodstype();
        System.out.println(a+"=========");
        return AjaxResponse.success(a);
    }

    @GetMapping("/selectgysnameandgd")
    public AjaxResponse selectgysnameandgd(String type){
        System.out.println(type);
        List<String> a=supplierService.findstaffgys(type);
        return AjaxResponse.success(a);
    }

}
