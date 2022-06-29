package com.trkj.crmproject.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * cggoods
 * @author 
 */
@Data
public class Cggoods implements Serializable {
    /**
     * 采购商品id
     */
    @TableId(value = "gd_id",type = IdType.AUTO)
    private Integer gdId;

    private Integer supplierId;

    private String gdName;

    private Integer gdPrice;

    private Integer gdNumber;

    @TableField(exist = false)
    private String gdGuige;

    private String gdType;

    private Integer gdTotal;

    private String bz;

    private Integer gdCbprice;

    private Integer gdCbtotal;

    private Integer cgNumber;

    private static final long serialVersionUID = 1L;
}