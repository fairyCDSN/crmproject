package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.vo.StaffVo;

import javax.swing.plaf.PanelUI;
import java.util.List;

public interface GangGaoService {

    public Role selectRoleName(String name);

    public List<Gonggao> selectAllGg();

    public Gonggao selectById(int id,String name);

    public PageInfo<Gonggao> selectGgPage(int pageNum,int pageSize);

    public int addGg(Gonggao gonggao);

    public int readGg(String userName,int id);

    public String selectReadNames(int id);

    public PageInfo<StaffVo> selectGgRead(int pageNum,int pageSize,int id);

    public PageInfo<Gonggao> selectGgByTypeAndState(int pageNum,int pageSize,String type,String state,String username);

    //通知部分
    //查询是否是部门负责人
    public List<Users> selectDqLogin(String name);

    //查询该子部门中的所有人
    public List<Users> selectPeopleOther(String name);
    //Boss查询所有子部门负责人
    public List<Users> selectPeopleBoss();

    public int addTz(Tz tz,List<Integer> user_ids,String name);

    public List<Tz> selectTz(String user_name);

    public Tz selectTzById(String name,int id);

    public List<Deptson> selectDeptSonName();

    public PageInfo<StaffVo> selectReadByDeptAndName(int pageNum,int pageSize,int deptName,String userName,int id);

}
