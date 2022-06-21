package com.trkj.crmproject.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * parecord
 * @author 
 */
@Data
public class Parecord implements Serializable {
    /**
     * 付款计划id
     */
    @TableId(value = "paId",type = IdType.AUTO)
    private Integer paId;

    private Integer cgId;

    /**
     * 采购申请订单id
     */
    private Integer sqid;

    /**
     * 总金额
     */
    private Integer paTotal;

    /**
     * 采购员id
     */
    private Integer paPel;

    /**
     * 期次
     */
    private Integer paQc;

    /**
     * 计划付款时间
     */
    private Date paDate;

    /**
     * 期次金额
     */
    private Integer paMn;

    /**
     * 备注
     */
    private String paRemark;

    /**
     * 审批id
     */
    private Integer toexamine;

    /**
     * 审批记录id
     */
    private Integer stateId;

    private Integer isfk;

    @TableField(exist = false)
    private Payment fkjh;
    @TableField(exist = false)
    private int[] userId;
    //这是选中的时间
    @TableField(exist = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date[] fruit;
    @TableField(exist = false)
    private int[] price;
    private static final long serialVersionUID = 1L;
}