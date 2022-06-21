package com.trkj.crmproject.entity.mybatis_plus;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ApprecordsSonMp {
    @TableId
    private int apprecordsSonId;
    private int appRecordsId;
    private int userId;
    private String appState;
    private String appBz;
    private Date appTime;
    private Date createTime;
}

