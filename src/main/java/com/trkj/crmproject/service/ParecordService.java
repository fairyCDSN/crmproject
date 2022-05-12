package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Parecord;

import java.util.List;

public interface ParecordService {
    public PageInfo<Parecord> findrb(int pageNum, int pageSize);
    public PageInfo<Parecord> selectfk(int paId, int pageNum, int pageSize);
    public int addfkjh(Parecord parecord);
}
