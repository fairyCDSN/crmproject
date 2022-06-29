package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.TzUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface TzUserDao {
    int deleteByPrimaryKey(Integer tz_user_id);

    int insert(TzUser record);

    int insertSelective(TzUser record);

    TzUser selectByPrimaryKey(Integer tz_user_id);

    int updateByPrimaryKeySelective(TzUser record);

    int updateByPrimaryKey(TzUser record);
}
