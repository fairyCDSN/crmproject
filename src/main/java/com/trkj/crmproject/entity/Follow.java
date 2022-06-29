package com.trkj.crmproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Follow {
    private int followId;
    private String followTitle;
    private int customerId;
    private String contact;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date followDate;
    private String founder;
    private String followManner;
    private String followContent;

    private String customerName;
}
