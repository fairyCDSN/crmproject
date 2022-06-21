package com.trkj.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderTableVo {
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
}
