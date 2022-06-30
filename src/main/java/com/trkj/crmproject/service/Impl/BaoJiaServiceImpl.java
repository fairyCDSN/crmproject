package com.trkj.crmproject.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.BaoJiaDao;
import com.trkj.crmproject.dao.ProductDao;
import com.trkj.crmproject.dao.StaffDao;
import com.trkj.crmproject.entity.*;
import com.trkj.crmproject.exception.CustomError;
import com.trkj.crmproject.exception.CustomErrorType;
import com.trkj.crmproject.service.BaoJiaService;
import com.trkj.crmproject.util.BeanTools;
import com.trkj.crmproject.vo.BaoJiaVo;
import com.trkj.crmproject.vo.ProductVo;
import com.trkj.crmproject.vo.jfjlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaoJiaServiceImpl implements BaoJiaService {
    @Autowired
    private BaoJiaDao baoJiaDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private StaffDao staffDao;
    @Override
    public PageInfo<BaoJiaVo> findBaojia(int pageNum, int pageSize, String user_name, String customer_name, String state,
                                         String time1, String time2, int salesperson_id) {
        Page<BaoJia> page= PageHelper.startPage(pageNum,pageSize);
        List<BaoJia> list = baoJiaDao.findBaojia(user_name,customer_name,state,time1,time2,salesperson_id);
        System.out.println("报价数组"+list.get(0));
        double total=0;
        for(int i=0;i<list.size();i++){
            System.out.println("报价产品中间表");
            BjPro[] bj=baoJiaDao.findBjPro(list.get(i).getBjid());
            for (int j=0;j<bj.length;j++){
                total=bj[j].getGoodMonery()*bj[j].getGoodNumber();
            }
            list.get(i).setBj(bj);
            list.get(i).setTotal(total);
        }
        Page<BaoJiaVo> baoJias=new Page<>();
        BeanTools.copyList(list,baoJias,BaoJiaVo.class);
        PageInfo<BaoJiaVo> pageInfo=new PageInfo<>(baoJias);
        return pageInfo;
    }

    @Override
    @Transactional
    public int insertProduct(ProductVo[] ss, int user_id, String jfstyle, String plan_jftime,int customer_id,String title,int contact_id) {
        int count=baoJiaDao.insertBaoJia(staffDao.findStaffId(user_id),customer_id,contact_id);

        baoJiaDao.insertApprecords(baoJiaDao.findid(),4);
        baoJiaDao.updatebaojiaApp(baoJiaDao.findid());
        int state_id=baoJiaDao.findid1();
        int[] name=baoJiaDao.findName("报价审批");
        for(int i=0;i<name.length;i++){
            baoJiaDao.insertApprecordSon(state_id,name[i]);
        }
        for(int i=0;i<ss.length;i++){
            productDao.insertProduct(ss[i].getProId(),baoJiaDao.findid(),ss[i].getSl(),ss[i].getMo());
        }
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return count;
    }

    @Override
    @Transactional
    public int insertProduct1(ProductVo[] ss,int bjid) {
        int count=0;
        for(int i=0;i<ss.length;i++){
            count=productDao.insertProduct1(ss[i].getProId(),bjid,ss[i].getSl(),ss[i].getMo());
        }
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return count;
    }

    @Override
    public List<contact> findConName(int customer_id) {
        return baoJiaDao.findConName(customer_id);
    }

    @Override
    public contact findConXq1(int contact_id) {
        return baoJiaDao.findConXq1(contact_id);
    }

    @Override
    public List<ProductXq> findProXq(int bjid) {
        return baoJiaDao.findProXq(bjid);
    }
    @Override
    public ProductXq findProXq1(int pro_id) {
        return baoJiaDao.findProXq1(pro_id);
    }
    @Override
    @Transactional
    public int deletepro(int pro_id,int bjid) {
        int count=0;
        if(baoJiaDao.selectpro(bjid)>1){
            baoJiaDao.deletepro(pro_id,bjid);
            count=1;
        }
        return count;
    }

    @Override
    @Transactional
    public int updatepro(ProductXq[] ss,int bjid) {
        int count=baoJiaDao.updatepro(ss[0].getProId(),bjid,ss[0].getGoodNumber(),ss[0].getGoodMonery());
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return count;
    }

    @Override
    public List<jfjl> findjfjl(int bjid) {
        int j=1;
        List<jfjl> list=baoJiaDao.findjiaofu(bjid);
        for(int i=0;i<baoJiaDao.findjiaofu(bjid).size();i++){
            jfjl jf=list.get(i);
            jfjlVo[] vo=baoJiaDao.findjfjl(list.get(i).getJfId());
            jf.setQs("第"+j+"期");
            jf.setJfjlvo(vo);
            j++;
            list.set(i,jf);
        }
        return list;
    }
    @Override
    public jfjl findjfjl1(int bjid,String user_name) {
        int total=baoJiaDao.findtatal(bjid);
        int[] jfid=baoJiaDao.findjfid1(bjid);
        if(jfid.length>1){
            for(int i=0;i<jfid.length;i++){
                if(i>0){
                    baoJiaDao.delectjfjl(jfid[i]);
                    baoJiaDao.deleteAlljiaofu(baoJiaDao.findjfid2(bjid),bjid);
                }
            }
        }
        if(jfid.length==0){
            baoJiaDao.insertjiaofu(bjid,user_name,total);
            int jf_id=baoJiaDao.findjfid(bjid);
            int[] pro_id=baoJiaDao.findpro(bjid);
            for(int i=0;i<pro_id.length;i++){
                baoJiaDao.insertjfjl1(jf_id,user_name,pro_id[i],bjid);
            }
        }
        jfjl jf=baoJiaDao.findjiaofu(bjid).get(0);
        jf.setJfjlvo(baoJiaDao.findjfjl(jf.getJfId()));
        return jf;
    }
    @Override
    @Transactional
    public int insertjiaofu(int bjid,String user_name) {
        baoJiaDao.insertjiaofu(bjid,user_name,baoJiaDao.findtatal(bjid));
        int count=1;
        int jf_id=baoJiaDao.findjfid(bjid);
        int[] pro_id=baoJiaDao.findpro(bjid);
        for(int i=0;i<pro_id.length;i++){
            baoJiaDao.insertjfjl(jf_id,user_name,pro_id[i]);
        }
        return count;
    }
    @Override
    @Transactional
    public int delectjiaofu(int jf_id,int state_id) {
        int bjid=baoJiaDao.findjfbjid(jf_id);
        baoJiaDao.delectjfjl(jf_id);
        baoJiaDao.delectjiaofu(jf_id);
        int count=1;
        if(baoJiaDao.checkjfde(bjid)==0){
            baoJiaDao.delectAppSon(state_id);
            baoJiaDao.delectApp(state_id);
        }
        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return count;
    }
    @Override
    @Transactional
    public int insertordertable(jfjl[] jfjl,String fk, String user_name,String beizhu,String order_bh,String order_title) {
        int count=baoJiaDao.insertordertable(jfjl[0].getBjid(),order_bh,fk,order_title,
                jfjl[0].getPlanJftime(),baoJiaDao.findconName(jfjl[0].getBjid()),beizhu,user_name);
        double total=0;
        baoJiaDao.insertApprecords(baoJiaDao.findOrderId(),2);
        int[] name=baoJiaDao.findName("合同审批");
        System.out.println("名称"+name[0]);
        for(int i=0;i<name.length;i++){
            System.out.println("名称"+name[i]);
            baoJiaDao.insertApprecordSon(baoJiaDao.findid1(),name[i]);
        }
        int pc_da=1;
        for(int i=0;i<jfjl.length;i++){
            for(int j=0;j<jfjl[i].getJfjlvo().length;j++){
                double monery=baoJiaDao.findGoodMonery(jfjl[i].getBjid(),jfjl[i].getJfjlvo()[j].getProId());
                total=total+(jfjl[i].getJfjlvo()[j].getNumber()*monery);
                baoJiaDao.updatejfjl(jfjl[i].getJfjlvo()[j].getJfjlId(),jfjl[i].getJfjlvo()[j].getNumber());
            }
            if(jfjl[i].getPc_mn()!=0){
                baoJiaDao.insertpcplan(baoJiaDao.findorderId(),pc_da++,jfjl[i].getPc_mn(),
                        jfjl[i].getPlanJftime(),user_name);
            }
            if(jfjl.length==1){
                baoJiaDao.insertpcplan(baoJiaDao.findorderId(),1,jfjl[i].getTotal(),
                        jfjl[i].getPlanJftime(),user_name);
            }
            baoJiaDao.updatejiaofu(jfjl[i].getJfId(),total,jfjl[i].getPlanJftime(),baoJiaDao.findorderId());
            for(int j=0;j<jfjl[i].getJfjlvo().length;j++){
                if(jfjl[i].getJfjlvo()[j].getNumber()==0){
                    baoJiaDao.delectjfjl1(jfjl[i].getJfjlvo()[j].getJfjlId());
                }
            }
            if(baoJiaDao.checkjiaofu(jfjl[i].getJfId())==0){
                baoJiaDao.delectjiaofu1(jfjl[i].getJfId());
            }
            baoJiaDao.updatebaojia(jfjl[0].getBjid());
        }

        if(count==0){
            throw new CustomError(CustomErrorType.DATABASE_OP_ERROR,"数据更新异常");
        }
        return 0;
    }

}
