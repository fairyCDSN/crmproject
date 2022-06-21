package com.trkj.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class JiaoFuVo {
    private int jfId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date planJftime;
    private int trueTime;
    private int bjid;
    private int orderId;
    private double total;
    private String state;
    private String cjr;
    private int toexamine;
    private int stateId;

    private int orderId1;
    private int qs;
    private String time;
}
