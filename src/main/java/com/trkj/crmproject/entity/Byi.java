package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Byi {
    @TableId
    private int byiId;
    private Date byiTime;
    private int proId;
    private int number;
    private String createUser;
    private String bz;
}
