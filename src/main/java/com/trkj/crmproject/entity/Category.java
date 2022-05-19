package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Category {
    @TableId
    private int catId;
    private String catName;
}
