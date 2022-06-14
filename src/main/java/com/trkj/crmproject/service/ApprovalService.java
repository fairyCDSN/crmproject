package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Apprecords;
import com.trkj.crmproject.entity.Approval;
import com.trkj.crmproject.entity.Role;
import com.trkj.crmproject.vo.ApprecordsVo;

import java.util.List;

public interface ApprovalService {
    public Approval selectapptype();

    //wq
    //查询审批类别和权限
    public PageInfo<Approval> selectAllApp(int pageNum,int pageSize);

    //修改审批状态
    public int updateApprecords(int id, ApprecordsVo apprecordsVo);

    //按条件查询
    public PageInfo<Approval> selectByStateAndName(int state, String name,int pageNum,int pageSize);

    //添加审批类别表
    public int insertApproval(List<Integer> ids,Approval approval);

    public List<Role> selectUpdateText(int id);

    public List<Role> selectAppRole();

    public int delectAppRole(int id,int app_id);

    public int updateAppRole(int id,List<Integer> roleIds);

    public List<String> selectName();
}
