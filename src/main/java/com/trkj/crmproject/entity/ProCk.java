package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ProCk {
    @TableId
    private int proCkId;
    private int proId;
    private int ckId;
    private int proCkNumber;
}
