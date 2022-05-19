package com.trkj.crmproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * department
 * @author
 */
@Data
public class Department implements Serializable {
    /**
     * 部门id
     */
    private Integer department_id;

    /**
     * 部门名称
     */
    private String department_name;

    /**
     * 部门地址
     */
    private String department_address;

    private static final long serialVersionUID = 1L;
}
