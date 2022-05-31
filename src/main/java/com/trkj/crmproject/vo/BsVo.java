package com.trkj.crmproject.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BsVo {
    private int bsId;
    private Date bsTime;
    private int proId;
    private int number;
    private String createUser;
    private String bz;

    //商品表pro
    private String proName;
    //仓库表
    private String ckName;
}
