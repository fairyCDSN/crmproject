package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.ContactDao;
import com.trkj.crmproject.entity.contact;
import com.trkj.crmproject.service.ContactService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.contactVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContactServiceImpl implements ContactService {
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
}
