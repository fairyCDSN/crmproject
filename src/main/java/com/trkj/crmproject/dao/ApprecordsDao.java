package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.mybatis_plus.ApprecordsMp;
import com.trkj.crmproject.entity.Apprecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApprecordsDao extends BaseMapper<ApprecordsMp> {
    int deleteByPrimaryKey(Integer app_records_id);

    int insert(ApprecordsMp record);

    int insertSelective(ApprecordsMp record);

    ApprecordsMp selectByPrimaryKey(Integer app_records_id);

    int updateByPrimaryKeySelective(ApprecordsMp record);

    int updateByPrimaryKey(ApprecordsMp record);

    List<ApprecordsMp> selectApprecordsByUserIdAndState(@Param("id") int id, @Param("state") String state);
    //修改审批记录表的状态
    int updateStateAndBzById(@Param("id") int id, @Param("state") String state,@Param("bz") String bz );


  }
