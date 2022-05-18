package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.ContactDao;
import com.trkj.crmproject.dao.CustomerDao;
import com.trkj.crmproject.entity.CusXq;
import com.trkj.crmproject.entity.contact;
import com.trkj.crmproject.entity.customer;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ContactDao contactDao;
    @Override
    public PageInfo<contactVo> findContacts(int pageNum, int pageSize, int salesperson_id) {
        Page<contact> page= PageHelper.startPage(pageNum,pageSize);
        List<contact> list=contactDao.findContacts(salesperson_id);
        Page<contactVo> contacts=new Page<>();
        BeanTools.copyList(list,contacts,contactVo.class);
        PageInfo<contactVo> pageInfo=new PageInfo<>(contacts);
        return pageInfo;
    }
    @Override
    public PageInfo<customerVo> findCustomer(int pageNum, int pageSize,String customer_name, String customer_stage,
                                             String create_time1,String create_time2,int salesperson_id) {
        Page<customer> page= PageHelper.startPage(pageNum,pageSize);
        List<customer> list = customerDao.findCustomer(customer_name,customer_stage,create_time1,create_time2,salesperson_id);
        Page<customerVo> customers=new Page<>();
        BeanTools.copyList(list,customers,customerVo.class);
        PageInfo<customerVo> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public PageInfo<customerVo> findCustomer2(int pageNum, int pageSize,String customer_name, String customer_stage,
                                             String create_time1,String create_time2,int salesperson_id) {
        Page<customer> page= PageHelper.startPage(pageNum,pageSize);
        List<customer> list = customerDao.findCustomer2(customer_name,customer_stage,create_time1,create_time2,salesperson_id);
        Page<customerVo> customers=new Page<>();
        BeanTools.copyList(list,customers,customerVo.class);
        PageInfo<customerVo> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public PageInfo<customerVo> findCustomers(int pageNum, int pageSize,int salesperson_id) {
        Page<customer> page= PageHelper.startPage(pageNum,pageSize);
        List<customer> list=customerDao.findCustomers(salesperson_id);
        Page<customerVo> customers=new Page<>();
        BeanTools.copyList(list,customers,customerVo.class);
        PageInfo<customerVo> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }
    @Override
    public CusXqVo findCusXq(int customer_id) {
        CusXqVo cusXqVo = customerDao.findCusXq(customer_id);
        return cusXqVo;
    }
    @Override
    public List<CusXq> findConXq(int customer_id) {
        List<CusXq> list = customerDao.findConXq(customer_id);
        return list;
    }

    @Override
//    @Transactional(transactionManager = "tm")
    public AddVo addCustomer(AddVo addVo) {
        int count=customerDao.addCustomer(addVo);
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return addVo;
    }
    @Override
//    @Transactional(transactionManager = "tm")
    public AddVo addContact(AddVo addVo) {
        int count=customerDao.addContact(addVo);

        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return addVo;
    }

    @Override
//    @Transactional(transactionManager = "tm")
    public AddVo addConCus(AddVo addVo) {
        int count=customerDao.addConCus(addVo);
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return addVo;
    }

    @Override
//    @Transactional(transactionManager = "tm")
    public customerVo updateCustomer(customerVo customerVo) {
        customer customer=new customer();
        BeanTools.copyProperties(customerVo,customer);
        int count=customerDao.updateCustomer(customer);
        // int i=9/0;
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return customerVo;
    }
    @Override
//    @Transactional(transactionManager = "tm")
    public int updataCustomerById(int customer_id) {
        return customerDao.updataCustomerById(customer_id);
    }

    @Override
    public int deleteCusCon(int customer_id) {
        return customerDao.deleteCusCon(customer_id);
    }

    @Override
    public int deleteCustomerById(int customer_id) {
        return customerDao.deleteCustomerById(customer_id);
    }
}
