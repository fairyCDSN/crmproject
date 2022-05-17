package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.mybatis_plus.Ck;
import com.trkj.crmproject.vo.CkStaffVo;
import com.trkj.crmproject.vo.CkVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CkDao extends BaseMapper<Ck> {
    //仓库列表  查询全部（根据glyId,userId外键查询userName）
    public List<CkVo> selectCkuserName();

    //仓库列表  查询全部（根据CkName模糊查询）
    public List<CkVo> selectCkuserNamelike(String ckName);

    //查询管理员（users表）
//    public List<CkUserVo> selectUserName();

    //查询管理员ID（staff表）
    public List<CkStaffVo> selectGlyid();

    //仓库列表  删除（根据ckId把ckState改为0）
    public int updateCkState(int ckId);
    //仓库列表  启用（根据ckId把ckState改为1）
    public int updateCkState1(int ckId);

    // 仓库列表 查询仓库的商品总数量为0的
    public int selectCknumber(int ckId);

    //仓库管理 查询当前登录人的职位（角色名）（判断是否能修改仓库信息）
    public String selectCkroleName(String userName);
}
