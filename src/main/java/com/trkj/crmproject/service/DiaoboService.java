package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.mybatis_plus.ApprecordsMp;
import com.trkj.crmproject.entity.Diaobo;
import com.trkj.crmproject.vo.CkUserVo;
import com.trkj.crmproject.vo.CkVo;
import com.trkj.crmproject.vo.DiaoboVo;
import com.trkj.crmproject.vo.ProductVo;

import java.util.List;

public interface DiaoboService {

    //调拨列表 查询全部（ckName[dcName,drName]
    List<DiaoboVo> selectDbAll();
    //分页
    public PageInfo<DiaoboVo> finddb(int pageNum, int pageSize);

    //调拨详情  根据调拨id查询商品信息
    List<ProductVo> selectDbidproName(int dbId);
    PageInfo<ProductVo> finddbproName(int dbId,int pageNum, int pageSize);
    //调拨详情 根据调拨id查询调拨信息
    DiaoboVo selectDbidxq(int dbId);

    //调拨详情 根据id修改备注
    int updateDbidbz(DiaoboVo diaoboVo);

    //调拨列表 根据调出仓库查询全部
    List<DiaoboVo> selectDbdcName(String dcName);
    //调拨列表 根据调入仓库查询全部
    List<DiaoboVo> selectDbdrName(String drName);

    //调拨列表 根据时间，调出调入仓库查询
    List<DiaoboVo> selectDbTimeandckName(String dcName,String drName,String ksdbTime,String jsdbTime);

    //调拨表 根据仓库id，商品名称查询
    ProductVo selectPdckIdproName(int ckId,String proName);




    //调拨表 查询不等于出库id的入库id
    List<CkVo> selectdbckdrId(int ckId);

    //审批，查询最大编号
    int selectdbAppId();
    //查询调拨最大编号
    int selectdbId();

    //添加审批子表，查询有审批权限的用户id
    List<CkUserVo> selectdbusersId();

    //添加调拨单
    int insertDiaobo(Diaobo diaobo);


    //根据调拨id查询审批状态（通过）
    ApprecordsMp selectdbappState(int dbId);


}
