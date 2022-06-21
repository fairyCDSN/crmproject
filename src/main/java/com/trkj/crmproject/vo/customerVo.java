package com.trkj.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class customerVo {
    private int customer_id;
    private int salesperson_id;
    private int address_id;
    private String customer_name;
    private String customer_type;
    private String customer_source;
    private String customer_stage;
    private String remarks;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date create_time;
}
