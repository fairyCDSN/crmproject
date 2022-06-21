package com.trkj.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PcPlanVo {
    private int  pcId;
    private int  orderId;
    private int  pcDa;
    private double  pcMn;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date pcPcda;
    private int  toexamine;
    private int  stateId;
    private String  pcpel;
    private String  pcPcstate;

    private int orderId1;
    private int qs;
    private String  state;
    private double sumMonery;
    private String  time;
}
