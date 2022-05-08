package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.Ck;
import com.trkj.crmproject.service.CkService;
import com.trkj.crmproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CkController {

    @Autowired
    private CkService ckService;

    //仓库管理  全部查询
    @RequestMapping("/selectCkall")
    public AjaxResponse selectCkall(){
        return AjaxResponse.success(ckService.selectCkall());
    }

    //仓库管理  添加
    @PostMapping("/addCk")
    public AjaxResponse addCk(@RequestBody Ck ck){
        System.out.println("===========添加:"+ck);
        return AjaxResponse.success(ckService.addCk(ck));
    }
    //仓库管理  根据id删除
    @DeleteMapping("/deleteCk")
    public AjaxResponse deleteCk(int ckId){
        System.out.println(ckId+"--------------");
        return AjaxResponse.success(ckService.deleteCk(ckId));
    }

    //仓库管理  修改方法
    @PutMapping("/updateCk")
    public AjaxResponse updateCk(@RequestBody Ck ck){
        System.out.println(ck);
        return AjaxResponse.success(ckService.updateCk(ck));
    }

//    //仓库管理  分页
//    @GetMapping("/findck")
//    public AjaxResponse findck(){
//        System.out.println("11111111");
//        PageInfo<Ck> info=ckService.findck(1,2);
//        return AjaxResponse.success(info);
//    }
}
