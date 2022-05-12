package com.trkj.crmproject.service;

import com.trkj.crmproject.vo.AddVo;

public interface AddressService {
    public int findAddById(AddVo addVo);
    public int findCustomerById(AddVo addVo);
    public AddVo insertAddress(AddVo addVo);
}
