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
 * pcplan
 * @author
 */
@Data
public class Pcplanzsy implements Serializable {
    /**
     * 回款计划id
     */
    @TableId(value = "pcId",type = IdType.AUTO)
    private Integer pcId;

    /**
     * 合同id
     */
    private Integer orderId;

    /**
     * 期次
     */
    private Integer pcDa;

    /**
     * 金额
     */
    private Integer pcMn;

    /**
     * 计划回款时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pcPcda;

    /**
     * 审批
     */
    private Integer toexamine;

    /**
     * 审批状态
     */
    private Integer stateId;

    /**
     * 创建人
     */
    private String pcPel;

    /**
     * 回款状态
     */
    private String pcPcstate;
    @TableField(exist = false)
    private String orderBh;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(exist = false)
    private Date coPcda;
    @TableField(exist = false)
    private int coSjmn;

    private static final long serialVersionUID = 1L;
}