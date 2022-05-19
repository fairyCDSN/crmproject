package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.vo.PdVo;

import java.util.List;

public interface PdService {

    //盘点单  查询全部（根据ckId中间表外键查询ckName
    public List<PdVo> selectPdckNameAll();
    public PageInfo<PdVo> findpd(int pageNum, int pageSize);

    //盘点单  查询全部（根据仓库名称查询）
    public List<PdVo> selectPdckName(String ckName);
}
