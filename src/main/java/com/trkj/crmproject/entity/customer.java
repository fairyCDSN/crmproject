package com.trkj.crmproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class customer {
    private int customer_id;
    private int salesperson_id;
    private int address_id;
    private String customer_name;
    private String customer_type;
    private String customer_source;
    private String customer_stage;
    private String remarks;
    private Date create_time;
}
