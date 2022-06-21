package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Gonggao;
import com.trkj.crmproject.entity.Role;
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

    public List<StaffVo> selectGgRead(int id);

    public PageInfo<Gonggao> selectGgByTypeAndState(int pageNum,int pageSize,String type,String state,String username);
}
