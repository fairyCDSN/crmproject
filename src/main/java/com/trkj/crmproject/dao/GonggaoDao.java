package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Gonggao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GonggaoDao {
    int deleteByPrimaryKey(Integer gg_id);

    int insert(Gonggao record);

    int insertSelective(Gonggao record);

    Gonggao selectByPrimaryKey(Integer gg_id);

    int updateByPrimaryKeySelective(Gonggao record);

    int updateByPrimaryKey(Gonggao record);

    List<Gonggao> selectAllGg();

    Gonggao selectById(@Param("id") int id);

    List<Gonggao> selectGgByTypeAndState(@Param("type")String type,@Param("user_id")int id);

    List<Gonggao> selectReadWd(@Param("ids")String ids,@Param("type")String type);
}
