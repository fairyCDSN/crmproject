package com.trkj.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BsVo {
    private int bsId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bsTime;
    private int proId;
    private int number;
    private String createUser;
    private String bz;

    //商品表pro
    private String proName;
    //仓库表
    private String ckName;
    //商品表
    private int proCbj;
    private int proMoney;
}
