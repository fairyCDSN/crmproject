package com.trkj.crmproject.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * corecord
 * @author 
 */
@Data
public class Corecord implements Serializable {
    /**
     * 回款id
     */
    @TableId(value = "coId",type = IdType.AUTO)
    private Integer coId;

    /**
     * 回款计划id
     */
    private Integer pcId;

    /**
     * 实际回款时间
     */
    private Date coPcda;

    /**
     * 创建人
     */
    private String coPel;

    /**
     * 发票状态
     */
    private String fpstate;

    private Integer coSjmn;

    private Integer orderId;

    private static final long serialVersionUID = 1L;
}