package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Apprecords {
    @TableId
    private int appRecordsId;
    private int sqid;
    private String appState;
    private Date createTime;
    private Date appTime;
    private String appBz;
    private int appId;

}
