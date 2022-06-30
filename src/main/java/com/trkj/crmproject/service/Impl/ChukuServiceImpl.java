package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.ChukuDao;
import com.trkj.crmproject.dao.OrdertableDao;
import com.trkj.crmproject.dao.ProductDao;
import com.trkj.crmproject.dao.RkDao;
import com.trkj.crmproject.entity.JiaoFu;
import com.trkj.crmproject.entity.ProCk;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.ChukuService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.ChukuVo;
import com.trkj.crmproject.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ChukuServiceImpl implements ChukuService {

    @Autowired
    private ChukuDao chukuDao;
    @Autowired
    private RkDao rkDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrdertableDao ordertableDao;

    //出库表，查询全部（连表查仓库名称，员工名称，审批类别名称）
    @Override
    public List<ChukuVo> selectChukuAll(){
        return chukuDao.selectChukuAll();
    }
    //分页
    @Override
    public PageInfo<ChukuVo> findChuku(int pageNum, int pageSize) {
        Page<ChukuVo> page= PageHelper.startPage(pageNum,pageSize);
        List<ChukuVo> list=chukuDao.selectChukuAll();
        Page<ChukuVo> depts=new Page<>();
        BeanTools.copyList(list,depts,ChukuVo.class);
        PageInfo<ChukuVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //出库表 根据仓库id查询全部
    @Override
    public List<ChukuVo> selectChukuckId(String ckName) {
        return chukuDao.selectChukuckId(ckName);
    }
    //出库表 根据出库状态查询
    @Override
    public List<ChukuVo> selectChukustate(String state){
        return chukuDao.selectChukustate(state);
    }
    //出库表 根据仓库Id 商品状态查询全部
    @Override
    public List<ChukuVo> selectChukuckstate(String ckName,String state){
        return chukuDao.selectChukuckstate(ckName,state);
    }

    //出库表 根据出库id查询详情
    @Override
    public ChukuVo selectChukuIdxq(int chukuId) {
        return chukuDao.selectChukuIdxq(chukuId);
    }
    //出库表 根据出库id查询商品及出库数量
    //分页
    @Override
    public PageInfo<ProductVo> findChukupro(int chukuId, int pageNum, int pageSize){
        Page<ProductVo> page= PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> list=chukuDao.selectChukupro(chukuId);
        Page<ProductVo> depts=new Page<>();
        BeanTools.copyList(list,depts,ProductVo.class);
        PageInfo<ProductVo> pageInfo=new PageInfo<>(depts);
        System.out.println(pageInfo);
        return pageInfo;
    }


    //出库表 修改备注
    @Override
    @Transactional
    public int updateChukubz(ChukuVo chukuVo){
        return chukuDao.updateChukubz(chukuVo);
    }


    //出库表 根据仓库id商品id查询库存
    @Override
    public List<ProCk> selectChukukc(String ckName){
        return chukuDao.selectChukukc(ckName);
    }
    // 修改出库表的状态
    @Override
    @Transactional
    public int updateChukustate(ChukuVo chukuVo){
        int ckId=rkDao.selectRkckId(chukuVo.getCkName());
        log.debug("仓库id{}：",ckId);
        int row=0;

        chukuVo.setChukuId(chukuVo.getChukuId());
        chukuVo.setCkTime(new Date());
        chukuVo.setStaffId(chukuVo.getStaffId());
        chukuVo.setState("已完成");
        log.debug("出库表修改数据{}：",chukuVo);
        row=chukuDao.updateChukustate(chukuVo);
        if(row<=0){
            throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败！");
        }

        List<ProductVo> cks=chukuVo.getProductVos();
        for (ProductVo o:cks) {
            int proId = o.getProId();
            log.debug("商品id{}：", proId);
            //根据仓库，产品id查询库存数量
            int prockNumber = rkDao.selectRknumber(proId, ckId);

            ProCk proCk = new ProCk();
            proCk.setProId(proId);
            proCk.setCkId(ckId);
            proCk.setProCkNumber(prockNumber - o.getDbNumber());
            log.debug("出库后的库存数量{}：", prockNumber - o.getDbNumber());
            //修改库存数量【根据仓库、商品id】
            row=productDao.updateProCkNumber(proCk);
            if(row<=0){
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败！");
            }
            //判断该仓库剩余数量是否大于50
            int sum = rkDao.selectRknumber(proId, ckId);
            log.debug("商品名称：{}",o.getProName());
            //根据产品id查询产品名称
            String name=o.getProName();
            if(sum<=200000){
                //添加警告
                log.debug("库存数量11111111111：{}",sum);
                int cc=ordertableDao.insertWarn("采购","请尽快补充产品"+name,"库存");
                if(cc<=0){
                    throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败！");
                }
            }
        }
        int orderId=chukuVo.getOrderId();
        int appid=chukuVo.getAppId();
        log.debug("出库表报价{}：",orderId);
        log.debug("出库表报价{}：",appid);
        if(appid==2){
            JiaoFu jiaoFu=new JiaoFu();
            jiaoFu.setJfId(orderId);
            jiaoFu.setState("交付完成");
            row=chukuDao.updateChukujf(jiaoFu);
            if(row<=0){
                throw new CustomError(CustomErrorType.USER_INPUT_ERROR,"数据更新失败！");
            }
        }
        return row;
    }

    //出库 根据仓库名称跟商品名称查询库存信息（添加通知）

}
