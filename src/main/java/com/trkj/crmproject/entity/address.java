package com.trkj.crmproject.entity;

import lombok.Data;

@Data
public class address {
        private int address_id;
        private String country;
        private String province;
        private String city;
        private String email;
        private String phone;
        private String fax;
}
