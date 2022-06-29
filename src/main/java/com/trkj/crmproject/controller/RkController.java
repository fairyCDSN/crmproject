package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Category;
import com.trkj.crmproject.entity.mybatis_plus.Product;
import com.trkj.crmproject.entity.mybatis_plus.RkMp;
import com.trkj.crmproject.service.RkService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.ProductVo;
import com.trkj.crmproject.vo.RkVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class RkController {

    @Autowired
    private RkService rkService;

    //入库表 查询入库表全部（连仓库，审批类别查）
    @GetMapping("/selectRkall")
    public AjaxResponse selectRkall(){
        return AjaxResponse.success(rkService.selectRkall());
    }
    //分页
    @GetMapping("/findRk")
    public AjaxResponse findRk(int pageNum, int pageSize){
        PageInfo<RkVo> info=rkService.findRk(pageNum,pageSize);
        return AjaxResponse.success(info);
    }


    //入库表 根据仓库名称查询全部
    @GetMapping("/selectRkckName")
    public AjaxResponse selectRkckName(String ckName){
        return AjaxResponse.success(rkService.selectRkckName(ckName));
    }
    //入库表 根据入库状态查询
    @GetMapping("/selectRkstate")
    public AjaxResponse selectRkstate(String state){
        return AjaxResponse.success(rkService.selectRkstate(state));
    }
    //入库表 根据仓库名称 商品状态查询全部
    @GetMapping("/selectRkckstate")
    public AjaxResponse selectRkckstate(String ckName,String state){
        return AjaxResponse.success(rkService.selectRkckstate(ckName,state));
    }

    //入库表 根据入库id查询入库信息
    //入库表 根据入库id查询商品及入库数量
    @GetMapping("/selectRkxq")
    public AjaxResponse selectRkxq(int rkId){
        return AjaxResponse.success(rkService.selectRkxq(rkId));
    }
    @GetMapping("/selectRkpro")
    public AjaxResponse selectRkpro(int rkId){
        return AjaxResponse.success(rkService.selectRkpro(rkId));
    }
    //分页
    @GetMapping("/findRkpro")
    public AjaxResponse findRkpro(int rkId,int pageNum, int pageSize){
        PageInfo<ProductVo> info=rkService.findRkpro(rkId,pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    //入库表 修改备注
    @PutMapping("/updateRkbz")
    public AjaxResponse updateRkbz(@RequestBody RkVo rkVo){
        return AjaxResponse.success(rkService.updateRkbz(rkVo));
    }


    //入库表 添加商品（查询商品的最大id）
    @GetMapping("/selectPromax")
    public AjaxResponse selectPromax(){
        return AjaxResponse.success(rkService.selectPromax());
    }

    //添加商品类别
    @PostMapping("/insertRkcat")
    public AjaxResponse insertRkcat(@RequestBody Category category){
        log.debug("商品类别{}：",category);
        return AjaxResponse.success(rkService.insertRkcat(category));
    }
    //添加商品
    @PostMapping("/insertRkpro")
    public AjaxResponse insertRkpro(@RequestBody Product product){
        log.debug("商品{}：",product);
        return AjaxResponse.success(rkService.insertRkpro(product));
    }

    //入库表，根据商品名称查商品
    @GetMapping("/selectRkproname")
    public AjaxResponse selectRkproname(String[] proName){
        List list=new ArrayList<>();
        for (int i=0;i<proName.length;i++){
            log.debug("商品名称："+proName[i]);
            list.add(rkService.selectRkproname(proName[i]));
        }
        log.debug("商品："+list);
        return AjaxResponse.success(list);
    }
    // 添加入库表
    @PostMapping("/insertRk")
    public AjaxResponse insertRk(@RequestBody RkMp rkMp){
        log.debug("入库数据{}：",rkMp);
        return AjaxResponse.success(rkService.insertRk(rkMp));
    }



    //添加入库（修改库存表，修改入库表状态）
    @PostMapping("/updateRkstate")
    public AjaxResponse updateRkstate(@RequestBody RkVo rkVo){
        log.debug("库存表数据{}:",rkVo);
        log.debug("库存表数据id{}:",rkVo.getCkName());
        return AjaxResponse.success(rkService.updateRkstate(rkVo));
    }
    //入库表，查询调拨类别的是否已经出库
    @GetMapping("/selectRktype")
    public AjaxResponse selectRktype(int rkId){
        return AjaxResponse.success(rkService.selectRktype(rkId));
    }

}
