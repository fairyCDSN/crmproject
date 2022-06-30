package com.trkj.crmproject.vo;

import lombok.Data;

import java.util.Date;

@Data
public class DeptUserVo {
    private String staff_name;
    private String staff_sex;
    private String phone;
    private String post_name;
    private String staff_txdz;
    private Date induction_time;
    private int dept_son_id;
    private String dept_son_name;
}
