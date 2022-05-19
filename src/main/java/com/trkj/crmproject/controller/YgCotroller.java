package com.trkj.crmproject.controller;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.service.*;
import com.trkj.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class YgCotroller {

//    @Autowired
//    private PurchaseplanService purchaseplanService;

    @Autowired
    private ParecordService parecordService;

    @Autowired
    private CaigousqService caigousqService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private CaigouService caigouService;

    //采购计划，根据传入的数据，进行分页查询
//    @RequestMapping("/selectpurchaseplan")
//    public AjaxResponse selectpurchaseplan(Caigousq caigousq,int pageNum,int pageSize){
//        System.out.println("=============="+caigousq);
//        PageInfo<Caigousq> info= caigousqService.selectPurchaseplan(pageNum,pageSize,caigousq.getSqid(),caigousq.getSupplierId(),caigousq.getType());
//        return AjaxResponse.success(info);
//    }

//    @RequestMapping("selectcgall")
//    public AjaxResponse selectcgall(){
//        return AjaxResponse.success(purchaseplanService.selectcgall());
//    }
    //采购查询、加载页面调用方法查询并分页
//    @GetMapping("/findpur")
//    public AjaxResponse findpur(int pageNum,int pageSize){
//        System.out.println("11111111");
//        PageInfo<Caigousq> info=caigousqService.findpur(pageNum,pageSize);
//        return AjaxResponse.success(info);
//    }
//    //采购查询、查询按钮，根据id查询
//    @RequestMapping("selectcg")
//    public AjaxResponse selectcg(int purId){
//        System.out.println(purId);
//        return AjaxResponse.success(purchaseplanService.selectcg(purId));
//    }
//    //采购查询、修改方法
//    @PutMapping("updatecg")
//    public AjaxResponse updatecg(@RequestBody PurchaseplanVo purchaseplanVo){
//        System.out.println(purchaseplanVo);
//        return AjaxResponse.success(purchaseplanService.updatecg(purchaseplanVo));
//    }
//    //采购查询、删除方法
//    @DeleteMapping("deletecg")
//    public AjaxResponse deletecg(int purId){
//        System.out.println(purId+"--------------");
//        return AjaxResponse.success(purchaseplanService.deletecg(purId));
//    }
    //采购查询、添加方法
    @PostMapping("addcgjh")
    public AjaxResponse addcgjh(@RequestBody Caigousq caigousq){
        System.out.println("===========添加:"+caigousq);
        return AjaxResponse.success(caigousqService.addcaigousq(caigousq));
    }

    @GetMapping("findfkpy")
    public AjaxResponse findfkpy(int pageNum,int pageSize){
        System.out.println("11111111");
        PageInfo<Parecord> info=parecordService.findrb(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    @RequestMapping("selectfk")
    public AjaxResponse selectfk(Parecord vo,int pageNum,int pageSize){
        System.out.println(vo);
        PageInfo<Parecord> info=parecordService.selectfk(vo.getPaId(),pageNum,pageSize);
        System.out.println(info+"==================================");
        return AjaxResponse.success(info);
    }

    @PostMapping("addfkjh")
    public AjaxResponse addfkjh(@RequestBody Parecord parecord){
        int row =parecordService.addfkjh(parecord);
        return AjaxResponse.success(row);
    }

    //采购订单、添加按钮，查询供应商名称
    @GetMapping("selectsupname")
    public AjaxResponse selectsupname(){
        List<Supplier> list=supplierService.selectsupname();
        System.out.println("===================="+list);
        return AjaxResponse.success(list);
    }
    @GetMapping("selectcpname")
    public AjaxResponse selectcpname(){
        List<Product> list=productService.selectcpname();
        System.out.println("===================="+list);
        return AjaxResponse.success(list);
    }

    @GetMapping("selectcgyid")
    public AjaxResponse selectcgyid(){
        List<Staff> list=staffService.selectcgyid();
        System.out.println("===================="+list);
        return AjaxResponse.success(list);
    }

    @RequestMapping("findcaigou")
    public AjaxResponse findcaigou(int pageNum, int pageSize){
        PageInfo<Caigou> pageInfo=caigouService.findcaigou(pageNum,pageSize);
        return AjaxResponse.success(pageInfo);
    }

    @RequestMapping("selectcaigou")
    public AjaxResponse selectcaigou(Caigou caigou,int pageNum, int pageSize){
        PageInfo<Caigou> pageInfo=caigouService.selectcaigou(pageNum,pageSize,caigou.getState());
        return AjaxResponse.success(pageInfo);
    }

    @GetMapping("selectsqid")
    public AjaxResponse selectsqid(){
        List<Caigousq> list=caigousqService.selectsqid();
        System.out.println("===================="+list);
        return AjaxResponse.success(list);
    }

    @PostMapping("addcgdd")
    public AjaxResponse addcgdd(@RequestBody Caigou caigou){
        int row=caigouService.addsgdd(caigou);
        return AjaxResponse.success(row);
    }

    @GetMapping("/selectfkcgid")
    public AjaxResponse selectfkcgid(){
        List<Caigou> caigous=caigouService.selectfkcgid();
        System.out.println("我在colll=============="+caigous);
        return AjaxResponse.success(caigous);
    }
}
