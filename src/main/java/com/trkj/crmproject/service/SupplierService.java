package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> selectsupname();
    public PageInfo<Supplier> findsupplier(int pageNum,int pageSize);
    public List<String> findsuptype();
    public PageInfo<Supplier> selectsupplier(int pageNum,int pageSize,String suppliername,String suppliertype);
    public int addSupplier(Supplier supplier);
    public int delectsupplier(int supplierId);
    public String selectsuptype(int supplierId);
    public String yzsuppliername(String supplierName);
    public String yzsupplierphone(String supplierphone);
    public List<String> findstaffgys(String type);
}
