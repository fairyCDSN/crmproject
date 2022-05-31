package com.trkj.crmproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaoJia {
    private int salesperson_id;
    private int bjid;
    private String customername;
    private String username;
    private String apptype;
    private String appstate;
    private Date statetime;
}
