package com.trkj.crmproject.entity.mybatis_plus;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class RkProMp {
    @TableId
    private int rkProId;
    private int proId;
    private int rkId;
    private int number;
}
