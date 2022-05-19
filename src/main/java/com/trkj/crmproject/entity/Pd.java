package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Pd {
    @TableId
    private int pdId;
    private Date pdTime;
    private String bz;
    private int ckId;
    private int staffId;
}
