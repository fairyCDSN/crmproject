package com.trkj.crmproject.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * parecord
 * @author 
 */
@Data
public class Parecord implements Serializable {
    /**
     * 付款计划id
     */
    @TableId(value = "pa_id",type = IdType.AUTO)
    private Integer paId;

    private Integer cgId;

    /**
     * 采购订单id
     */
    private Integer biId;

    /**
     * 总金额
     */
    private Integer paTotal;

    /**
     * 创建人
     */
    private String paPel;

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
     * 创建人
     */
    private String paJspopl;

    /**
     * 审批id
     */
    private Integer toexamine;

    /**
     * 审批记录id
     */
    private Integer stateId;

    private static final long serialVersionUID = 1L;
}