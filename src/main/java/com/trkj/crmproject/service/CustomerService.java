package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.CusXq;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.CusXqVo;
import com.trkj.crmproject.vo.contactVo;
import com.trkj.crmproject.vo.customerVo;

import java.util.List;

public interface CustomerService {
    public PageInfo<customerVo> findCustomers(int pageNum, int pageSize,int salesperson_id);
    public PageInfo<contactVo> findContacts(int pageNum, int pageSize, int salesperson_id);
    public PageInfo<customerVo> findCustomer(int pageNum, int pageSize,String customer_name,
                                             String customer_stage,String create_time1,String create_time2,int salesperson_id);
    public PageInfo<customerVo> findCustomer2(int pageNum, int pageSize,String customer_name,
                                             String customer_stage,String create_time1,String create_time2,int salesperson_id);
    public CusXqVo findCusXq(int customer_id);
    public List<CusXq> findConXq(int customer_id);
    public AddVo addCustomer(AddVo addVo);
    public AddVo addContact(AddVo addVo);
    public AddVo addConCus(AddVo addVo);
    public customerVo updateCustomer(customerVo customerVo);
    public int updataCustomerById(int customer_id);
    public int deleteCusCon(int customer_id);
    public int deleteCustomerById(int customer_id);
}
