package com.trkj.crmproject.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

/**
 * tz
 * @author
 */
@Data
public class Tz implements Serializable {
    /**
     * 通知id
     */
    private Integer tz_id;

    /**
     * 通知标题
     */
    private String tz_title;

    /**
     * 通知内容
     */
    private String tz_content;

    /**
     * 创建时间
     */
    private Timestamp create_time;

    private String tz_type;

    private Date end_time;

    private Integer user_id;
    private String state;
    private String staff_name;

    private static final long serialVersionUID = 1L;
}
