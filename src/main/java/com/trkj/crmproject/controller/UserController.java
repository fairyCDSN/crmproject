package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.CustomerService;
import com.trkj.crmproject.service.UsersService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.customerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
@Slf4j
public class UserController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/findUserName")
    public AjaxResponse findUserName(String user_name){
        return AjaxResponse.success(usersService.findUserName(user_name));
    }

    @GetMapping("/selectUserId")
    public AjaxResponse selectUserId(String user_name){
        System.out.println("sadbfjasbdfjabsfdkjbasjdf"+user_name);
        return AjaxResponse.success(usersService.selectUserId(user_name));
    }
}
