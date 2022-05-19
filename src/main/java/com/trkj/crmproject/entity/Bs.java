package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Bs {
    @TableId
    private int bsId;
    private Date bsTime;
    private int proId;
    private int number;
    private String createUser;
    private String bz;
    private int pdId;
}
