package com.trkj.crmproject.controller;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.ProductService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductConteoller {

    @Autowired
    private ProductService productService;

    //商品清单  全部查询
//    @RequestMapping("/selectProductAll")
//    public AjaxResponse selectProductAll(){
//        return AjaxResponse.success(productService.selectProductAll());
//    }

    //商品清单  根据ID查询
//    @GetMapping("/selectProId")
//    public AjaxResponse selectProId(int proId){
//        return AjaxResponse.success(productService.selectProId(proId));
//    }

    //分页
    @GetMapping("/findpro")
    public AjaxResponse findpro(int pageNum, int pageSize){
        PageInfo<ProductVo> info=productService.findpro(pageNum,pageSize);
        return AjaxResponse.success(info);
    }


    //商品清单  查询全部（根据pro_id外键查询到pro_ck表的pro_ck_number的和）
    @GetMapping("/selectProckName")
    public AjaxResponse selectProckName(){
        return AjaxResponse.success(productService.selectProckName());
    }

    //商品清单  查询全部类别
    @GetMapping("/selectCatAll")
    public AjaxResponse selectCatAll(){
        return AjaxResponse.success(productService.selectCatAll());
    }

    //商品清单  查询全部（根据proName模糊查询）
    @GetMapping("/selectProNamelike")
    public AjaxResponse selectProNamelike(String proName){
        return AjaxResponse.success(productService.selectProNamelike(proName));
    }

    //商品清单  查询全部（选择下拉框，根据catName查询）
    @GetMapping("/selectProcatNnameAll")
    public AjaxResponse selectProcatNnameAll(String catName){
        return AjaxResponse.success(productService.selectProcatNnameAll(catName));
    }

    //商品清单  根据ckName查询全部（下拉框）
    @GetMapping("/selectProckNameAll")
    public AjaxResponse selectProckNameAll(String ckName){
        System.out.println("123456789"+ckName);
        return AjaxResponse.success(productService.selectProckNameAll(ckName));
    }

    // 商品清单  查询商品详情
    @GetMapping("/selectProIdxq")
    public AjaxResponse selectProIdxq(int proId){
        return AjaxResponse.success(productService.selectProIdxq(proId));
    }
}
