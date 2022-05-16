package com.trkj.crmproject.service;

import com.trkj.crmproject.vo.AddVo;

public interface AddressService {
    public int findAddById(AddVo addVo);
    public int findCustomerById(AddVo addVo);
    public int findContactById(AddVo addVo);
    public int findAddressById(int customer_id);
    public AddVo insertAddress(AddVo addVo);
}
