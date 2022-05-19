package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Byi;
import com.trkj.crmproject.vo.ByiVo;

import java.util.List;

public interface ByiService {
    //报溢列表 查询全部（仓库名称，商品名称）
    List<ByiVo> selectbyiAll();
    //分页
    public PageInfo<ByiVo> findbyi(int pageNum, int pageSize);


    //报溢列表  根据商品名称proName模糊查询
    List<ByiVo> selectByiproNamelike(String proName,String ckName);

    //报溢列表  根据报溢编号查询
    ByiVo selectByibyiId(int byiId);

    //报溢列表  修改（修改备注）
    int updateByi(ByiVo byiVo);

    //报溢列表  根据ckName查询全部
    List<ByiVo> selectByickName(String ckName);
    
}
