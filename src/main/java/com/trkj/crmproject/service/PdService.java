package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Pd;
import com.trkj.crmproject.vo.PdVo;

import java.util.List;

public interface PdService {

    //盘点单  全部查询
    public List<Pd> selectAllpd();
    public PageInfo<PdVo> findpd(int pageNum, int pageSize);

    //盘点单  查询全部（根据proId外键查询proName
    public List<PdVo> selectPdproName();


}
