package com.trkj.crmproject.service;

import com.trkj.crmproject.dao.AddressDao;
import com.trkj.crmproject.dao.AddressDao;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.vo.AddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public int findAddById(AddVo addVo) {
        int address_id = addressDao.findAddById(addVo);
        return address_id;
    }
    @Override
    public int findCustomerById(AddVo addVo) {
        int customer_id = addressDao.findCustomerById(addVo);
        return customer_id;
    }
    @Override
    public int findContactById(AddVo addVo) {
        int contact_id = addressDao.findContactById(addVo);
        return contact_id;
    }

    @Override
    public int findAddressById(int customer_id) {
        int address_id = addressDao.findAddressById(customer_id);
        return address_id;
    }

    @Override
//    @Transactional(transactionManager = "tm")
    public AddVo insertAddress(AddVo addVo) {
        int count=addressDao.insertAddress(addVo);
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return addVo;
    }
}
