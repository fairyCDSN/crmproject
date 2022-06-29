package com.trkj.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class jfjlVo {
    private int jfjlId; 
    private int jfId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date true_time;
    private int number;
    private int proId;
    private String proName;
    private double goodMonery;
}
