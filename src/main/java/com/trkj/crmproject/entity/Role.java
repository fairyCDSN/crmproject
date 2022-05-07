package com.trkj.crmproject.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * role
 * @author
 */
@Data
public class Role implements Serializable {
    /**
     * 角色id
     */
    private Integer role_id;

    /**
     * 角色名称
     */
    private String role_name;

    /**
     * 角色描述
     */
    private String role_desc;

    /**
     * 角色顺序
     */
    private Integer role_sort;

    /**
     * 是否可用
     */
    private Integer is_use;

    /**
     * 创建时间
     */
    private Date create_time;

    private static final long serialVersionUID = 1L;
}
