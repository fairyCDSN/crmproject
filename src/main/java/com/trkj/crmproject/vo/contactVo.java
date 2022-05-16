package com.trkj.crmproject.vo;

import lombok.Data;

@Data
public class contactVo {
    private int contact_id;
    private int salesperson_id;
    private String customer_name;
    private String contact_name;
    private String work_phone;
    private String my_phone;
    private String customer_type;
    private String Founder;
}