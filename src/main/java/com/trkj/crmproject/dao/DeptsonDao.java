package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Deptson;
import com.trkj.crmproject.entity.Users;
import com.trkj.crmproject.vo.DeptUserVo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
@Repository
public interface DeptsonDao {
    int deleteByPrimaryKey(Integer dept_son_id);

    int insert(Deptson record);

    int insertSelective(Deptson record);

    Deptson selectByPrimaryKey(Integer dept_son_id);

    int updateByPrimaryKeySelective(Deptson record);

    int updateByPrimaryKey(Deptson record);

    List<Deptson> selectDeptSon(@Param("id")int id);

    DeptUserVo selectUser(@Param("id")int id);
    List<DeptUserVo> selectDeptSonDetails(@Param("id") int id);
    List<Users> selectDqLogin(@Param("name") String name);
    int selectDeptSonId(@Param("name") String name);
    List<Users> selectPeopleOther(@Param("id")int id);
    List<Users> selectPeopleBoss();
    List<Deptson> selectDeptSonName();
    DeptUserVo selectUserDept(@Param("name")String name);
//    int updateDeptSon(@Param("name")String name,@Param("id") int id);
}
