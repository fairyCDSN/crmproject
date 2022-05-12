package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.customer;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.CusXqVo;
import com.trkj.crmproject.vo.customerVo;

import java.util.List;

public interface CustomerService {
    public PageInfo<customerVo> findCustomers(int pageNum, int pageSize, int salesperson_id);
    public List<customer> findCustomer(String customer_name, String customer_stage,String create_time1,String create_time2,int salesperson_id);
    public CusXqVo findCusXq(int customer_id);
    public AddVo addCustomer(AddVo addVo);
    public AddVo addContact(AddVo addVo);
    public customerVo updateCustomer(customerVo customerVo);
    public int deleteCustomerById(int customer_id);
    public int deleteContactById(int customer_id);
}
