package com.trkj.crmproject.entity;

import lombok.Data;

@Data
public class contact {
    private int contactId;
    private int salesperson_id;
    private String customerName;
    private String contactName;
    private String workPhone;
    private String myPhone;
    private String customerType;
    private String Founder;
}
