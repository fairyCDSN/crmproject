package com.trkj.crmproject.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ApprecordsVo {
    private int app_records_id;
    private int sqid;
    private String app_state;
    private Date app_time;
    private String app_bz;
    //子记录
    private int apprecords_son_id;
    private int app_son_user_id ;
    private String app_son_state;
    private String app_son_bz;

}
