package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Apprecords;
import com.trkj.crmproject.vo.ApprecordsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApprecordsDao {
    int deleteByPrimaryKey(Integer app_records_id);

    int insert(Apprecords record);

    int insertSelective(Apprecords record);

    Apprecords selectByPrimaryKey(Integer app_records_id);

    int updateByPrimaryKeySelective(Apprecords record);

    int updateByPrimaryKey(Apprecords record);

    List<Apprecords> selectApprecordsByUserIdAndState(@Param("id") int id,@Param("state") String state);
    //修改审批记录表的状态
    int updateStateAndBzById(@Param("id") int id, @Param("state") String state,@Param("bz") String bz );


  }
