package com.trkj.crmproject.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * apprecords
 * @author 
 */
@Data
public class Apprecords implements Serializable {
    /**
     * 审批记录id
     */
    @TableId(value = "app_records_id",type = IdType.AUTO)
    private Integer app_records_id;

    /**
     * 申请标题
     */
    private Integer sqid;

    /**
     * 审批状态
     */
    private String app_state;

    /**
     * 审批时间
     */
    private Date app_time;

    /**
     * 备注
     */
    private String app_bz;

    private static final long serialVersionUID = 1L;
}