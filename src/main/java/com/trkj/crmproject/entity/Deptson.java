package com.trkj.crmproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * deptson
 * @author
 */
@Data
public class Deptson implements Serializable {
    /**
     * 子部门id
     */
    private Integer dept_son_id;

    private String dept_son_name;

    /**
     * 部门id
     */
    private Integer dept_id;

    /**
     * 子部门负责人id
     */
    private Integer user_id;

    /**
     * 子部门状态
     */
    private Integer state;

    private String bz;


    //额外添加的数据
    //员工名称
    private String staff_name;
    //职位
    private String post_name;
    //父部门名称
    private String dept_name;


    private static final long serialVersionUID = 1L;
}
