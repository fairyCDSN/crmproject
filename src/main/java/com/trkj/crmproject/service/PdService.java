package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Pd;
import com.trkj.crmproject.vo.PdVo;

import java.util.List;

public interface PdService {

    //盘点单  查询全部（根据ckId中间表外键查询ckName
    public List<PdVo> selectPdckNameAll();
    public PageInfo<PdVo> findpd(int pageNum, int pageSize);

    //盘点单  查询全部（根据仓库名称查询）
    public List<PdVo> selectPdckName(String ckName);


    //盘点单  查询userName当前登录的人的staffId
    int selectPdUserName(String userName);
    //盘点单  添加盘点表//添加 三表加，一表改
    int insertPd(Pd pd);

    //盘点单 根据盘点ID查询盘点信息
    PdVo selectPdId(int pdId);


    //盘点单 修改,四表改
    int updatePd(Pd pd);

    //盘点单  通过按钮 根据时间，仓库查询
    List<PdVo> selectPdckNameandTime(String ckName,String kspdTime,String jspdTime);

}
