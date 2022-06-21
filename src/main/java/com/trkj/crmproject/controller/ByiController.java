package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Byi;
import com.trkj.crmproject.service.ByiService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.ByiVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
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
    public AjaxResponse selectByiproNamelike(String proName,String ckName,String ksbyiTime,String jsbyiTime){
        log.debug("开始时间"+ksbyiTime+"结束时间"+jsbyiTime);
        return AjaxResponse.success(byiService.selectByiproNamelike(proName,ckName,ksbyiTime,jsbyiTime));
    }

    //报溢列表  根据报溢编号查询
    @GetMapping("/selectByibyiId")
    public AjaxResponse selectByibyiId(int byiId){
        log.debug("报溢id：{}",byiId);
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




    //报溢列表  查询当前登录的人
    @GetMapping("/selectCreateUser")
    public AjaxResponse selectCreateUser(String userName){
        return AjaxResponse.success(byiService.selectCreateUser(userName));
    }

    // 报溢列表 添加报溢表
    @PostMapping("/insertByi")
    public AjaxResponse insertByi(@RequestBody Byi byi){
        log.debug("这是报溢获取的对象：{}",byi);
        return AjaxResponse.success(byiService.insertByi(byi));
    }
}
