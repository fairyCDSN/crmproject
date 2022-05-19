package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.CusXq;
import com.trkj.crmproject.entity.contact;
import com.trkj.crmproject.entity.customer;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.CusXqVo;
import com.trkj.crmproject.vo.contactVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContactDao {
    public List<contactVo> findContacts(int salesperson_id);
    public List<contact> findContacts2(@Param("contactName") String contactName,@Param("customerName") String customerName,
                                       @Param("customerType") String customerType,@Param("salesperson_id") int salesperson_id);
    public int findContactById(AddVo addVo);
    public List<CusXq> findConXq(int customer_id);
    public CusXqVo findConCusXq(@Param("customerId") int customerId,@Param("contactId") int contactId);
    public int findCustomerById(int contactId);
    public int countContact(int customer_id);
    public int updateContact(contactVo contactVo);
    public int addContact(AddVo addVo);
    public int deleteconCus(int contactId);
    public int deletecontact(int contactId);
}
