package com.trkj.crmproject.service;

import com.trkj.crmproject.entity.Ck;

import java.util.List;

public interface CkService {
    //仓库管理  查询全部
    public List<Ck> selectCkall();

    //仓库管理  分页
//    public PageInfo<Ck> findck(int pageNum, int pageSize);

    //仓库管理  添加
    public Ck addCk(Ck ck);

    //仓库管理  根据id删除
    public int deleteCk(int ckId);

    //仓库管理  修改
    public Ck updateCk(Ck ck);

    //根据id查询
    public Ck setectCkid(int ckId);
}
