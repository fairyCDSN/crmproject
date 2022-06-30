package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.*;
import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.service.PdService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.PdVo;
import com.trkj.crmproject.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PdServiceImpl implements PdService {

    @Autowired
    private PdDao pdDao;
    @Autowired
    private PdProDao pdProDao;
    @Autowired
    private ByiDao byiDao;
    @Autowired
    private BsDao bsDao;
    @Autowired
    private ProductDao productDao;

    //盘盘点单  查询全部（根据ckId中间表外键查询ckName
    public List<PdVo> selectPdckNameAll(){
        return pdDao.selectPdckNameAll();
    }
    //分页
    @Override
    public PageInfo<PdVo> findpd(int pageNum, int pageSize) {
        Page<PdVo> page= PageHelper.startPage(pageNum,pageSize);
        List<PdVo> list=pdDao.selectPdckNameAll();
        Page<PdVo> pds=new Page<>();
        BeanTools.copyList(list,pds, PdVo.class);
        PageInfo<PdVo> pageInfo=new PageInfo<>(pds);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //盘点单  查询全部（根据仓库名称查询）
    @Override
    public List<PdVo> selectPdckName(String ckName){
        return pdDao.selectPdckName(ckName);
    }




    //盘点单  查询userName当前登录的人的staffId
    @Override
    public int selectPdUserName(String userName){
        return pdDao.selectPdUserName(userName);
    }
    //盘点单  添加盘点表
    @Override
    @Transactional
    public int insertPd(Pd pd){
        int pdId=pdDao.selectPdIdmax()+1;

        pd.setPdId(pdId);
        pd.setPdTime(new Date());
        pdDao.insert(pd);
        int ckId=pd.getCkId();
        String createUser=pd.getCreateUser();
        System.out.println("仓库ID："+ckId+"管理员名称："+createUser);
        List<ProductVo> pdPros=pd.getProduct();
        System.out.println("pdId："+pdId);

        for (ProductVo o:pdPros){
            System.out.println("商品："+o.getXsl());
            System.out.println("商品ID："+o.getProId());

            PdPro pdPro=new PdPro();
            System.out.println("pd编号："+pdId);
            pdPro.setPdId(pdId);
            pdPro.setCkId(ckId);
            pdPro.setProId(o.getProId());
            pdPro.setCnumber(o.getXsl());
            pdProDao.insert(pdPro);

            if(o.getXsl()>0){

                Byi byi=new Byi();
                byi.setByiTime(new Date());
                byi.setCreateUser(createUser);
                byi.setProId(o.getProId());
                byi.setNumber(o.getXsl());
                byiDao.insert(byi);

                ProCk proCk=new ProCk();
                proCk.setProId(o.getProId());
                proCk.setCkId(ckId);
                proCk.setProCkNumber(o.getSl());
                productDao.updateProCkNumber(proCk);


            }else if(o.getXsl()<0){

                Bs bs=new Bs();
                bs.setBsTime(new Date());
                bs.setCreateUser(createUser);
                bs.setProId(o.getProId());
                int bsl=-o.getXsl();
                bs.setNumber(bsl);
                bsDao.insert(bs);

                ProCk proCk=new ProCk();
                proCk.setProId(o.getProId());
                proCk.setCkId(ckId);
                proCk.setProCkNumber(o.getSl());
                productDao.updateProCkNumber(proCk);

            }else if(o.getXsl()==0){
                System.out.println("库存数量无变化，库存量为："+o.getProCkNumber());
            }

        }

        return 1;
    }


    //盘点单 根据盘点ID查询盘点信息
    @Override
    public PdVo selectPdId(int pdId){
        return pdDao.selectPdId(pdId);
    }

    //盘点单 修改,四表改
    @Override
    @Transactional
    public int updatePd(Pd pd){

        return pdDao.updateById(pd);
    }


    //盘点单  通过按钮 根据时间，仓库查询
    @Override
    public List<PdVo> selectPdckNameandTime(String ckName,String kspdTime,String jspdTime){
        return pdDao.selectPdckNameandTime(ckName,kspdTime,jspdTime);
    }
}
