package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.Gonggao;
import com.trkj.crmproject.service.GangGaoService;
import com.trkj.crmproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class GangGaoController {
    @Autowired
    private GangGaoService gangGaoService;

    @GetMapping("/selectRoleName")
    public AjaxResponse selectRoleName(String name){
        return AjaxResponse.success(gangGaoService.selectRoleName(name));
    }

    //查询所有广告
    @GetMapping("/selectAllGg")
    public AjaxResponse selectAllGg(){
        return AjaxResponse.success(gangGaoService.selectAllGg());
    }

    @GetMapping("/selectById")
    public AjaxResponse selectById(int id,String userName){
        return AjaxResponse.success(gangGaoService.selectById(id,userName));
    }

    @GetMapping("/selectGgPage")
    public AjaxResponse selectGgPage(int pageNum,int pageSize){
        return AjaxResponse.success(gangGaoService.selectGgPage(pageNum,pageSize));
    }

    @PostMapping("/addGg")
    public AjaxResponse addGg(@RequestBody Gonggao gonggao){
        log.debug("前端传入的公告信息：{}",gonggao);
        return AjaxResponse.success(gangGaoService.addGg(gonggao));
    }

    @PostMapping("/readGg")
    public AjaxResponse readGg(@RequestBody Map<String,Object> map){
        //获取用户名
        String userName=String.valueOf(map.get("userName"));

        //id
        int id=Integer.parseInt(String.valueOf(map.get("id")));
        return AjaxResponse.success(gangGaoService.readGg(userName,id));
    }

    @GetMapping("/selectReadNames")
    public AjaxResponse selectReadNames(int id){
        return AjaxResponse.success(gangGaoService.selectReadNames(id));
    }

    @GetMapping("/selectGgRead")
    public AjaxResponse selectGgRead(int id){
        return AjaxResponse.success(gangGaoService.selectGgRead(id));
    }

    @GetMapping("/selectGgByTypeAndState")
    public AjaxResponse selectGgByTypeAndState(int pageNum,int pageSize,String type,String state,String username){
        return AjaxResponse.success(gangGaoService.selectGgByTypeAndState(pageNum, pageSize, type, state,username));
    }

}
