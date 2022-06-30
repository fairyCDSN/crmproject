package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.ApprecordsSon;
import com.trkj.crmproject.entity.mybatis_plus.ApprecordsSonMp;
import com.trkj.crmproject.vo.ApprecordsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApprecordsSonDao extends BaseMapper<ApprecordsSonMp> {
    int deleteByPrimaryKey(Integer apprecords_son_id);

    int insert(ApprecordsSon record);

    int insertSelective(ApprecordsSon record);

    ApprecordsSon selectByPrimaryKey(Integer apprecords_son_id);

    int updateByPrimaryKeySelective(ApprecordsSon record);

    int updateByPrimaryKey(ApprecordsSon record);


    int updateApprecords(@Param("id") int id, @Param("state") String state, @Param("bz") String bz);

    List<ApprecordsSon> selectByAppId(@Param("id") int id);

//    wq
    List<ApprecordsSon> selectApprecordsByName(@Param("id")int id, @Param("state") String state);

    String selectType(@Param("id")int id);

    int selectSqid(@Param("id")int id);

}
