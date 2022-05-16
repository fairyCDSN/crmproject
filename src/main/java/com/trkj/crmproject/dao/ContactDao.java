package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.contact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactDao {
    public List<contact> findContacts(int salesperson_id);
}
