package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.crmproject.vo.ProductVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Pd {
    @TableId
    private int pdId;
    private Date pdTime;
    private String bz;
    private int ckId;
    private int staffId;

    @TableField(exist = false)
    private String createUser;

    @TableField(exist = false)
    private List<ProductVo> product;
}
