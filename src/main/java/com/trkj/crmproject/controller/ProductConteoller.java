package com.trkj.crmproject.controller;

import com.trkj.crmproject.service.ProductService;
import com.trkj.crmproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductConteoller {

    @Autowired
    private ProductService productService;

    //商品清单  全部查询
    @RequestMapping("/selectProductAll")
    public AjaxResponse selectProductAll(){
        return AjaxResponse.success(productService.selectProductAll());
    }


}
