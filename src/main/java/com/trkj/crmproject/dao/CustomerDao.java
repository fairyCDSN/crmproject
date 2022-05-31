package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.CusXq;
import com.trkj.crmproject.entity.contact;
import com.trkj.crmproject.entity.customer;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.CusXqVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper

public interface CustomerDao {
    public List<customer> findCustomers(int salesperson_id);
    public List<customer> findCustomers2();
    public List<customer> findCustomer(@Param("customer_name")String customer_name,@Param("customer_stage") String customer_stage,
                                       @Param("create_time1") String create_time1,@Param("create_time2")String create_time2,
                                       @Param("salesperson_id")int salesperson_id);
    public List<customer> findCustomer1(@Param("customer_name")String customer_name,@Param("customer_stage") String customer_stage,
                                        @Param("create_time1") String create_time1,@Param("create_time2")String create_time2);
    public List<customer> findCustomer2(@Param("customer_name")String customer_name,@Param("customer_stage") String customer_stage,
                                        @Param("create_time1") String create_time1,@Param("create_time2")String create_time2,
                                        @Param("salesperson_id")int salesperson_id);
    public CusXqVo findCusXq(int customer_id);
    public int findCustomerById(AddVo addVo);
    public int addCustomer(AddVo addVo);
    public int addConCus(AddVo addVo);
    public int updateCustomer(customer customer);
    public int updataCustomerType1(int customer_id);
    public int updataCustomerType2(int customer_id);
    public int updateSeId(@Param("customer_id") int customer_id,@Param("staff_id") int staff_id);
}
