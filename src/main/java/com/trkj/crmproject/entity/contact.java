package com.trkj.crmproject.entity;

import lombok.Data;

@Data
public class contact {
    private int contactid;
    private int salespersonid;
    private String customername;
    private String contactname;
    private String workphone;
    private String myphone;
    private String customertype;
    private String founder;
}
