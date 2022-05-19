package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Byi;
import com.trkj.crmproject.vo.ByiVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ByiDao extends BaseMapper<Byi> {
    //报溢列表 查询全部（仓库名称，商品名称）
    List<ByiVo> selectbyiAll();

    //报溢列表  根据商品名称proName模糊查询
    List<ByiVo> selectByiproNamelike(String proName);

    //报溢列表  根据报溢编号查询
    ByiVo selectByibyiId(int byiId);

    //报溢列表 修改（修改备注）
    int updateByi(ByiVo byiVo);

    //报溢列表  根据ckName查询全部
    List<ByiVo> selectByickName(String ckName);
}

