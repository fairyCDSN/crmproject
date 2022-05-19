package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Bs;
import com.trkj.crmproject.vo.BsVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BsDao extends BaseMapper<Bs> {

    //报损列表 查询全部（仓库名称，商品名称）
    List<BsVo> selectbsAll();

    //报损列表  根据商品名称proName模糊查询
    List<BsVo> selectBsproNamelike(String proName,String ckName);

    //报损列表  根据报溢编号查询
    BsVo selectBsbsId(int bsId);

    //报损列表 修改（修改备注）
    int updateBs(BsVo bsVo);

    //报损列表  根据ckName查询全部
    List<BsVo> selectBsckName(String ckName);
}
