package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Approval;
import com.trkj.crmproject.entity.Role;
import com.trkj.crmproject.vo.ApprovalRoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApprovalDao extends BaseMapper<Approval> {

//    查询所有审批类型
    List<Approval> selectAllApp();

//    根据审批类型编号查询审批人
    List<ApprovalRoleVo> selectRoleByApp(@Param("id") int app_id);

    List<Approval> selectByStateAndName(int state,String name);

    int insertApproval(Approval approval);

    List<Role> selectRoleByAppId(@Param("id") int id);

    List<String> selectName();
}
