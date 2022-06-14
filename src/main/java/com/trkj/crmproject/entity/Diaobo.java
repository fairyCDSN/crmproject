package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Diaobo {
    @TableId
    private int dbId;
    private int ckId;
    private int ckdrId;
    private Date dbTime;
    private String createUser;
    private String bz;
    private int toexamine;
    private int stateId;
}
