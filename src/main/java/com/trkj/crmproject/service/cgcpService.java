package com.trkj.crmproject.service;

import com.trkj.crmproject.entity.Cgcp;

import java.util.List;

public interface cgcpService {
    public int addcgcp(Cgcp cgcp);
    public List<Cgcp> findscgcp(int supplierId);
}
