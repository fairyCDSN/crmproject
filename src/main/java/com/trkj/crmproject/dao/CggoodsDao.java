package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Cggoods;
import com.trkj.crmproject.vo.CggoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CggoodsDao extends BaseMapper<Cggoods> {
    int deleteByPrimaryKey(Integer gd_id);

    int insert(Cggoods record);

    int insertSelective(Cggoods record);

    Cggoods selectByPrimaryKey(Integer gd_id);

    int updateByPrimaryKeySelective(Cggoods record);

    int updateByPrimaryKey(Cggoods record);

    List<CggoodsVo> findgoods();

    List<CggoodsVo> selectgoods(@Param("gdName")String gdName,@Param("type")String type);

    String yzgoodname(@Param("supplierId")int supplierId, @Param("goodname")String goodname);

    List<String> findgoodstype();


}