package com.trkj.crmproject.entity.mybatis_plus;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.crmproject.vo.ProductVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RkMp {
    @TableId(value = "rkId",type = IdType.AUTO)
    private int rkId;
    private int cgId;
    private int ckId;
    private Date rkTime;
    private int staffId;
    private String bz;
    private String state;
    private int appRecordsId;
    private int appId;

    @TableField(exist = false)
    private List<ProductVo> products;
    //private String[] proId;
}
