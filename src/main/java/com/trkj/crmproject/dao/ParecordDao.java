package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Parecord;
import com.trkj.crmproject.vo.ParecordVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ParecordDao extends BaseMapper<Parecord> {
    int deleteByPrimaryKey(Integer pa_id);

    int insert(Parecord record);

    int insertSelective(Parecord record);

    Parecord selectByPrimaryKey(Integer pa_id);

    int updateByPrimaryKeySelective(Parecord record);

    int updateByPrimaryKey(Parecord record);

    List<ParecordVo> findfkjh();
    List<ParecordVo> selectfkjh(@Param("cgDh")String cgDh,@Param("total")Integer total,@Param("type")Integer type);
    ParecordVo selectpayment(int paId);

    List<ParecordVo> selectfkjhmx(int sqid);

    ParecordVo selectonefkjh(int sqid);

    int selectmaxqc(int sqid);

    int selectmaxqctwo(int sqid);
}