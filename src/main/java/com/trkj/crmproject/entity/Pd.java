package com.trkj.crmproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Pd {
    private int pdId;
    private String pdTitle;
    private Date pdTime;
    private String state;
    private int proId;
    private String createUser;
    private String bz;


}
