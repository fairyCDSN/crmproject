package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.mybatis_plus.Ck;
import com.trkj.crmproject.service.CkService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.CkVo;
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

    //根据id查询
    @GetMapping("/setectCkid")
    public AjaxResponse setectCkid(int ckId){
        return AjaxResponse.success(ckService.setectCkid(ckId));
    }


    //仓库管理  分页
    @GetMapping("/findck")
    public AjaxResponse findck(int pageNum, int pageSize){
        System.out.println("11111111");
        PageInfo<CkVo> info=ckService.findck(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    //仓库列表  查询全部（根据glyId,userId外键查询userName）
    @GetMapping("/selectCkuserName")
    public AjaxResponse selectCkuserName(){
        return AjaxResponse.success(ckService.selectCkuserName());
    }

    //仓库列表  查询全部（根据CkName模糊查询）
    @GetMapping("/selectCkuserNamelike")
    public AjaxResponse selectCkuserNamelike(String ckName){
        return AjaxResponse.success(ckService.selectCkuserNamelike(ckName));
    }

    //查询管理员（users表）
//    @GetMapping("/selectUserName")
//    public AjaxResponse selectUserName(){
//        return AjaxResponse.success(ckService.selectUserName());
//    }

    // //查询管理员username（glyId外键到staff表，userId到users表 ）
    @GetMapping("/selectGlyid")
    public AjaxResponse selectGlyid(){
        return AjaxResponse.success(ckService.selectGlyid());
    }


    //仓库列表  删除（根据ckId把ckState改为0）
    @GetMapping("/updateCkState")
    public AjaxResponse updateCkState(int ckId){
        return AjaxResponse.success(ckService.updateCkState(ckId));
    }
    //仓库列表  启用（根据ckId把ckState改为1）
    @GetMapping("/updateCkState1")
    public AjaxResponse updateCkState1(int ckId){
        return AjaxResponse.success(ckService.updateCkState1(ckId));
    }

    // 仓库列表 查询仓库的商品总数量为0的
    @GetMapping("/selectCknumber")
    public AjaxResponse selectCknumber(int ckId){
        return AjaxResponse.success(ckService.selectCknumber(ckId));
    }

    //仓库管理 查询当前登录人的职位（角色名）（判断是否能修改仓库信息）
    @GetMapping("/selectCkroleName")
    public AjaxResponse selectCkroleName(String userName){
        System.out.println("这是用户名："+userName);
        return AjaxResponse.success(ckService.selectCkroleName(userName));
    }

}
