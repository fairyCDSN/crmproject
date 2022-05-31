package com.trkj.crmproject.controller;

import com.trkj.crmproject.entity.Approval;
import com.trkj.crmproject.entity.Staff;
import com.trkj.crmproject.service.ApprovalService;
import com.trkj.crmproject.service.RoleService;
import com.trkj.crmproject.service.StaffService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.RoleVo;
import com.trkj.crmproject.vo.staffnameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//这是采购审批查询
@RestController
public class CgspController {

    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private StaffService staffService;

    @GetMapping("/selectapptype")
    public AjaxResponse selectapptype(){
        Approval approval=approvalService.selectapptype();
        return AjaxResponse.success(approval);
    }

    @GetMapping("/selectrolename")
    public AjaxResponse selectrolename(){
        List<RoleVo> list=roleService.selectrolename();
        System.out.println("selectrolename========="+list);
        return AjaxResponse.success(list);
    }

    @GetMapping("/selectsfattname")
    public AjaxResponse selectsfattname(int[] roleId) {
        System.out.println("==============我刚进来" + roleId);
        List<staffnameVo> list = staffService.selectsfattname(roleId);
        System.out.println("========这是循环赋值后的list"+list);
        return AjaxResponse.success(list);
    }


}
