package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Caigousq;
import com.trkj.crmproject.vo.CaigousqVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CaigousqDao extends BaseMapper<Caigousq> {
    int deleteByPrimaryKey(Integer sqid);

    int insert(Caigousq record);

    int insertSelective(Caigousq record);

    Caigousq selectByPrimaryKey(Integer sqid);

    int updateByPrimaryKeySelective(Caigousq record);

    int updateByPrimaryKey(Caigousq record);

    List<CaigousqVo> selectcgmx(int sqid);

    List<Caigousq> findcgsq();

    List<Caigousq> selectcgsqdd(@Param("cgDh") String cgDh,@Param("total") int total,@Param("type") String type);

    List<Caigousq> selectAppCaigousq(@Param("id") int id);

}
