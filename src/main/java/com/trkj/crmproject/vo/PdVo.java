package com.trkj.crmproject.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PdVo {
    private int pdId;
    private Date pdTime;
    private String bz;
    private int ckId;
    private int staffId;

    //仓库表
    private String ckName;
    //员工表
    private String staffName;

    @TableField(exist = false)
    private List<ProductVo> product;
}
