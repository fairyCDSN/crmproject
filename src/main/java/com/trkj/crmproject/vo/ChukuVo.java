package com.trkj.crmproject.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ChukuVo {
    @TableId
    private int chukuId;
    private int orderId;
    private int ckId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ckTime;
    private String bz;
    private String state;
    private int appRecordsId;
    private int appId;
    private int staffId;

    //仓库表
    private String ckName;
    //审批类别
    private String appType;
    //员工表员工名称
    private String staffName;
    //商品表（查询入库商品和数量（别名 dbNumber））
    @TableField(exist = false)
    private List<ProductVo> productVos;
}

