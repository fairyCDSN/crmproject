package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.JiaoFu;
import com.trkj.crmproject.entity.ProCk;
import com.trkj.crmproject.entity.mybatis_plus.ChukuMp;
import com.trkj.crmproject.vo.ChukuVo;
import com.trkj.crmproject.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChukuDao extends BaseMapper<ChukuMp> {

    //出库表，查询全部（连表查仓库名称，员工名称，审批类别名称）
    List<ChukuVo> selectChukuAll();

    //出库表 根据仓库id查询全部
    List<ChukuVo> selectChukuckId(String ckName);
    //出库表 根据出库状态查询
    List<ChukuVo> selectChukustate(String state);
    //出库表 根据仓库Id 商品状态查询全部
    List<ChukuVo> selectChukuckstate(String ckName,String state);

    //出库表 根据出库id查询详情
    ChukuVo selectChukuIdxq(int chukuId);
    //出库表 根据出库id查询商品及出库数量
    List<ProductVo> selectChukupro(int chukuId);


    //出库表 修改备注
    int updateChukubz(ChukuVo chukuVo);

    // 修改出库表的状态
    int updateChukustate(ChukuVo chukuVo);
    //根据仓库，查询商品库存
    List<ProCk> selectChukukc(String ckName);


    //出库功能  修改jiaofu 表的state 状态（交付完成）
    int updateChukujf(JiaoFu jiaoFu);
    //出库 根据仓库名称跟商品名称查询库存信息（添加通知）
    ProCk selectChukunumber(@Param("pro_id") int proId, @Param("ck_name") String ckName);
}
