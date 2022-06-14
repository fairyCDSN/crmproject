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

    @GetMapping("findsupplier")
    public AjaxResponse findsupplier(int pageNum,int pageSize){
        return AjaxResponse.success(supplierService.findsupplier(pageNum,pageSize));
    }

    @GetMapping("findsuptype")
    public AjaxResponse findsuptype(){
        return AjaxResponse.success(supplierService.findsuptype());
    }

    @GetMapping("selectsupplier")
    public AjaxResponse selectsupplier(int pageNum,int pageSize,String suppliername,String suppliertype){
        System.out.println(suppliername+"========");
        System.out.println(suppliertype+"========");
        return AjaxResponse.success(supplierService.selectsupplier(pageNum,pageSize,suppliername,suppliertype));
    }

    @GetMapping("findsCggoods")
    public AjaxResponse findsCggoods(int supplierId){
        System.out.println(supplierId+"=========");
        return AjaxResponse.success(cggoodsService.findsCggoods(supplierId));
    }

    @GetMapping("findscgcp")
    public AjaxResponse findscgcp(int supplierId){
        System.out.println(supplierId+"=========");
        return AjaxResponse.success(cgcpservice.findscgcp(supplierId));
    }

    @PostMapping("addsupplier")
    public AjaxResponse addsupplier(@RequestBody Supplier addcgcp){
        System.out.println(addcgcp+"==========");
        return AjaxResponse.success(supplierService.addSupplier(addcgcp));
    }

    @PutMapping("delectsupplier")
    public AjaxResponse delectsupplier(@RequestBody int supplierId){
        System.out.println(supplierId+"===========");
        return AjaxResponse.success(supplierService.delectsupplier(supplierId));
    }

    @GetMapping("selectsuptype")
    public AjaxResponse selectsuptype(int supplierId){
        System.out.println("========="+supplierId);
        return AjaxResponse.success(supplierService.selectsuptype(supplierId));
    }

    @PostMapping("addgoods")
    public AjaxResponse addgoods(@RequestBody Cggoods addcggoods){
        System.out.println(addcggoods+"==========");
        return AjaxResponse.success(cggoodsService.addgoods(addcggoods));
    }
}
