package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Ck;
import com.trkj.crmproject.vo.CkStaffVo;
import com.trkj.crmproject.vo.CkVo;

import java.util.List;

public interface CkService {
    //仓库管理  查询全部
    public List<Ck> selectCkall();

    //仓库管理  分页
    public PageInfo<CkVo> findck(int pageNum, int pageSize);

    //仓库管理  添加
    public Ck addCk(Ck ck);

    //仓库管理  根据id删除
    public int deleteCk(int ckId);

    //仓库管理  修改
    public int updateCk(Ck ck);

    //仓库管理 根据id查询
    public Ck setectCkid(int ckId);


    //仓库列表  查询全部（根据glyId,userId外键查询userName）
    public List<CkVo> selectCkuserName();

    //仓库列表  查询全部（根据CkName模糊查询）
    public List<CkVo> selectCkuserNamelike(String ckName);


    //查询管理员（users表）
//    public List<CkUserVo> selectUserName();

    //查询管理员ID（staff表）
    public List<CkStaffVo> selectGlyid();

    //仓库列表  删除（根据ckId把ckState改为1）
    public int updateCkState(int ckId);
}
