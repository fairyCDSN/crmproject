package com.trkj.crmproject.controller;

import com.trkj.crmproject.service.PermissionService;
import com.trkj.crmproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PermissionsController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/selectMenus")
    public AjaxResponse selectMenus(){
        return AjaxResponse.success(permissionService.selectAllMenus());
    }

}
