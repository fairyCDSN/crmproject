package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Ck {
    @TableId
    private int ckId;
    private String ckName;
    private int glyId;
    private int ckState;
}
