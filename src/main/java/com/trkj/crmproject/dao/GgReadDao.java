package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.GgRead;
import com.trkj.crmproject.vo.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GgReadDao {
    int deleteByPrimaryKey(Integer read_id);

    int insert(GgRead record);

    List<String> selectReadNames(@Param("id")int id);

    List<StaffVo> selectGgRead(@Param("id") int id);

    List<Integer> selectGgIds(@Param("id")int user_id);
}
