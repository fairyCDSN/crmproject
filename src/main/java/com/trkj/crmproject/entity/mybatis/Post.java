package com.trkj.crmproject.entity.mybatis;

import java.io.Serializable;
import lombok.Data;

/**
 * post
 * @author
 */
@Data
public class Post implements Serializable {
    /**
     * 职务id
     */
    private Integer post_id;

    /**
     * 职务名称
     */
    private String post_name;

    /**
     * 职务描述
     */
    private String post_describe;

    private static final long serialVersionUID = 1L;
}
