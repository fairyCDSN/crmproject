package com.trkj.crmproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * warn
 * @author
 */
@Data
public class Warn implements Serializable {
    private Integer warn_id;

    private String warn_type;

    private Integer sqid;

    /**
     * 待处理
     */
    private String state;

    private Integer user_id;

    private String warn_content;

    private String warningLv;

    private static final long serialVersionUID = 1L;
}
