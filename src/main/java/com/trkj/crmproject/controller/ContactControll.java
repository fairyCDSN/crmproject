package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.CustomerService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.contactVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
@Slf4j
public class ContactControll {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/findContacts")
    public AjaxResponse findContacts(int pageNum, int pageSize, int salesperson_id){
        PageInfo<contactVo> info=customerService.findContacts(pageNum,pageSize,salesperson_id);
        return AjaxResponse.success(info);
    }
}
