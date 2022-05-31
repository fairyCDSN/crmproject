package com.trkj.crmproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * payment
 * @author 
 */
@Data
public class Payment implements Serializable {
    /**
     * 付款id
     */
    private Integer pyId;

    /**
     * 付款计划id
     */
    private Integer paId;

    /**
     * 付款方式
     */
    private String pyType;

    /**
     * 期次
     */
    private Integer pyQc;

    /**
     * 付款金额
     */
    private Integer pyMn;

    /**
     * 已开发票
     */
    private String isBi;

    /**
     * 分类
     */
    private String pyClass;

    /**
     * 实际付款日期
     */
    private Date pyMntime;

    private static final long serialVersionUID = 1L;
}