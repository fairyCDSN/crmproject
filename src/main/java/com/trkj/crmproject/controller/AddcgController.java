package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.service.*;
import com.trkj.crmproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddcgController {

    @Autowired
    private cgcpService cgcpservice;

    @Autowired
    private CaigousqService caigousqService;

    @Autowired
    private ApprecordsService apprecordsService;

    @Autowired
    private ApprecordsSonService apprecordsSonService;

    @Autowired
    private ParecordService parecordService;

    //采购商品添加
    @PostMapping("addcgcp")
    public AjaxResponse addcgcp(@RequestBody Cgcp[] good){
        int j=0;
        for (int i=0;i<=good.length-1;i++){
            System.out.println("==========="+good[i]);

            j=cgcpservice.addcgcp(good[i]);
        }
        return AjaxResponse.success(j);
    }
    //全局变量
    Apprecords apprecords=new Apprecords();
    Parecord parecordd=new Parecord();
    //采购申请添加
    @PostMapping("/addcgsq")
    public AjaxResponse addcgsq(@RequestBody Caigousq addcg){
        System.out.println("====="+addcg);
        System.out.println("我是采购实体类里的付款计划:"+addcg.getParecord());
        int row=caigousqService.addcgsq(addcg);
        apprecords.setSqid(addcg.getSqid());
        apprecords.setApp_state("待审批");
        int ji=apprecordsService.addApprecords(apprecords);

        addcg.setStateId(apprecords.getApp_records_id());
        int cgsqrow=caigousqService.updatecgsq(addcg.getStateId(),addcg.getSqid());

        int[] userId=addcg.getUserId();
        System.out.println("============我是userid"+userId);
        for (int i=0;i<=userId.length-1;i++){
            System.out.println("==========="+userId[i]);
            int d=apprecordsSonService.addspzb(apprecords.getApp_records_id(),userId[i]);
            if (d==0){
                System.out.println("添加失败");
            }
        }

        int row2=parecordService.addfkjh(addcg.getParecord());
        System.out.println("我是controller层new的实体类："+addcg.getParecord().getPaId());
        apprecords.setSqid(addcg.getParecord().getPaId());
        apprecords.setApp_state("待审批");
        int ji2=apprecordsService.addApprecords(apprecords);
        int up=parecordService.upfk(addcg.getParecord(),addcg.getSqid());

        for (int i=0;i<=userId.length-1;i++){
            System.out.println("==========="+userId[i]);
            int d=apprecordsSonService.addspzb(apprecords.getApp_records_id(),userId[i]);
            if (d==0){
                System.out.println("添加失败");
            }
        }

        return AjaxResponse.success(row+ji+cgsqrow+row2+ji2+up);
    }

    @PostMapping("/addfkjhsp")
    public AjaxResponse addfkjhsp(@RequestBody Parecord parecord){
        System.out.println(parecord);
//        int row=parecordService.addfkjh(parecord);
//        apprecords.setSqid(parecord.getPaId());
//        apprecords.setApp_state("待审批");
//        int ji=apprecordsService.addApprecords(apprecords);
//        parecord.setStateId(apprecords.getApp_records_id());
//        int up=parecordService.upfk(parecord.getStateId(),parecord.getPaId(),apprecords.getSqid());
//
//        int[] userId=parecord.getUserId();
//        System.out.println("============我是userid"+userId);
//        for (int i=0;i<=userId.length-1;i++){
//            System.out.println("==========="+userId[i]);
//            int d=apprecordsSonService.addspzb(apprecords.getApp_records_id(),userId[i]);
//            if (d==0){
//                System.out.println("添加失败");
//            }
//        }
        return AjaxResponse.success();
    }

    //审批子表新增
    @PostMapping("/addspzb")
    public AjaxResponse addspzb(@RequestBody int[] userId){
        int j=0;
        for (int i=0;i<=userId.length-1;i++){
            System.out.println("==========="+userId[i]);
//            j=cgcpservice.addcgcp(userId[i]);

        }
        return AjaxResponse.success(j);
    }
}
