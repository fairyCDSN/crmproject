package com.trkj.crmproject.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CkUserVo {
    private String user_name;

    //调拨添加审批子表
    private int usersId;

}
