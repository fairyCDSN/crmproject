package com.trkj.crmproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * staff
 * @author 
 */
@Data
public class Staff implements Serializable {
    /**
     * 员工id
     */
    @TableId
    private Integer staffId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 职务id
     */
    private Integer postId;

    /**
     * 入职时间
     */
    private Date inductionTime;

    /**
     * 性别
     */
    private String staffSex;

    /**
     * QQ
     */
    private String staffQq;

    /**
     * 微信
     */
    private String staffWx;

    /**
     * 通信地址
     */
    private String staffTxdz;

    private Integer deptmentId;

    private static final long serialVersionUID = 1L;
}