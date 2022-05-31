package com.trkj.crmproject.vo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
@Mapper
public class DeptVo {
    /**
     * 部门id
     */
    private int department_id;

    /**
     * 部门名称
     */
    private String department_name;

    /**
     * 部门地址
     */
    private String department_address;

    //部门人数
    private int countNum;
}
