package com.trkj.crmproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.crmproject.vo.jfjlVo;
import lombok.Data;

import java.util.Date;

@Data
public class jfjl {
    private int jfId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date trueTime;
    private String cjr;
    private int number;
    private int proId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date planJftime;
    private int bjid;
    private int orderId;
    private Double total;
    private String state;
    private int stateId;
    private int toexamine;
    private String qs;

    private double pc_mn;
    private jfjlVo[] jfjlvo;
}
