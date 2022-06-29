package com.trkj.crmproject.entity.mybatis_plus;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ChukuProMp {
    @TableId
    private int chukuProId;
    private int proId;
    private int chukuId;
    private int number;
}
