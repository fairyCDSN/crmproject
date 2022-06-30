package com.trkj.crmproject.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * cggoods
 * @author
 */
@Data
public class CggoodsVo {
    /**
     * 采购商品id
     */

    private Integer gdId;

    private Integer supplierId;

    private String gdName;

    private Integer gdPrice;

    private Integer gdNumber;

    private Integer gdTotal;

    private String bz;

    private String supplierName;

    private String gdType;

    private String cgNumber;
}