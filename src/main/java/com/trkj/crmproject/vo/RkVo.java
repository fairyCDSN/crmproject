package com.trkj.crmproject.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RkVo {
    private int rkId;
    private int cgId;
    private int ckId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rkTime;
    private int staffId;
    private String bz;
    private String state;
    private int appRecordsId;
    private int appId;


    //采购申请表（采购订单表链接的） 采购数量
    private int productNumber;

    //产品表（采购订单表链接的采购申请表链接的）
    private String proName;

    //仓库表
    private String ckName;
    //审批类别
    private String appType;
    //商品表（查询入库商品和数量（别名 dbNumber））
    @TableField(exist = false)
    private List<ProductVo> productVos;
    private String staffName;

}
