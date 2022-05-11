package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Caigou;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CaigouDao extends BaseMapper<Caigou> {
//    int deleteByPrimaryKey(Integer cg_id);
//
//    int insert(Caigou record);
//
//    int insertSelective(Caigou record);
//
//    Caigou selectByPrimaryKey(Integer cg_id);
//
//    int updateByPrimaryKeySelective(Caigou record);
//
//    int updateByPrimaryKey(Caigou record);

    public List<Caigou> findcaigou();
}