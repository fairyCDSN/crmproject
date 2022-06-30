package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class product {
    @TableId(value = "proId",type = IdType.AUTO)
    private int proId;
    private String proName;
    private String proGuige;
    private String proXh;
    private String proDw;
    private Integer proMoney;
    private Integer proCbj;
//    private int proKc;
    private String proSay;
//    private int ckId;
}
