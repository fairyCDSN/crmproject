package com.trkj.crmproject.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PdVo {
    private int pdId;
    private String pdTitle;
    private Date pdTime;
    private String state;
    private int proId;
    private String createUser;
    private String bz;

    //产品表
    private String proName;
}
