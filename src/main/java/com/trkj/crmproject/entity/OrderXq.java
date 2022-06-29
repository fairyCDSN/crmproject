package com.trkj.crmproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderXq {
    private int orderId;
    private String orderBh;
    private String fk;
    private String orderTitle;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date stateTime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date endTime;
    private String beizhu;

    private int contactId;
    private String contactName;
    private String workPhone;
    private String myPhone;

    private int customerId;
    private String customerName;
    private String customerType;
    private String customerSource;
    private String customerStage;
    private String remarks;

    private int pcqs;
    private String pcstate;
    private int sumMonery;
    private int jiaofuqs;
    private String jiaofustate;

    private PcPlan[] pcPlan;
    private jfjl[] jfjl;
}
