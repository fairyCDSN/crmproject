package com.trkj.crmproject.vo;

import lombok.Data;

@Data
public class ProductVo {
    private int proId;
    private String proName;
    private String proGuige;
    private String proXh;
    private String proDw;
    private Double proMoney;
    private Double proCbj;
    private String proSay;

    //仓库表 仓库名称（ckName)
    private String ckName;


    //商品与仓库的中间表  库存总和
    private int proCkNumbersum;
    //库存数量
    private int proCkNumber;
}

