package com.trkj.crmproject.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ParecordVo {
    @TableId(value = "paId",type = IdType.AUTO)
    private Integer paId;

    private Integer cgId;

    /**
     * 采购申请订单id
     */
    private Integer sqid;

    /**
     * 总金额
     */
    private Integer paTotal;

    /**
     * 采购员id
     */
    private Integer paPel;

    /**
     * 期次
     */
    private Integer paQc;

    /**
     * 计划付款时间
     */
    private Date paDate;

    /**
     * 期次金额
     */
    private Integer paMn;

    /**
     * 备注
     */
    private String paRemark;

    /**
     * 审批id
     */
    private Integer toexamine;

    /**
     * 审批记录id
     */
    private Integer stateId;
    @TableField(exist = false)
    private String staffName;
    @TableField(exist = false)
    private String cgDh;
}
