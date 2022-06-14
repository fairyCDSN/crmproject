package com.trkj.crmproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * goodsq
 * @author 
 */
@Data
public class Goodsq implements Serializable {
    private Integer gdsqId;

    private Integer gdId;

    private Integer sqid;

    private Integer number;

    private static final long serialVersionUID = 1L;
}