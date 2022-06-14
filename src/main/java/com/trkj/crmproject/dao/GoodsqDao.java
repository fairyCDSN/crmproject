package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Goodsq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsqDao {
    int deleteByPrimaryKey(Integer gdsq_id);

    int insert(Goodsq record);

    int insertSelective(Goodsq record);

    Goodsq selectByPrimaryKey(Integer gdsq_id);

    int updateByPrimaryKeySelective(Goodsq record);

    int updateByPrimaryKey(Goodsq record);
}