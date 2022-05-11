package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    @TableId
    private int proId;
    private String proName;
    private String proGuige;
    private String proXh;
    private String proDw;
    private BigDecimal proMoney;
    private BigDecimal proCbj;
    private int proKc;
    private String  proSay;
}
