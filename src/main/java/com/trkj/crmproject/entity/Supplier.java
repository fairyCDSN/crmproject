package com.trkj.crmproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * supplier
 * @author 
 */
@Data
public class Supplier implements Serializable {
    /**
     * 供应商Id
     */
    private Integer supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 移动电话
     */
    private String phone;

    /**
     * 职务
     */
    private String job;

    /**
     * 邮箱
     */
    private String email;

    /**
     * qq
     */
    private String qq;

    /**
     * 微信
     */
    private String weixin;

    /**
     * 使用状态（1、在使用 2、停用）
     */
    private Integer useStatus;

    /**
     * 供应商类型
     */
    private String supplierType;

    private static final long serialVersionUID = 1L;
}