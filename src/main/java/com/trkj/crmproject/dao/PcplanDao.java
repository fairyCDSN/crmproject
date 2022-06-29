package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Pcplan;
import com.trkj.crmproject.vo.CollectionVo;
import com.trkj.crmproject.vo.PcplanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PcplanDao {
    int deleteByPrimaryKey(Integer pc_id);

    int insert(Pcplan record);

    int insertSelective(Pcplan record);

    Pcplan selectByPrimaryKey(Integer pc_id);

    int updateByPrimaryKeySelective(Pcplan record);

    int updateByPrimaryKey(Pcplan record);

    List<CollectionVo> selectcollection();

    CollectionVo selectcollectiontj(@Param("orderid")int orderid ,@Param("type")String type,@Param("totalone")int totalone,@Param("totaltwo")int totaltwo);

    List<Pcplan> selecthkmx(int orderId);

    PcplanVo selectminhk(int orderId);

    int[] findOID(String type);

    int updatehkjhzt(int pcId);

    int updatemn(@Param("pcId")int pcId,@Param("mn")int mn);

    int inserttj(Pcplan record);

    int selectqc(int orderId);
}