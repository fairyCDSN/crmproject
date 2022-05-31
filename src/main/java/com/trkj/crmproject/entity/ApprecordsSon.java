package com.trkj.crmproject.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * apprecords_son
 * @author 
 */
@Data
public class ApprecordsSon implements Serializable {
    /**
     * 审核记录子表id
     */
    @TableId(value = "apprecords_son_id",type = IdType.AUTO)
    private Integer apprecords_son_id;

    /**
     * 审核记录id
     */
    private Integer app_records_id;

    /**
     * 审批人姓名
     */
    private Integer user_id;

    /**
     * 审批状态
     */
    private String app_state;

    /**
     * 审核备注【失败原因】
     */
    private String app_bz;

    private static final long serialVersionUID = 1L;
}