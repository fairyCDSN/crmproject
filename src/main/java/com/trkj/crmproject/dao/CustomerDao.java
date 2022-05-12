package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.customer;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.CusXqVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper

public interface CustomerDao {
    public List<customer> findCustomers(int salesperson_id);
    public List<customer> findCustomer(@Param("customer_name")String customer_name, @Param("customer_stage") String customer_stage,
                                       @Param("create_time1") String create_time1, @Param("create_time2")String create_time2, @Param("salesperson_id")int salesperson_id);
    public CusXqVo findCusXq(int customer_id);
    public int addCustomer(AddVo addVo);
    public int addContact(AddVo addVo);
    public int updateCustomer(customer customer);
    public int deleteCustomerById(int customer_id);
    public int deleteContactById(int customer_id);
}
