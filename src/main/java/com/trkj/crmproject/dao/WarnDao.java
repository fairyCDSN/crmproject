package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Warn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WarnDao {
    int deleteByPrimaryKey(Integer warn_id);

    int insert(Warn record);

    int insertSelective(Warn record);

    Warn selectByPrimaryKey(Integer warn_id);

    int updateByPrimaryKeySelective(Warn record);

    int updateByPrimaryKey(Warn record);

    List<Warn> selectByState();
}
