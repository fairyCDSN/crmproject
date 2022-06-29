package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.Gonggao;
import com.trkj.crmproject.entity.Tz;
import com.trkj.crmproject.service.GangGaoService;
import com.trkj.crmproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    public AjaxResponse selectGgRead(int pageNum,int pageSize,int id){
        return AjaxResponse.success(gangGaoService.selectGgRead(pageNum,pageSize,id));
    }

    @GetMapping("/selectGgByTypeAndState")
    public AjaxResponse selectGgByTypeAndState(int pageNum,int pageSize,String type,String state,String username){
        return AjaxResponse.success(gangGaoService.selectGgByTypeAndState(pageNum, pageSize, type, state,username));
    }

    //通知部分

    //查询是否是部门负责人
    @GetMapping("/selectDqLogin")
    public AjaxResponse selectDqLogin(String name){
        return AjaxResponse.success(gangGaoService.selectDqLogin(name));
    }
    //查询该部门的所有员工
    @GetMapping("selectPeopleOther")
    public AjaxResponse selectPeopleOther(String name){
        return AjaxResponse.success(gangGaoService.selectPeopleOther(name));
    }

    @GetMapping("/selectPeopleBoss")
    public AjaxResponse selectPeopleBoss(){
        return AjaxResponse.success(gangGaoService.selectPeopleBoss());
    }

    //添加通知
    @PostMapping("/addTz")
    public AjaxResponse addTz(@RequestBody Map<String,Object> maps){
        //获取通知信息
        Tz tz=new Tz();
        tz.setTz_title(String.valueOf(maps.get("title")));
        tz.setTz_content(String.valueOf(maps.get("content")));
        tz.setTz_type(String.valueOf(maps.get("type")));
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = ft.parse(String.valueOf(maps.get("end_time")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tz.setEnd_time(date);
        log.debug("前端传来的通知实体类：{}",tz);
        List<Integer> user_ids= (List<Integer>) maps.get("user");
        return AjaxResponse.success(gangGaoService.addTz(tz,user_ids,String.valueOf(maps.get("user_name"))));
    }

    @GetMapping("/selectTz")
    public AjaxResponse selectTz(String user_name){
        return AjaxResponse.success(gangGaoService.selectTz(user_name));
    }

    //根据通知id和用户查询通知信息【修改状态】
    @GetMapping("/selectTzById")
    public AjaxResponse selectTzById(String user_name,int tz_id){
        return AjaxResponse.success(gangGaoService.selectTzById(user_name,tz_id));
    }

    @GetMapping("/selectDeptSonName")
    public AjaxResponse selectDeptSonName(){
        return AjaxResponse.success(gangGaoService.selectDeptSonName());
    }
    @GetMapping("/selectReadByDeptAndName")
    public AjaxResponse selectReadByDeptAndName(int pageNum,int pageSize,int deptName,String userName,int id){
        log.debug(deptName+"部门名称");
        log.debug(userName+"用户名称");

        return AjaxResponse.success(gangGaoService.selectReadByDeptAndName(pageNum,pageSize,deptName,userName,id));
    }
}
