package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.CategoryDao;
import com.trkj.crmproject.dao.ProductDao;
import com.trkj.crmproject.dao.RkDao;
import com.trkj.crmproject.entity.Category;
import com.trkj.crmproject.entity.mybatis_plus.*;
import com.trkj.crmproject.service.RkService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.ProductVo;
import com.trkj.crmproject.vo.RkVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RkServiceImpl implements RkService {

    @Autowired
    private RkDao rkDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductDao productDao;

    //入库表 查询入库表全部（连仓库，审批类别查）
    @Override
    public List<RkVo> selectRkall() {
        return rkDao.selectRkall();
    }
    //分页
    @Override
    public PageInfo<RkVo> findRk(int pageNum, int pageSize) {
        Page<RkVo> page= PageHelper.startPage(pageNum,pageSize);
        List<RkVo> list=rkDao.selectRkall();
        Page<RkVo> depts=new Page<>();
        BeanTools.copyList(list,depts,RkVo.class);
        PageInfo<RkVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }


    //入库表 根据仓库名称查询全部
    @Override
    public List<RkVo> selectRkckName(String ckName) {
        return rkDao.selectRkckName(ckName);
    }

    //入库表 根据入库id查询入库信息
    @Override
    public RkVo selectRkxq(int rkId) {
        RkVo rkVo=new RkVo();
        rkVo=rkDao.selectRkxq(rkId);
        rkVo.setProductVos(rkDao.selectRkpro(rkId));
        log.debug("入库商品信息{}:",rkVo);
        return rkVo;
    }
    //入库表 根据入库id查询商品及入库数量
    @Override
    public List<ProductVo> selectRkpro(int rkId) {
        return rkDao.selectRkpro(rkId);
    }
    //分页
    @Override
    public PageInfo<ProductVo> findRkpro(int rkId,int pageNum, int pageSize) {
        Page<ProductVo> page= PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> list=rkDao.selectRkpro(rkId);
        Page<ProductVo> depts=new Page<>();
        BeanTools.copyList(list,depts,ProductVo.class);
        PageInfo<ProductVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //入库表 修改备注
    @Override
    public int updateRkbz(RkVo rkVo) {
        return rkDao.updateRkbz(rkVo);
    }


    //入库表 添加商品（查询商品的最大id）
    @Override
    public int selectPromax(){
        return rkDao.selectPromax();
    }

    //添加商品类别
    @Override
    public int insertRkcat(Category category) {
        return categoryDao.insert(category);
    }
    //添加商品
    @Override
    public int insertRkpro(Product product) {
        int proId=rkDao.selectRkpromax()+1;
        product.setProId(proId);
        log.debug("商品编号{}:",proId);
        productDao.insert(product);

        String[] categories=product.getCatId();
        for(String o:categories){
            ProCatMp proCat=new ProCatMp();
            String catName=o+"";
            log.debug("类别{}:",catName);
            int catId=rkDao.selectRkcatid(catName);
            proCat.setCatId(catId);
            log.debug("类别编号{}:",catId);
            proCat.setProId(proId);
            rkDao.insertproCat(proCat);
        }
        return 1;
    }

    //入库表，根据商品名称查商品
    @Override
    public ProductVo selectRkproname(String proName) {
        return rkDao.selectRkproname(proName);
    }

    // 添加入库表
    @Override
    public int insertRk(RkMp rkMp) {
        int rkId=rkDao.selectRkidmax()+1;
        log.debug("入库编号{}:",rkId);
        rkMp.setRkId(rkId);
        rkMp.setCkId(rkMp.getCkId());
        rkMp.setBz(rkMp.getBz());

        rkDao.insertRk(rkMp);

        List<ProductVo> products=rkMp.getProducts();
        for(ProductVo o:products){
            RkProMp rkProMp=new RkProMp();

            rkProMp.setRkId(rkId);
            rkProMp.setNumber(o.getSl());
            rkProMp.setProId(o.getProId());

            rkDao.insertRkPro(rkProMp);

        }
        return 1;
    }

}
