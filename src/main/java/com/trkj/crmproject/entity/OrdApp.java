package com.trkj.crmproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrdApp {
    private int apprecordsSonId;
    private String appState;
    private String appBz;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date appTime;
}
