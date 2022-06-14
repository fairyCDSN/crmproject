package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class Approval {
    @TableId(value = "app_id",type = IdType.AUTO)
    private int appId;
    private String appType;
    private int appState;
    private int count;
}
