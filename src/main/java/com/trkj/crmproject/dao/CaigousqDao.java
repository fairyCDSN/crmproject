package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Caigousq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CaigousqDao extends BaseMapper<Caigousq> {
    public List<Caigousq> selectsupname();
    public int insert(Caigousq caigousq);
    public List<Caigousq> selectsqid();
}
