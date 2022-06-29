package com.trkj.crmproject.entity.mybatis_plus;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ChukuMp {
    @TableId
    private int chukuId;
    private int orderId;
    private int ckId;
    private Date ckTime;
    private String bz;
    private String state;
    private int appRecordsId;
    private int appId;
    private int staffId;
}
