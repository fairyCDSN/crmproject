package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao extends BaseMapper<Product> {
}
