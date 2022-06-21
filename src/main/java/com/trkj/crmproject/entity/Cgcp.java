package com.trkj.crmproject.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * cgcp
 * @author 
 */
@Data
public class Cgcp implements Serializable {
    private Integer gdId;

    private String gdName;

    private Integer gdNumber;

    private Integer gdPrice;

    private String gdType;

    private Integer supplierId;

    @TableField(exist = false)
    private String supplierName;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Cgcp{" +
                "gdId=" + gdId +
                ", gdName='" + gdName + '\'' +
                ", gdNumber=" + gdNumber +
                ", gdPrice=" + gdPrice +
                ", gdType='" + gdType + '\'' +
                ", supplierId=" + supplierId +
                '}';
    }
}