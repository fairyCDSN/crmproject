package com.trkj.crmproject.vo;

import lombok.Data;

import java.util.Date;

@Data

public class ApprovalRoleVo {
    //审批id
    private int app_id;
    //审批类型
    private String app_type;
    //角色id
    private int role_id;
    //权限标识
    private String role_name;
    //角色名称
    private String role_desc;
    //角色排序
    private int role_sort;
    //角色是否使用
    private int role_is_use;
    //角色创建时间
    private Date create_time;
    //用户id
    private int user_id;
    //用户名称
    private String user_name;
    //用户密码
    private String user_pass;
    //用户创建时间
    private Date user_create_time;
    //上级组织id
    private int org_id;
    //用户电话
    private String phone;
    //邮箱
    private String email;
    //用户是否可用
    private int user_is_use;
    //员工id
    private int staff_id;
    //员工名称
    private String staff_name;
    //职务id
    private int post_id ;
    //职务名称
    private String post_name;
    //部门id
    private int dept_id;
    //部门名称
    private String dept_name;
}
