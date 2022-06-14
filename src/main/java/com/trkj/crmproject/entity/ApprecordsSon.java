package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ApprecordsSon {
    @TableId
    private int apprecordsSonId;
    private int appRecordsId;
    private int userId;
    private String appState;
    private String appBz;
    private Date appTime;
    private Date createTime;
}
