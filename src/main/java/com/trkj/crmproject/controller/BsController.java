package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.BsService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.BsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BsController {

    @Autowired
    private BsService bsService;

    //查询全部（仓库名称，商品名称）
    @RequestMapping("/selectbsAll")
    public AjaxResponse selectbsAll(){
        return AjaxResponse.success();
    }

    //分页
    @GetMapping("/findbs")
    public AjaxResponse findbs(int pageNum, int pageSize){
        PageInfo<BsVo> info=bsService.findbs(pageNum,pageSize);
        return AjaxResponse.success(info);
    }


    //报损列表  根据商品名称proName模糊查询
    @GetMapping("/selectBsproNamelike")
    public AjaxResponse selectBsproNamelike(String proName){
        return AjaxResponse.success(bsService.selectBsproNamelike(proName));
    }

    //报损列表  根据报溢编号查询
    @GetMapping("/selectBsbsId")
    public AjaxResponse selectBsbsId(int bsId){
        return AjaxResponse.success(bsService.selectBsbsId(bsId));
    }

    //报损列表 修改（修改备注）
    @PutMapping("/updateBs")
    public AjaxResponse updateBs(@RequestBody BsVo bsVo){
        System.out.println("byid:"+bsVo);
        return AjaxResponse.success(bsService.updateBs(bsVo));
    }

    //报损列表  根据ckName查询全部
    @GetMapping("/selectBsckName")
    public AjaxResponse selectBsckName(String ckName){
        return AjaxResponse.success(bsService.selectBsckName(ckName));
    }
}
