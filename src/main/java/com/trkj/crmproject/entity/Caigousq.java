package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Caigousq {
    //采购申请表
    @TableId
    private int sqid;
    private int supplierId;
    private String cgTitle;
    private String cgDh;
    private BigDecimal total;
    private String type;
    private int product;
    private BigDecimal productNumber;
    private String salespersonId;
    private String fksm;
    private String jfsm;
    private int toexamine;
    private int stateId;
    private String usestate;
    //供应商表
    @TableField(exist = false)
    private String supplierName;
    //员工表
    @TableField(exist = false)
    private String staffId;
    //审批记录表
    @TableField(exist = false)
    private String appState;
    //产品表
    @TableField(exist = false)
    private int proId;
    @TableField(exist = false)
    private String proName;
}
