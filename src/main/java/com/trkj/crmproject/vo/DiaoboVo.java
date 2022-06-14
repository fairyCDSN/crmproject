package com.trkj.crmproject.vo;

import lombok.Data;

import java.util.Date;

@Data
public class DiaoboVo {
    private int dbId;
    private int ckId;
    private int ckdrId;
    private Date dbTime;
    private String createUser;
    private String bz;
    private int toexamine;
    private int stateId;

    private String dcName;
    private String drName;

}
