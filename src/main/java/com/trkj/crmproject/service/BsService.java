package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Bs;
import com.trkj.crmproject.vo.BsVo;

import java.util.List;

public interface BsService {

    //报损列表 查询全部（仓库名称，商品名称）
    List<BsVo> selectbsAll();
    //分页
    public PageInfo<BsVo> findbs(int pageNum, int pageSize);


    //报损列表  根据商品名称proName模糊查询
    List<BsVo> selectBsproNamelike(String proName,String ckName,String ksbsTime,String jsbsTime);

    //报损列表  根据报溢编号查询
    BsVo selectBsbsId(int bsId);

    //报损列表  修改（修改备注）
    int updateBs(BsVo bsVo);

    //报损列表  根据ckName查询全部
    List<BsVo> selectBsckName(String ckName);


    //    报损列表 添加报损列表
    int insertBs(Bs bs);
}
