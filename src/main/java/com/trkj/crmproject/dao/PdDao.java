package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Pd;
import com.trkj.crmproject.vo.PdVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PdDao extends BaseMapper<Pd> {
    //盘点单  查询全部（根据ckId中间表外键查询ckName
    public List<PdVo> selectPdckNameAll();

    //盘点单  查询全部（根据仓库名称查询）
    public List<PdVo> selectPdckName(String ckName);
}
