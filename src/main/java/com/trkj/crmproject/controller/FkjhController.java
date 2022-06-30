package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.Parecord;
import com.trkj.crmproject.service.ParecordService;
import com.trkj.crmproject.service.PaymentService;
import com.trkj.crmproject.service.StaffService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.ParecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class FkjhController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private ParecordService parecordService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/selectsgyname")
    public AjaxResponse selectsgyname(int staffId){
        return AjaxResponse.success(staffService.selectcgyname(staffId));
    }

    @GetMapping("/findfkjh")
    public AjaxResponse findfkjh(int pageNum,int pageSize){
        return AjaxResponse.success(parecordService.findfkjh(pageNum,pageSize));
    }

    @GetMapping("/selectfkjh")
    public AjaxResponse selectfkjh(int pageNum,int pageSize,String cgDh,Integer total,Integer type){
        System.out.println("我是total:"+total+"=="+type);
        if(total==null){
            System.out.println("我进来了=====");
            total=0;
        }
        if(type==null){
            System.out.println("我进来了=====");
            type=0;
        }
        return AjaxResponse.success(parecordService.selectfkjh(pageNum,pageSize,cgDh,total,type));
    }

    @GetMapping("/tjqc")
    public AjaxResponse tjqc(int paId){
        System.out.println("我是传进来的paid:"+paId);
        return AjaxResponse.success(paymentService.tjqc(paId));
    }

    @GetMapping("/selectpayment")
    public AjaxResponse selectpayment(int paId){
        return AjaxResponse.success(parecordService.selectpayment(paId));
    }

    @GetMapping("/selectfkjhmx")
    public AjaxResponse selectfkjhmx(int sqid){
        return AjaxResponse.success(parecordService.selectfkjhmx(sqid));
    }

    @GetMapping("/selectonefkjh")
    public AjaxResponse selectonefkjh(int sqid){
        ParecordVo parecordVo=parecordService.selectonefkjh(sqid);
        System.out.println("输出+++++:"+parecordVo);
        return AjaxResponse.success(parecordVo);
    }

    @PutMapping("/updatestate")
    public AjaxResponse updatestate(@RequestBody Parecord addfkjh){
        System.out.println("输出++++："+addfkjh);
        return AjaxResponse.success(parecordService.upstate(addfkjh.getPaId())+paymentService.addfkjh(addfkjh.getFkjh()));
    }

    @PutMapping("/updatepare")
    public AjaxResponse updatepare(@RequestBody Parecord addfkjh){
        System.out.println("输出++++："+addfkjh);
        return AjaxResponse.success(parecordService.uppare(addfkjh.getPaId(),addfkjh.getFkjh().getPySfmn())+paymentService.addfkjh(addfkjh.getFkjh())+parecordService.addpare(addfkjh)+parecordService.uppateqc(addfkjh));
    }

    @GetMapping("/yzPyMntime")
    public AjaxResponse yzPyMntime(int sqid,int paqc){
        System.out.println("sqid:"+sqid);
        System.out.println("paqc:"+paqc);
        Date a=paymentService.yzPyMntime(sqid,paqc);
        return AjaxResponse.success(a);
    }
}
