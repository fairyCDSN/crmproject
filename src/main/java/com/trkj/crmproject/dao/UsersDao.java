package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Role;
import com.trkj.crmproject.entity.Users;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    Role selectRole(@Param("name") String name);

    int selectStaff_idByUserName(@Param("userName")String name);

    String selectStateByUserName(@Param("userName")String name,@Param("ggId")int id);

    //李玉春的代码
    public Users[] findUserName(String user_name);
    public int selectUserId(String user_name);
}
