package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class reimbursement {
    @TableId
    private int reimbursementId;
    private int salespersonId;
    private int customerId;
    private int reimbursementMoney;
    private int finance;
    private String  reimbursementType;
    private Timestamp reimbursementDate;
    private String  remarks;
    private int toexamine;
    private int stateId;
    @TableField(exist = false)
    private long current;
    @TableField(exist = false)
    private long size=2;
    @TableField(exist = false)
    private int up;
}
