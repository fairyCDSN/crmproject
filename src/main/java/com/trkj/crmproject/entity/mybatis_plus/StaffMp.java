package com.trkj.crmproject.entity.mybatis_plus;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * staff
 * @author
 */
@Data
@TableName(value = "staff")
public class StaffMp {
    /**
     * 员工id
     */
    private int staffId;

    /**
     * 用户id
     */
    private int userId;

    /**
     * 职务id
     */
    private int postId;

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

    private int deptmentId;

}
