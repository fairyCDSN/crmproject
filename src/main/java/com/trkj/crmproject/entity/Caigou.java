package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * caigou
 * @author 
 */
@Data
public class Caigou implements Serializable {
    /**
     * 采购id
     */
    @TableId(value = "cg_id",type = IdType.AUTO)
    private Integer cgId;

    /**
     * 采购申请id
     */
    private Integer sqid;

    /**
     * 采购日期
     */
    @TableField(value = "cg_time")
    private Date cgTime;

    /**
     * 采购状态【执行中、结束、意外中止】
     */
    private String state;

    /**
     * 客户经手人
     */
    private String kejsr;

    /**
     * 经手人
     */
    private String jsr;

    /**
     * 创建人
     */
    private String cjr;

    /**
     * 创建时间
     */
    private Date stateTime;

    /**
     * 备注
     */
    private String bz;

    private static final long serialVersionUID = 1L;
}