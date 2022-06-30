package com.trkj.crmproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * tz_user
 * @author 
 */
@Data
public class TzUser implements Serializable {
    private Integer tz_user_id;

    private Integer tz_id;

    private Integer user_id;

    private String state;

    private static final long serialVersionUID = 1L;
}