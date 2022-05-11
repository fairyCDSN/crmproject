package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.mybatis.Staff;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import com.trkj.crmproject.vo.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
@Mapper
public interface StaffDao extends BaseMapper<StaffMp> {
    int deleteByPrimaryKey(Integer staff_id);

    int insert(StaffVo record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staff_id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    public List<com.trkj.crmproject.entity.Staff> selectcgyid();
}
