package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Supplier {
    @TableId
    private int supplierId;
    private String supplierName;
    private String sex;
    private String phone;
    private String job;
    private String email;
    private String qq;
    private String weixin;
    private int useStatus;
}
