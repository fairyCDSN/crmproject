package com.trkj.crmproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * app_role
 * @author 
 */
@Data
public class AppRole implements Serializable {
    /**
     * 审批权限id
     */
    private Integer app_role_id;

    /**
     * 审批id
     */
    private Integer app_id;

    /**
     * 角色id
     */
    private Integer role_id;

    private static final long serialVersionUID = 1L;
}