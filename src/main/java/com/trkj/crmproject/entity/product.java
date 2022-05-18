package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class product {
    @TableId
    private int proId;
    private String proName;
    private String proType;
    private String proGuige;
    private String proXh;
    private String proDw;
    private Double proMoney;
    private Double proCbj;
    private int proKc;
    private String proSay;
    private int ckId;
}
