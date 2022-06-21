package com.trkj.crmproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Rk {
    private int rkId;
    private String rkTitle;
    private int cgId;
    private int ckId;
    private Date rkTime;
    private String State;
    private int staffId;
    private String bZ;
}
