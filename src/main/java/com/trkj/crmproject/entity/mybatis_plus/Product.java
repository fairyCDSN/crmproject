package com.trkj.crmproject.entity.mybatis_plus;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.crmproject.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class Product {
    @TableId
    private int proId;
    private String proName;
    private String proGuige;
    private String proXh;
    private String proDw;
    private Double proMoney;
    private Double proCbj;
    private String proSay;

    @TableField(exist = false)
    private String[] catId;
}
