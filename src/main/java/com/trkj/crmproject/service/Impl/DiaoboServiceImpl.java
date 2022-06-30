package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.ApprecordsSonDao;
import com.trkj.crmproject.dao.DbProDao;
import com.trkj.crmproject.dao.DiaoboDao;
import com.trkj.crmproject.entity.mybatis_plus.ApprecordsSonMp;
import com.trkj.crmproject.entity.mybatis_plus.DbPro;
import com.trkj.crmproject.entity.Diaobo;
import com.trkj.crmproject.entity.mybatis_plus.ApprecordsMp;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.DiaoboService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.CkUserVo;
import com.trkj.crmproject.vo.CkVo;
import com.trkj.crmproject.vo.DiaoboVo;
import com.trkj.crmproject.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class DiaoboServiceImpl implements DiaoboService {

    @Autowired
    private DiaoboDao diaoboDao;
    @Autowired
    private DbProDao dbProDao;
    @Autowired
    private ApprecordsSonDao apprecordsSonDao;

    //调拨列表 查询全部（ckName[dcName,drName]
    @Override
    public List<DiaoboVo> selectDbAll(){
        return diaoboDao.selectDbAll();
    }
    //分页
    @Override
    public PageInfo<DiaoboVo> finddb(int pageNum, int pageSize) {
        Page<DiaoboVo> page= PageHelper.startPage(pageNum,pageSize);
        List<DiaoboVo> list=diaoboDao.selectDbAll();
        Page<DiaoboVo> depts=new Page<>();
        BeanTools.copyList(list,depts,DiaoboVo.class);
        PageInfo<DiaoboVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //调拨详情  根据调拨id查询商品信息
    @Override
    public List<ProductVo> selectDbidproName(int dbId) {
        return diaoboDao.selectDbidproName(dbId);
    }
    @Override
    public PageInfo<ProductVo> finddbproName(int dbId, int pageNum, int pageSize) {
        Page<ProductVo> page= PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> list=diaoboDao.selectDbidproName(dbId);
        Page<ProductVo> depts=new Page<>();
        BeanTools.copyList(list,depts,ProductVo.class);
        PageInfo<ProductVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //调拨详情 根据调拨id查询调拨信息
    @Override
    public DiaoboVo selectDbidxq(int dbId) {
        return diaoboDao.selectDbidxq(dbId);
    }

    //调拨管理  修改
    @Override
    @Transactional
    public int updateDbidbz(DiaoboVo diaoboVo) {
        return diaoboDao.updateDbidbz(diaoboVo);
    }


    //调拨列表 根据调出仓库查询全部
    @Override
    public List<DiaoboVo> selectDbdcName(String dcName){
        return diaoboDao.selectDbdcName(dcName);
    }
    //调拨列表 根据调入仓库查询全部
    @Override
    public List<DiaoboVo> selectDbdrName(String drName){
        return diaoboDao.selectDbdrName(drName);
    }

    //调拨列表 根据时间，调出调入仓库查询
    @Override
    public List<DiaoboVo> selectDbTimeandckName(String dcName,String drName,String ksdbTime,String jsdbTime){
        return diaoboDao.selectDbTimeandckName(dcName,drName,ksdbTime,jsdbTime);
    }

    //调拨表 根据仓库id，商品名称查询
    @Override
    public ProductVo selectPdckIdproName(int ckId, String proName) {
        return diaoboDao.selectPdckIdproName(ckId,proName);
    }


    //调拨表 查询不等于出库id的入库id
    @Override
    public List<CkVo> selectdbckdrId(int ckId) {
        return diaoboDao.selectdbckdrId(ckId);
    }


    //添加调拨单
    @Override
    @Transactional
    public int insertDiaobo(Diaobo diaobo){
        int row=0;
        int apprecordsid=diaoboDao.selectdbAppId()+1;
        int diaoboid=diaoboDao.selectdbId()+1;

        int ckid=diaobo.getCkId();
        int ckdrid=diaobo.getCkdrId();

        diaobo.setDbTime(new Date());
        //调出仓库id
        diaobo.setCkId(ckid);
        //调入仓库id
        diaobo.setCkdrId(ckdrid);
        //根据仓库id查询负责人
        diaobo.setToexamine(3);
        diaobo.setAppRecordsId(2);
        diaobo.setDbId(diaoboid);

        row=diaoboDao.insert(diaobo);
        if(row<=0){
            throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败");
        }

        List<ProductVo> products=diaobo.getProductss();
        for(ProductVo o:products){
            if(o.getSl()!=0) {
                DbPro dbPro = new DbPro();
                dbPro.setCkId(ckid);
                dbPro.setDbId(diaoboid);
                dbPro.setDbNumber(o.getSl());
                dbPro.setProId(o.getProId());
                row=dbProDao.insert(dbPro);
                if(row<=0){
                    throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败");
                }
            }

        }

        ApprecordsMp apprecords=new ApprecordsMp();

        apprecords.setAppRecordsId(apprecordsid);
        apprecords.setSqid(diaoboid);
        log.debug("这是审批:{}",apprecords);

        diaoboDao.insertdbapp(apprecords);
        //获取调入调出仓库管理员id【通过ckid查询】
        int userid=diaoboDao.selectdbusersId(ckid);
        int druserid=diaoboDao.selectdbusersId(ckdrid);

        //添加调出审批
        ApprecordsSonMp apprecordsSon=new ApprecordsSonMp();
        apprecordsSon.setAppRecordsId(apprecordsid);
        apprecordsSon.setUserId(userid);
        row=diaoboDao.insertdbappson(apprecordsSon);
        if(row<=0){
            throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败");
        }
        //调入审批
        ApprecordsSonMp apprecordsSon2=new ApprecordsSonMp();
        apprecordsSon2.setAppRecordsId(apprecordsid);
        apprecordsSon2.setUserId(druserid);
        row=diaoboDao.insertdbappson(apprecordsSon2);
        if(row<=0){
            throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败");
        }

        diaobo.setAppRecordsId(apprecordsid);
        row=diaoboDao.updateById(diaobo);
        if(row<=0){
            throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败");
        }
        return row;
    }


    //根据调拨id查询审批状态（通过）
    @Override
    public ApprecordsMp selectdbappState(int dbId) {
        return diaoboDao.selectdbappState(dbId);
    }


}
