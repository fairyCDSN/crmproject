package com.trkj.crmproject.entity.mybatis;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * staff
 * @author
 */
@Data
public class Staff implements Serializable {
    /**
     * 员工id
     */
    private Integer staff_id;

    /**
     * 用户id
     */
    private Integer user_id;

    /**
     * 职务id
     */
    private Integer post_id;

    /**
     * 入职时间
     */
    private Date induction_time;

    /**
     * 性别
     */
    private String staff_sex;

    /**
     * QQ
     */
    private String staff_qq;

    /**
     * 微信
     */
    private String staff_wx;

    /**
     * 通信地址
     */
    private String staff_txdz;

    private Integer deptment_id;

    private String staff_name;

    private static final long serialVersionUID = 1L;
}
