package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Caigou;

public interface CaigouService {
    public PageInfo<Caigou> findcaigou(int pageNum, int pageSize);
    public PageInfo<Caigou> selectcaigou(int pageNum, int pageSize,String state);
    public int addsgdd(Caigou caigou);
}
