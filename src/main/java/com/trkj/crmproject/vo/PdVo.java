package com.trkj.crmproject.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PdVo {
    private int pdId;
    private Date pdTime;
    private String bz;
    private int ckId;
    private int staffId;

    //仓库表
    private String ckName;
    //用户表
    private String userName;
}
