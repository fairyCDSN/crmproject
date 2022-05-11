package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Ck;
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

    //仓库列表  删除（根据ckId把ckState改为1）
    public int updateCkState(int ckId);
}
