package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Parecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ParecordDao {
    int deleteByPrimaryKey(Integer pa_id);

    int insert(Parecord record);

    int insertSelective(Parecord record);

    Parecord selectByPrimaryKey(Integer pa_id);

    int updateByPrimaryKeySelective(Parecord record);

    int updateByPrimaryKey(Parecord record);

    List<Parecord> selectfk();

    List<Parecord> pagefk(int paId);

}