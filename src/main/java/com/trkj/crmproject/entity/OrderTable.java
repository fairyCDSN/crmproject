package com.trkj.crmproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderTable {
    private int orderId;
    private int bjid;
    private String orderBh;
    private String fk;
    private String orderTitle;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date stateTime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date endTime;
    private String khqyr;
    private String state;
    private String beizhu;
    private String cjr;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date cjTime;

    private int countNumber;
    private String staff_name;

}
