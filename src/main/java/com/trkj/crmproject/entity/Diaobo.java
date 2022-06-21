package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.trkj.crmproject.vo.CkUserVo;
import com.trkj.crmproject.vo.ProductVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Diaobo {
    @TableId
    private int dbId;
    private int ckId;
    private int ckdrId;
    private Date dbTime;
    private String createUser;
    private String bz;
    private int toexamine;
    private int appRecordsId;

    @TableField(exist = false)
    private List<ProductVo> productss;

    @TableField(exist = false)
    private List<CkUserVo> usersId;
}
