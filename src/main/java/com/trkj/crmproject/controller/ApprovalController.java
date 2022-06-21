package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.ApprecordsSon;
import com.trkj.crmproject.entity.Approval;
import com.trkj.crmproject.service.ApprecordsService;
import com.trkj.crmproject.service.ApprecordsSonService;
import com.trkj.crmproject.service.ApprovalService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.ApprecordsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ApprovalController {
    @Autowired
    private ApprovalService approvalService;
    @Autowired
    private ApprecordsService apprecordsService;
    @Autowired
    private ApprecordsSonService apprecordsSonService;

    //查询审批类别
    @GetMapping("/selectAppAll")
    public AjaxResponse selectAllApp(int pageNum,int pageSize){
        return AjaxResponse.success(approvalService.selectAllApp(pageNum,pageSize));
    }


    @GetMapping("/selectByStateAndName")
    public AjaxResponse selectByStateAndName(int state,String type,int pageNum,int pageSize){
        log.debug("按条件查询审核类别：{}",approvalService.selectByStateAndName(state, type,pageNum,pageSize));
        return AjaxResponse.success(approvalService.selectByStateAndName(state, type,pageNum,pageSize));
    }

    @PostMapping("/insertApproval")
    public AjaxResponse insertApproval(@RequestBody Map<String,Object> maps){
        log.debug("这是审核列表获取的maps：{}",maps);
        List<Integer> ids=(List<Integer>) maps.get("roleIds");
        Approval approval= new Approval();
        approval.setAppType((String) maps.get("appType"));
        int state= Integer.parseInt((String) maps.get("appState"));
        approval.setAppState(state);
        log.debug("这是审核列表获取的ids：{}",ids);
        log.debug("这是审核列表获取的approval：{}",approval);

        return AjaxResponse.success(approvalService.insertApproval(ids,approval));
    }

    @GetMapping("/selectUpdateText")
    public AjaxResponse selectUpdateText(int appId){
        return AjaxResponse.success(approvalService.selectUpdateText(appId));
    }

    @GetMapping("/selectAppRole")
    public AjaxResponse selectAppRole(){
        log.debug("角色列表：{}",approvalService.selectAppRole());
        return AjaxResponse.success(approvalService.selectAppRole());
    }

    @PostMapping("/delectAppRole")
    public AjaxResponse delectAppRole(@RequestBody Map<String,Object> maps){
        log.debug("这是role_id哈哈哈哈哈：{}",String.valueOf(maps.get("role_id")));
        int a=Integer.parseInt(String.valueOf(maps.get("role_id")));
        int b=Integer.parseInt(String.valueOf(maps.get("app_id")));
        return AjaxResponse.success(approvalService.delectAppRole(a,b));
    }

    //根据审核模板编号修改中间表
    @PostMapping("/updateAppRole")
    public AjaxResponse updateAppRole(@RequestBody Map<String,Object> map){
        int a=Integer.parseInt(String.valueOf(map.get("id")));
        List<Integer> b=(List<Integer>) map.get("roleIds");
        return AjaxResponse.success(approvalService.updateAppRole(a,b));
    }

    @GetMapping("/selectName")
    public AjaxResponse selectName(){
        return AjaxResponse.success(approvalService.selectName());
    }

    //根据用户名查询id
    @GetMapping("/selectApprecordsByName")
    public AjaxResponse selectApprecordsByName(String username,String state){
        return AjaxResponse.success(apprecordsSonService.selectApprecordsByName(username,state));
    }

    //修改审批记录状态
    @PutMapping("/updateApprecords")
    public AjaxResponse updateApprecords(@RequestBody ApprecordsVo apprecordsVo){
        //获取map集合中的用户id(app_son_user_id)和apprecords对象
        return AjaxResponse.success(approvalService.updateApprecords(apprecordsVo.getApp_son_user_id(),apprecordsVo));
    }

    @PostMapping("/updateAppSon")
    public AjaxResponse updateAppSon(@RequestBody Map<String,Object> maps){
        //获取maps中的数据
        int id=Integer.parseInt(String.valueOf(maps.get("id")));
        int son_id=Integer.parseInt(String.valueOf(maps.get("son_id")));
        String state=String.valueOf(maps.get("state"));
        String bz=String.valueOf(maps.get("bz"));
        log.debug("审核记录表："+id+";"+"审核子表id："+son_id+"；"+"状态："+state+"备注："+bz);
        return AjaxResponse.success(apprecordsSonService.updateAppSon(id,son_id,state,bz));
    }

}
