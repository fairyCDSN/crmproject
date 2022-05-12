package com.trkj.crmproject.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RkVo {
    private int rkId;
    private String rkTitle;
    private int cgId;
    private int ckId;
    private Date rkTime;
    private String State;
    private String createUser;
    private String bZ;

    //采购申请表（采购订单表链接的） 采购数量
    private int productNumber;

    //仓库表
    private String ckName;

    //产品表（采购订单表链接的采购申请表链接的）
    private String proName;
}
