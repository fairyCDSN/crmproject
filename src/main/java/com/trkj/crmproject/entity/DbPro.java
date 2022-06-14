package com.trkj.crmproject.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class DbPro {

    @TableId
    private int dbProId;
    private int dbId;
    private int ckId;
    private int proId;
    private int dbNumber;

}


