package com.trkj.crmproject.vo;

import com.baomidou.mybatisplus.annotation.TableField;
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

    @TableField(exist = false)
    private int sl;

    @TableField(exist = false)
    private int xsl;



    //仓库表 仓库名称（ckName)
    private String ckName;


    //商品与仓库的中间表  库存总和
    private int proCkNumbersum;
    //库存数量
    private int proCkNumber;

    //调拨与商品中间表  调拨数量、
    private int dbNumber;


    //李玉春
    //产品状态
    private String proType;
    //报价
    private int mo;
    //期次
    private int qc;
    //期次金额
    private int qcje;
    //期次时间
    private int qctime;
}

