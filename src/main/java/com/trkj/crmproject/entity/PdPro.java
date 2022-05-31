package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class PdPro {
    @TableId
    private int pdProId;
    private int proId;
    private int ckId;
    private int cnumber;
    private int pdId;
}
