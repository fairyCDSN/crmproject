package com.trkj.crmproject.controller;

import com.trkj.crmproject.dao.CorecordDao;
import com.trkj.crmproject.dao.PcplanDaozsy;
import com.trkj.crmproject.entity.Corecord;
import com.trkj.crmproject.entity.Pcplanzsy;
import com.trkj.crmproject.service.CorecordService;
import com.trkj.crmproject.service.PcplanzsyService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.hkjhVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hkjhController {

    @Autowired
    private PcplanzsyService pcplanService;

    @Autowired
    private CorecordService corecordService;

    @Autowired
    private PcplanDaozsy pcplanDao;

    @Autowired
    private CorecordDao corecordDao;

    @GetMapping("/selectcollection")
    public AjaxResponse selectcollection(int pageNum,int pageSize){
        return AjaxResponse.success(pcplanService.selectcollection(pageNum,pageSize));
    }

    @GetMapping("/selectcollectiontj")
    public AjaxResponse selectcollectiontj(int pageNum,int pageSize,String type,int totalone,int totaltwo){
        if (type==""){
            type="审批通过";
        }
        System.out.println("输出type:"+pageNum+pageSize+type+totalone+totaltwo);

        return AjaxResponse.success(pcplanService.selectcollectiontj(pageNum,pageSize,type,totalone,totaltwo));
    }

    @GetMapping("/selecthkmx")
    public AjaxResponse selecthkmx(int orderId){
        System.out.println("输出:"+orderId);
        return AjaxResponse.success(pcplanService.selecthkmx(orderId));
    }

    @GetMapping("/selectminhk")
    public AjaxResponse selectminhk(int orderId){
        System.out.println("输出:"+orderId);
        return AjaxResponse.success(pcplanService.selectminhk(orderId));
    }

    @PutMapping("/updatehkjhstate")
    public AjaxResponse updatehkjhstate(@RequestBody hkjhVo addhkjh){
        System.out.println("输出addhkjh:"+addhkjh);
        Corecord corecord=new Corecord();
        corecord.setCoPcda(addhkjh.getCoPcda());
        corecord.setCoSjmn(addhkjh.getCoSjmn());
        corecord.setPcId(addhkjh.getHkjh().getPcId());
        corecord.setOrderId(addhkjh.getHkjh().getOrderId());
        return AjaxResponse.success(pcplanService.updatehkjhzt(addhkjh.getHkjh().getPcId())+corecordService.insert(corecord));
    }

    @PutMapping("/updateaddhkjhstate")
    public AjaxResponse updateaddhkjhstate(@RequestBody hkjhVo addhkjh){
        System.out.println("输出addhkjh:"+addhkjh);
        int i=pcplanDao.selectqc(addhkjh.getHkjh().getOrderId());
        System.out.println("输出i:"+i);
        Pcplanzsy pcplan=new Pcplanzsy();
        pcplan.setOrderBh(addhkjh.getHkjh().getBh());
        pcplan.setOrderId(addhkjh.getHkjh().getOrderId());
        pcplan.setPcMn(addhkjh.getHkjh().getPcMnnn());
        pcplan.setPcDa(i+1);
        pcplan.setPcPcstate(addhkjh.getHkjh().getPcPcstate());
        pcplan.setPcPcda(addhkjh.getHkjh().getPaMntime());
        System.out.println("输出pcplan:"+pcplan);
        Corecord corecord=new Corecord();
        corecord.setPcId(addhkjh.getHkjh().getPcIddd());
        corecord.setCoPcda(addhkjh.getCoPcda());
        corecord.setCoSjmn(addhkjh.getCoSjmn());
        corecord.setOrderId(addhkjh.getHkjh().getOrderId());
        System.out.println("输出addhkjh:"+addhkjh);
        return AjaxResponse.success(pcplanService.updatemn(addhkjh.getHkjh().getPcIddd(),addhkjh.getCoSjmn())+pcplanDao.inserttj(pcplan)+corecordDao.insert(corecord));
    }
}
