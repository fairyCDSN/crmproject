package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Product;
import com.trkj.crmproject.service.ProductService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.CkVo;
import com.trkj.crmproject.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductConteoller {

    @Autowired
    private ProductService productService;

    //商品清单  全部查询
    @RequestMapping("/selectProductAll")
    public AjaxResponse selectProductAll(){
        return AjaxResponse.success(productService.selectProductAll());
    }

    //商品清单  根据ID查询
    @GetMapping("/selectProId")
    public AjaxResponse selectProId(int proId){
        return AjaxResponse.success(productService.selectProId(proId));
    }

    //商品清单  修改
    @PutMapping("/updatePro")
    public AjaxResponse updatePro(@RequestBody Product product){
        return AjaxResponse.success(productService.updatePro(product));
    }

    //分页
    @GetMapping("/findpro")
    public AjaxResponse findpro(int pageNum, int pageSize){
        PageInfo<ProductVo> info=productService.findpro(pageNum,pageSize);
        return AjaxResponse.success(info);
    }


    //商品清单  查询全部（根据ckId外键查询到ckName）
    @GetMapping("/selectProckName")
    public AjaxResponse selectProckName(){
        return AjaxResponse.success(productService.selectProckName());
    }

    //商品清单  查询全部（根据proName模糊查询）
    @GetMapping("/selectProNamelike")
    public AjaxResponse selectProNamelike(String proName){
        return AjaxResponse.success(productService.selectProNamelike(proName));
    }

    //商品清单  查询全部（选择下拉框，根据ckName模糊查询）
    @GetMapping("/selectProckNamexz")
    public AjaxResponse selectProckNamexz(String ckName){
        return AjaxResponse.success(productService.selectProckNamexz(ckName));
    }
}
