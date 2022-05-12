package com.trkj.crmproject.dao;

import com.trkj.crmproject.vo.AddVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface AddressDao {
    public int findAddById(AddVo addVo);
    public int findCustomerById(AddVo addVo);
    public int insertAddress(AddVo addVo);
}
