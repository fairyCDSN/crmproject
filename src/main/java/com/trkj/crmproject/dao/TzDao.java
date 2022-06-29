package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Tz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TzDao {
    int deleteByPrimaryKey(Integer tz_id);

    int insert(Tz record);

    int insertSelective(Tz record);

    Tz selectByPrimaryKey(Integer tz_id);

    int updateByPrimaryKeySelective(Tz record);

    int updateByPrimaryKey(Tz record);

    List<Tz> selectTz(@Param("name") String name);

    Tz selectTzById(@Param("name")String name,@Param("id") int id);
}
