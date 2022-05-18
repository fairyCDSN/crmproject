package com.trkj.crmproject.vo;

import lombok.Data;

@Data
public class contactVo {
    private int contactId;
    private int salespersonId;
    private String customerName;
    private String contactName;
    private String workPhone;
    private String myPhone;
    private String customerType;
    private String Founder;
}