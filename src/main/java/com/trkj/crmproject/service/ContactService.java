package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.CusXq;
import com.trkj.crmproject.vo.AddVo;
import com.trkj.crmproject.vo.CusXqVo;
import com.trkj.crmproject.vo.contactVo;
import com.trkj.crmproject.vo.customerVo;

import java.util.List;


public interface ContactService {
    public PageInfo<contactVo> findContacts(int pageNum, int pageSize, int salesperson_id);
    public PageInfo<contactVo> findContacts2(int pageNum, int pageSize,String contactName, String customerName,String customerType, int salesperson_id);
    public int findContactById(AddVo addVo);
    public List<CusXq> findConXq(int customer_id);
    public CusXqVo findConCusXq2(int customerId);
    public contactVo updateContact(contactVo contactVo);
    public AddVo addContact(AddVo addVo);
    public int deletecontact(int contactId);
}
