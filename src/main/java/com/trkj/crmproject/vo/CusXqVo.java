package com.trkj.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CusXqVo {
    private int addressid;
    private int customerid;
    private int contactid;
    private int salespersonid;
    private String customername;
    private String contactname;
    private String workphone;
    private String myphone;
    private String founder;
    private String customerstage;
    private String customertype;
    private String customersource;
    private String country;
    private String province;
    private String city;
    private String email;
    private String phone;
    private String fax;
    private String remarks;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createtime;
}
