package com.trkj.crmproject.entity.mybatis_plus;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ProCatMp {
    @TableId
    private int proCatId;
    private int proId;
    private int catId;
}
