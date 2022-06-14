package com.trkj.crmproject.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "py_id",type = IdType.AUTO)
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
    //期次实付金额
    private Integer pySfmn;

    private static final long serialVersionUID = 1L;
}