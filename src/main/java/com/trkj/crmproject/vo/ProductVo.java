package com.trkj.crmproject.vo;

import lombok.Data;

@Data
public class ProductVo {
    private int proId;
    private String proName;
    private String proType;
    private String proGuige;
    private String proXh;
    private String proDw;
    private Double proMoney;
    private Double proCbj;
    private int proKc;

    //仓库表 仓库名称（ckName)
    private String ckName;
}

