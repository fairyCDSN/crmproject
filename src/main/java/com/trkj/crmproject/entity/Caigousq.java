package com.trkj.crmproject.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * caigousq
 * @author
 */
@Data
public class Caigousq implements Serializable {
    /**
     * 申请ID
     */
    @TableId(value = "sqid",type = IdType.AUTO)
    private Integer sqid;

    /**
     * 供应商ID
     */
    private Integer supplierId;

    /**
     * 采购主题
     */
    private String cgTitle;

    /**
     * 采购单号
     */
    private String cgDh;

    /**
     * 总金额
     */
    private BigDecimal total;

    /**
     * 采购员ID
     */
    private Integer salespersonId;

    /**
     * 付款说明
     */
    private String fksm;

    /**
     * 交付说明
     */
    private String jfsm;

    /**
     * 审批id
     */
    private Integer toexamine;

    /**
     * 审批记录id
     */
    private Integer stateId;

    private String usestate;

    /**
     * 采购状态
     */
    private String type;

    /**
     * 采购时间
     */
    private Date cgTime;

    private String bz;

    private String cgGuige;
    @TableField(exist = false)
    private String staff_name;

    private String cgType;
    @TableField(exist = false)
    private String staffName;
    @TableField(exist = false)
    private int[] userId;
    @TableField(exist = false)
    private Parecord parecord;
    @TableField(exist = false)
    private List<Cgcp> cgcp;

    private static final long serialVersionUID = 1L;
}
