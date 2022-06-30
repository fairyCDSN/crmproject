package com.trkj.crmproject.controller;

import com.trkj.crmproject.dao.CggoodsDao;
import com.trkj.crmproject.dao.ProductDao;
import com.trkj.crmproject.dao.RkDao;
import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.entity.mybatis_plus.RkMp;
import com.trkj.crmproject.entity.mybatis_plus.RkProMp;
import com.trkj.crmproject.service.*;
import com.trkj.crmproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
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

    @Autowired
    private GoodsqService goodsqService;

    @Autowired
    private CggoodsDao cggoodsDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private RkDao rkDao;

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
    int aid=0;
    int bid=0;
    //采购申请添加
    @PostMapping("/addcgsq")
    public AjaxResponse addcgsq(@RequestBody Caigousq addcg) throws ParseException {
        System.out.println("====="+addcg);
        System.out.println("我是采购实体类里的付款计划:"+addcg.getParecord());
        System.out.println("我是采购实体类里的采购商品"+addcg.getCgcp());
        List<Cgcp> cgcps=addcg.getCgcp();
        int row=caigousqService.addcgsq(addcg);

        RkMp rkMp=new RkMp();
        rkMp.setCgId(addcg.getSqid());
        rkMp.setCkId(1);
        rkMp.setState("未入库");



        apprecords.setSqid(addcg.getSqid());
        apprecords.setApp_state("待审批");
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(now);
        System.out.println(date+"当前时间====");
        apprecords.setCreate_time(date);
        apprecords.setApp_id(1);
        int ji=apprecordsService.addApprecords(apprecords);

        rkMp.setAppRecordsId(apprecords.getApp_records_id());
        rkMp.setAppId(1);

        int rkxz=rkDao.insertzsy(rkMp);
        aid=rkDao.selectmaxid();
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

          for (Cgcp c: cgcps){
              log.debug("这是采购商品：{}",c);

              int gdId=cggoodsDao.selectnumber(c.getGdId());
              System.out.println("输出gdId:"+gdId);
              int jsnumber=gdId-c.getGdNumber();
              int up=cggoodsDao.updatenumber(c.getGdId(),jsnumber);
              int row3=cgcpservice.addcgcp(c);
              product product=new product();
              product.setProName(c.getGdName());
              product.setProGuige("小型");
              product.setProXh(" ");
              product.setProDw("个");
              product.setProCbj(c.getGdPrice());
              product.setProMoney(c.getGdPrice()+5);
              int proxz=productDao.insert(product);
              bid=product.getProId();

              RkProMp rkProMp=new RkProMp();
              rkProMp.setRkId(aid);
              System.out.println("rkid:"+aid+bid);
              rkProMp.setProId(bid);
              rkProMp.setNumber(c.getGdNumber());

              int rkproxz=rkDao.insertRkPro(rkProMp);

              Cgcp cgcp=new Cgcp();
              System.out.println("采购产品id:"+c.getGdId());
              Goodsq goodsq=new Goodsq();
              goodsq.setGdId(c.getGdId());
              goodsq.setSqid(addcg.getSqid());
              int ji2=goodsqService.addgoodsq(goodsq);
          }




        for(int i=0;i<=addcg.getParecord().getPrice().length-1;i++) {
            Parecord parecord = new Parecord();
            parecord.setPaMn(addcg.getParecord().getPrice()[i]);
            parecord.setPaDate(addcg.getParecord().getFruit()[i]);
            parecord.setPaPel(addcg.getParecord().getPaPel());
            parecord.setPaQc(i+1);
            parecord.setIsfk(0);
            //类型转换，从bigdecimal转为str型，再从str转为integer型
            String total=addcg.getTotal().toString();
            Integer integer=Integer.parseInt(total);

            parecord.setPaTotal(integer);

            int row2 = parecordService.addfkjh(parecord);
            System.out.println("我是controller层new的实体类：" + parecord.getPaId());
            apprecords.setSqid(parecord.getPaId());
            apprecords.setApp_state("待审批");


            int up = parecordService.upfk(parecord, addcg.getSqid());
            //添加一条总记录
            if(i==addcg.getParecord().getPrice().length-1){

                parecord.setPaQc(addcg.getParecord().getPrice().length);
                parecord.setPaDate(addcg.getParecord().getFruit()[0]);
                parecord.setPaPel(addcg.getParecord().getPaPel());
                parecord.setIsfk(0);
                parecord.setPaMn(0);

                parecord.setSqid(addcg.getSqid());
                int i1=parecordService.addfkjh(parecord);
                apprecords.setSqid(parecord.getPaId());
                int ji2 = apprecordsService.addApprecords(apprecords);
                parecord.setStateId(apprecords.getApp_records_id());
                int up2 = parecordService.upfk(parecord, addcg.getSqid());
            }
        }


        for (int i=0;i<=userId.length-1;i++){
            System.out.println("==========="+userId[i]);
            int d=apprecordsSonService.addspzb(apprecords.getApp_records_id(),userId[i]);
            if (d==0){
                System.out.println("添加失败");
            }
        }

        return AjaxResponse.success(row+ji+cgsqrow);
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
