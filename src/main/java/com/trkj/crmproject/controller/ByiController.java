package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.ByiService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.ByiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ByiController {

    @Autowired
    private ByiService byiService;

    //查询全部（仓库名称，商品名称）
    @RequestMapping("/selectbyiAll")
    public AjaxResponse selectbyiAll(){
        return AjaxResponse.success();
    }

    //分页
    @GetMapping("/findbyi")
    public AjaxResponse findbyi(int pageNum, int pageSize){
        PageInfo<ByiVo> info=byiService.findbyi(pageNum,pageSize);
        return AjaxResponse.success(info);
    }


    //报溢列表  根据商品名称proName模糊查询
    @GetMapping("/selectByiproNamelike")
    public AjaxResponse selectByiproNamelike(String proName,String ckName){
        return AjaxResponse.success(byiService.selectByiproNamelike(proName,ckName));
    }

    //报溢列表  根据报溢编号查询
    @GetMapping("/selectByibyiId")
    public AjaxResponse selectByibyiId(int byiId){
        return AjaxResponse.success(byiService.selectByibyiId(byiId));
    }

    //报溢列表 修改（修改备注）
    @PutMapping("/updateByi")
    public AjaxResponse updateByi(@RequestBody ByiVo byiVo){
        System.out.println("byid:"+byiVo);
        return AjaxResponse.success(byiService.updateByi(byiVo));
    }

    //报溢列表  根据ckName查询全部
    @GetMapping("/selectByickName")
    public AjaxResponse selectByickName(String ckName){
        return AjaxResponse.success(byiService.selectByickName(ckName));
    }
}