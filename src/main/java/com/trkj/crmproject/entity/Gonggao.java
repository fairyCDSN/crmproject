package com.trkj.crmproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * gonggao
 * @author
 */
@Data
public class Gonggao implements Serializable {
    /**
     * 公告id
     */
    private Integer gg_id;

    /**
     * 公告类型
     */
    private String gg_type;

    /**
     * 公告内容
     */
    private String gg_title;

    /**
     * 结束时间
     */
    private Date end_time;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态
     */
    private String state;

    /**
     * 创建时间
     */
    private Date create_time;

    private Integer read_number;

    /**
     * 发布人
     */
    private Integer create_user;

    private String readState;

    private static final long serialVersionUID = 1L;
}
