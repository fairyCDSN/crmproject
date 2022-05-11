package com.trkj.crmproject.entity.mybatis_plus;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * department
 * @author
 */
@Data
@TableName(value = "department")
public class DeptMp {
    /**
     * 部门id
     */
    private int departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 部门地址
     */
    private String departmentAddress;
}
