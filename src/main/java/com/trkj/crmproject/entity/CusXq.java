package com.trkj.crmproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CusXq {
    private int address_id;
    private int customer_id;
    private int contactid;
    private int salesperson_id;
    private String customername;
    private String contactname;
    private String workphone;
    private String myphone;
    private String founder;
    private String customer_stage;
    private String customer_type;
    private String customer_source;
    private String country;
    private String province;
    private String city;
    private String email;
    private String phone;
    private String fax;
    private String remarks;
    private Date createtime;
}
