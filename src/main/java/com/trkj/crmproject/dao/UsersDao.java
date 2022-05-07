package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UsersDao {
    int deleteByPrimaryKey(Integer user_id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer user_id);

    Users selectByUserName(String user_name);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}
