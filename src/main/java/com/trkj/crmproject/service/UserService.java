package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.OrderTable;
import com.trkj.crmproject.entity.Role;
import com.trkj.crmproject.entity.Sonmenu;
import com.trkj.crmproject.entity.Users;
import com.trkj.crmproject.entity.mybatis_plus.DeptMp;
import com.trkj.crmproject.entity.mybatis_plus.PostMp;
import com.trkj.crmproject.entity.mybatis_plus.RoleMp;
import com.trkj.crmproject.entity.mybatis_plus.StaffMp;
import com.trkj.crmproject.vo.DeptUserVo;
import com.trkj.crmproject.vo.DeptVo;
import com.trkj.crmproject.vo.StaffVo;

import java.util.List;

public interface UserService {
    public PageInfo<StaffVo> selectAllStaff(int pageNum, int pageSize);
    public PageInfo<PostMp> selectAllPost(int pageNum, int pageSize);
    public PageInfo<DeptVo> selectAllDept(int pageNum, int pageSize);
    public List<StaffMp> selectAllStaff();
    public List<DeptMp> selectAllDept();
    public List<PostMp> selectAllPost();

    public List<StaffVo> selectDept(int deptid);

    public int insertStaff(StaffVo staffVo);

    public List<Role> selectAllRole();
    //条件查询[员工]
    public PageInfo<StaffVo> selectStaffByNameOrNum(int pageNum, int pageSize,String name,int bianhao,int deptid);
    //条件查询【部门】
    public PageInfo<DeptVo> selectDeptByNumOrDeptName(int pageNum, int pageSize,int number,int deptId);

    //统计部门人数
    public List<StaffVo> selectCountStaff();
    //统计审批通过的订单数量
    public List<OrderTable> selectCountOrderAll();
    //获取部门名称【查询全部员工】
    public List<StaffVo> selectStaffDeptName();

    //验证密码
    public List<Users> checkPass(String oldPass,String userName);
    //修改密码
    public int updatePass(String userName,String pass);
    //查询角色id
    public Role selectRoleIdAndName(String username);
    //查询角色
    public PageInfo<RoleMp> selectRole(int pageNum, int pageSize);
    //查询当前登录的部门和职务信息
    public StaffVo selectDeptNameAndPostNameByRole(String name);


    //修改权限状态
    public int updateRole(RoleMp roleMp);
    //根据角色id查询所有用户
    public PageInfo<StaffVo> selectUserByRoleId(int pageNum,int pageSize,int id);
    //添加角色
    public int insertRole(Role role);

    public List<Integer> selectMenusByRole_name(int id);
    public int updateRoleMenus(List<Integer> ids,int roleId);

    //验证用户名是否重复
    public int validateUser(String name);

    public DeptUserVo selectUser(String name);
}
