package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.Cggoods;
import com.trkj.crmproject.entity.Supplier;
import com.trkj.crmproject.service.CggoodsService;
import com.trkj.crmproject.service.SupplierService;
import com.trkj.crmproject.service.cgcpService;
import com.trkj.crmproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CggoodsService cggoodsService;

    @Autowired
    private cgcpService cgcpservice;

    @GetMapping("/findsupplier")
    public AjaxResponse findsupplier(int pageNum,int pageSize){
        return AjaxResponse.success(supplierService.findsupplier(pageNum,pageSize));
    }

    @GetMapping("/findsuptype")
    public AjaxResponse findsuptype(){
        return AjaxResponse.success(supplierService.findsuptype());
    }

    @GetMapping("/selectsupplier")
    public AjaxResponse selectsupplier(int pageNum,int pageSize,String suppliername,String suppliertype){
        System.out.println(suppliername+"========");
        System.out.println(suppliertype+"========");
        return AjaxResponse.success(supplierService.selectsupplier(pageNum,pageSize,suppliername,suppliertype));
    }

    @GetMapping("/findsCggoods")
    public AjaxResponse findsCggoods(int supplierId){
        System.out.println(supplierId+"=========");
        return AjaxResponse.success(cggoodsService.findsCggoods(supplierId));
    }

    @GetMapping("/findscgcp")
    public AjaxResponse findscgcp(int supplierId){
        System.out.println(supplierId+"=========");
        return AjaxResponse.success(cgcpservice.findscgcp(supplierId));
    }

    @PostMapping("/addsupplier")
    public AjaxResponse addsupplier(@RequestBody Supplier addcgcp){
        System.out.println(addcgcp+"==========");
        return AjaxResponse.success(supplierService.addSupplier(addcgcp));
    }

    @PutMapping("/delectsupplier")
    public AjaxResponse delectsupplier(@RequestBody int supplierId){
        System.out.println(supplierId+"===========");
        return AjaxResponse.success(supplierService.delectsupplier(supplierId));
    }

    @GetMapping("/selectsuptype")
    public AjaxResponse selectsuptype(int supplierId){
        System.out.println("========="+supplierId);
        return AjaxResponse.success(supplierService.selectsuptype(supplierId));
    }

    @PostMapping("/addgoods")
    public AjaxResponse addgoods(@RequestBody Cggoods addcggoods){
        System.out.println(addcggoods+"==========");
        return AjaxResponse.success(cggoodsService.addgoods(addcggoods));
    }
//查询供应商名称是否重复
    @GetMapping("/yzsuppliername")
    public AjaxResponse yzsuppliername(String supplierName){
        System.out.println(supplierName+"========");
        String a= supplierService.yzsuppliername(supplierName);
        System.out.println(a+"+++++++++");
        if (a!=null){
            a="1";
        }else if (a==null){
            a="0";
        }
        return AjaxResponse.success(a);
    }
//查询供应商联系电话是否重复
    @GetMapping("/yzsupplierphone")
    public AjaxResponse yzsupplierphone(String supplierphone){
        System.out.println(supplierphone+"========");
        String a= supplierService.yzsupplierphone(supplierphone);
        System.out.println(a+"+++++++++");
        if (a!=null){
            a="1";
        }else if (a==null){
            a="0";
        }
        return AjaxResponse.success(a);
    }
//查询商品名
    @GetMapping("/yzgoodname")
    public AjaxResponse yzgoodname(int supplierId,String goodname){
        System.out.println(supplierId+"="+goodname+"========");
        String a= cggoodsService.yzgoodname(supplierId,goodname);
        System.out.println(a+"+++++++++");
        if (a!=null){
            a="1";
        }else if (a==null){
            a="0";
        }
        return AjaxResponse.success(a);
        }
    }
