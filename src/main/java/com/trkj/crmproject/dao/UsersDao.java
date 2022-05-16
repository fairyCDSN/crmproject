package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.mybatis.Users;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
@Component
public interface UsersDao extends BaseMapper<StaffMp> {
    int deleteByPrimaryKey(Integer user_id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer user_id);

    Users selectByUserName(String user_name);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    int selectMaxUserId();
}
