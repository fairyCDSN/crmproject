package com.trkj.crmproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.crmproject.vo.JiaoFuVo;
import lombok.Data;

import java.util.Date;

@Data
public class BaoJia {
    private int salesperson_id;
    private int bjid;
    private int customerid;
    private String customername;
    private int contactid;
    private String contactname;
    private String username;
    private String apptype;
    private String state;
    private String appstate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date statetime;

    private BjPro[] bj;
    private double total;
}
