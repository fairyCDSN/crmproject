package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.PcplanDaozsy;
import com.trkj.crmproject.entity.Pcplanzsy;
import com.trkj.crmproject.service.PcplanzsyService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.CollectionVo;
import com.trkj.crmproject.vo.PcplanVozsy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PcplanzsyServiceImpl implements PcplanzsyService {
    @Autowired
    private PcplanDaozsy pcplanDao;

    @Override
    public PageInfo<CollectionVo> selectcollection(int pageNum, int pageSize) {
        Page<CollectionVo> page= PageHelper.startPage(pageNum,pageSize);
        List<CollectionVo> s=pcplanDao.selectcollection();
        for (CollectionVo p: s){
            System.out.println("遍历:"+p);
            System.out.println("遍历2:"+p.getMinpcstate()+p.getMaxpcstate());
            if (p.getMinpcstate().equals("回款完成") && p.getMaxpcstate().equals("待执行")){
                System.out.println("进入判断1");
                p.setState("正在回款");
            }else if (p.getMinpcstate().equals("待执行") && p.getMaxpcstate().equals("待执行")){
                System.out.println("进入判断2");
                p.setState("待执行");
            }else if (p.getMinpcstate().equals("回款完成") && p.getMaxpcstate().equals("回款完成")){
                System.out.println("进入判断3");
                p.setState("回款完成");
            }
            System.out.println("修改后:"+p);
        }
        Page<CollectionVo> depts=new Page<>();
        BeanTools.copyList(s,depts,CollectionVo.class);
        PageInfo<CollectionVo> pageInfo=new PageInfo<>(depts);
        return pageInfo;
    }

    @Override
    public PageInfo<CollectionVo> selectcollectiontj(int pageNum, int pageSize, String type, int totalone, int totaltwo) {
        int[] a=pcplanDao.findOID(type);
        List<CollectionVo> list=new ArrayList();
        for (int i=0;i<a.length;i++){
            Page<CollectionVo> page= PageHelper.startPage(pageNum,pageSize);
            CollectionVo collectionVo=pcplanDao.selectcollectiontj(a[i],type,totalone,totaltwo);
            System.out.println("CollectionVo:"+collectionVo);
            list.add(collectionVo);
        }


        for (CollectionVo p: list){
            System.out.println("遍历:"+p);
            if (p==null){
                break;
            }
            System.out.println("遍历2:"+p.getMinpcstate()+p.getMaxpcstate());
            if (p.getMinpcstate().equals("回款完成") && p.getMaxpcstate().equals("待执行")){
                System.out.println("进入判断1");
                p.setState("正在回款");
            }else if (p.getMinpcstate().equals("待执行") && p.getMaxpcstate().equals("待执行")){
                System.out.println("进入判断2");
                p.setState("待执行");
            }else if (p.getMinpcstate().equals("回款完成") && p.getMaxpcstate().equals("回款完成")){
                System.out.println("进入判断3");
                p.setState("回款完成");
            }
            System.out.println("修改后:"+p);
        }
        Page<CollectionVo> depts=new Page<>();
        BeanTools.copyList(list,depts,CollectionVo.class);
        PageInfo<CollectionVo> pageInfo=new PageInfo<>(depts);
        System.out.println("输出pageInfo:"+pageInfo);
        return pageInfo;
    }

    @Override
    public List<Pcplanzsy> selecthkmx(int orderId) {
        return pcplanDao.selecthkmx(orderId);
    }

    @Override
    public PcplanVozsy selectminhk(int orderId) {
        return pcplanDao.selectminhk(orderId);
    }

    @Override
    public int updatehkjhzt(int pcId) {
        return pcplanDao.updatehkjhzt(pcId);
    }

    @Override
    public int updatemn(int pcId, int mn) {
        return pcplanDao.updatemn(pcId,mn);
    }
}
