package com.trkj.crmproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * role_per
 * @author 
 */
@Data
public class RolePer implements Serializable {
    /**
     * 关系id
     */
    private Integer role_pre_id;

    /**
     * 角色id
     */
    private Integer role_id;

    /**
     * 权限id
     */
    private Integer son_id;

    private static final long serialVersionUID = 1L;
}