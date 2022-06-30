package com.trkj.crmproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user_role
 * @author 
 */
@Data
public class UserRole implements Serializable {
    /**
     * 关系id
     */
    private Integer user_role_id;

    /**
     * 角色id
     */
    private Integer role_id;

    /**
     * 用户id
     */
    private Integer users_id;

    private static final long serialVersionUID = 1L;
}