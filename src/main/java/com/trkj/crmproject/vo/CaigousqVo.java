package com.trkj.crmproject.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class CaigousqVo {
    private int gdId;
    private String gdName;
    private int gdPrice;
    private int gdNumber;
    private String supplierName;
    //wq
    @TableField(exist = false)
    private String staffName;
}
