package com.trkj.crmproject.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CustomerDao;
import com.trkj.crmproject.entity.customer;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.CusXqVo;
import com.trkj.crmproject.vo.customerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<customer> findCustomer(String customer_name, String customer_stage,String create_time1,String create_time2,int salesperson_id) {
        List<customer> customer = customerDao.findCustomer(customer_name,customer_stage,create_time1,create_time2,salesperson_id);
        return customer;
    }
    @Override
    public PageInfo<customerVo> findCustomers(int pageNum, int pageSize, int salesperson_id) {
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
        System.out.println(cusXqVo+"====================");
        return cusXqVo;
    }

    @Override
    public AddVo addCustomer(AddVo addVo) {
        int count=customerDao.addCustomer(addVo);
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return addVo;
    }
    @Override
    public AddVo addContact(AddVo addVo) {
        int count=customerDao.addContact(addVo);
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return addVo;
    }
    @Override
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
    public int deleteCustomerById(int customer_id) {
        return customerDao.deleteCustomerById(customer_id);
    }
    @Override
    public int deleteContactById(int customer_id) {
        return customerDao.deleteContactById(customer_id);
    }
}
