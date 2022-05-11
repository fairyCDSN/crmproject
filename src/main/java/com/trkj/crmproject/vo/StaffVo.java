package com.trkj.crmproject.vo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class StaffVo {
    //员工id
    private int staff_id;
    //用户id
    private int user_id;
    //部门id【外键】
    private int deptment_id;
    //职务id
    private int post_id;
    //入职时间
    private Date induction_time;

    //性别
    private String staff_sex;
    //QQ
    private String staff_qq;
    //微信
    private String staff_wx;
    //通信地址
    private String staff_txdz;
    //职务名称
    private String post_describe;
    //部门名称
    private String department_name;

    //用户名称[密码默认为123456]
    private String user_name;
    //组织id
    private int org_id;
    //默认有效
    //电话号码
    private String phone;
    //email
    private String email;

    public Date getInduction_time() {
        return induction_time;
    }

    public void setInduction_time(Date induction_time) {
        Timestamp createTime = new Timestamp(induction_time.getTime());
        this.induction_time = createTime;
    }
}
