package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.vo.contactVo;

public interface ContactService {
    public PageInfo<contactVo> findContacts(int pageNum, int pageSize, int salesperson_id);
}
