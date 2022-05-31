package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Diaobo;
import com.trkj.crmproject.vo.DiaoboVo;
import com.trkj.crmproject.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DiaoboDao extends BaseMapper<Diaobo>{

    //调拨列表 查询全部（ckName[dcName,drName]
    List<DiaoboVo> selectDbAll();

    //调拨详情  根据调拨id查询商品信息
    List<ProductVo> selectDbidproName(int dbId);
    //调拨详情 根据调拨id查询调拨信息
    DiaoboVo selectDbidxq(int dbId);

}
