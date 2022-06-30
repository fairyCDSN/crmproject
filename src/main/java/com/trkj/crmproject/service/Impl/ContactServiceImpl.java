package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.ContactDao;
import com.trkj.crmproject.entity.CusXq;
import com.trkj.crmproject.entity.contact;
import com.trkj.crmproject.entity.customer;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.ContactService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.CusXqVo;
import com.trkj.crmproject.vo.contactVo;
import com.trkj.crmproject.vo.customerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;
    @Override
    public PageInfo<contactVo> findContacts(int pageNum, int pageSize, int salesperson_id) {
        Page<contact> page= PageHelper.startPage(pageNum,pageSize);
        List<contactVo> list=contactDao.findContacts(salesperson_id);
        Page<contactVo> contacts=new Page<>();
        BeanTools.copyList(list,contacts,contactVo.class);
        PageInfo<contactVo> pageInfo=new PageInfo<>(contacts);
        return pageInfo;
    }

    @Override
    public PageInfo<contactVo> findContacts2(int pageNum, int pageSize,String contactName, String customerName,String customerType, int salesperson_id) {
        Page<contact> page= PageHelper.startPage(pageNum,pageSize);
        List<contact> list = contactDao.findContacts2(contactName,customerName, customerType,salesperson_id);
        Page<contactVo> contacts=new Page<>();
        BeanTools.copyList(list,contacts,contactVo.class);
        PageInfo<contactVo> pageInfo=new PageInfo<>(contacts);
        return pageInfo;
    }

    @Override
    public int findContactById(AddVo addVo) {
        int contact_id = contactDao.findContactById(addVo);
        return contact_id;
    }
    @Override
    public List<CusXq> findConXq(int customer_id) {
        List<CusXq> list = contactDao.findConXq(customer_id);
        return list;
    }

    @Override
    public CusXqVo findConCusXq2(int contactId) {
        int customerId = contactDao.findCustomerById(contactId);
        return  contactDao.findConCusXq(customerId,contactId);
    }

    @Override
    @Transactional
    public contactVo updateContact(contactVo contactVo) {
        int count=contactDao.updateContact(contactVo);
        // int i=9/0;
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return contactVo;
    }

    @Override
    @Transactional
//    @Transactional(transactionManager = "tm")
    public AddVo addContact(AddVo addVo) {
        int count=1;
        if(contactDao.countContact(addVo.getCustomer_id())<=4) {
            count = contactDao.addContact(addVo);
        }else if(contactDao.countContact(addVo.getCustomer_id())==5){
            return null;
        }
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return addVo;
    }

    @Override
    @Transactional
    public int deletecontact(int contactId){
        contactDao.deleteconCus(contactId);
        contactDao.deletecontact(contactId);
        return 1;
    }
}
