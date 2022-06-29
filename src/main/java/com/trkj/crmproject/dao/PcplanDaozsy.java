package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Pcplanzsy;
import com.trkj.crmproject.vo.CollectionVo;
import com.trkj.crmproject.vo.PcplanVozsy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PcplanDaozsy {
    int deleteByPrimaryKey(Integer pc_id);

    int insert(Pcplanzsy record);

    int insertSelective(Pcplanzsy record);

    Pcplanzsy selectByPrimaryKey(Integer pc_id);

    int updateByPrimaryKeySelective(Pcplanzsy record);

    int updateByPrimaryKey(Pcplanzsy record);

    List<CollectionVo> selectcollection();

    CollectionVo selectcollectiontj(@Param("orderid")int orderid ,@Param("type")String type,@Param("totalone")int totalone,@Param("totaltwo")int totaltwo);

    List<Pcplanzsy> selecthkmx(int orderId);

    PcplanVozsy selectminhk(int orderId);

    int[] findOID(String type);

    int updatehkjhzt(int pcId);

    int updatemn(@Param("pcId")int pcId,@Param("mn")int mn);

    int inserttj(Pcplanzsy record);

    int selectqc(int orderId);
}