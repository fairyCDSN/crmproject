package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SupplierDao extends BaseMapper<Supplier> {
    int deleteByPrimaryKey(Integer supplier_id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer supplier_id);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    List<Supplier> findsupplier();

    List<String> findsuptype();

    List<Supplier> selectsupplier(@Param("suppliername")String suppliername,@Param("suppliertype")String suppliertype);

    String selectsuptype(int supplierId);

    String yzsuppliername(String supplierName);

    String yzsupplierphone(String supplierphone);


}