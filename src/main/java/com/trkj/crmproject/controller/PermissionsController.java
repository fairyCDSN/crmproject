package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.Sonmenu;
import com.trkj.crmproject.service.PermissionService;
import com.trkj.crmproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class PermissionsController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/selectMenus")
    public AjaxResponse selectMenus(){
        return AjaxResponse.success(permissionService.selectAllMenus());
    }

    @PostMapping("/addMenus")
    public AjaxResponse addMenus(@RequestBody Map<String,Object> maps){
        //菜单名称
        Sonmenu sonmenu=new Sonmenu();
        sonmenu.setMenu_name(String.valueOf(maps.get("name")));
        sonmenu.setFather_id(Integer.parseInt(String.valueOf(maps.get("fa"))));
        sonmenu.setSort(Integer.parseInt(String.valueOf(maps.get("sort"))));
        sonmenu.setSub_url(String.valueOf(maps.get("subUrl")));
        sonmenu.setSub_name(String.valueOf(maps.get("subName")));
        sonmenu.setIs_qy(Integer.parseInt(String.valueOf(maps.get("state"))));
        sonmenu.setUrl(String.valueOf(maps.get("subUrl")));
        if(sonmenu.getFather_id()==0){
            sonmenu.setIs_leaf(0);
        }else{
            sonmenu.setIs_leaf(1);
        }
        sonmenu.setSubmit_method("GET");
        return AjaxResponse.success(permissionService.addMenus(sonmenu));
    }

}
