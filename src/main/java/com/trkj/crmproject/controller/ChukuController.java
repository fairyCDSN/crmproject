package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.service.ChukuService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.ChukuVo;
import com.trkj.crmproject.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ChukuController {

    @Autowired
    private ChukuService chukuService;

    //出库表，查询全部（连表查仓库名称，员工名称，审批类别名称）
    @GetMapping("/selectChukuAll")
    public AjaxResponse selectChukuAll(){
        return AjaxResponse.success(chukuService.selectChukuAll());
    }
    //分页
    @GetMapping("/findChuku")
    public AjaxResponse findChuku(int pageNum, int pageSize){
        PageInfo<ChukuVo> info=chukuService.findChuku(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    //出库表 根据仓库id查询全部
    @GetMapping("/selectChukuckId")
    public AjaxResponse selectChukuckId(String ckName){
        return AjaxResponse.success(chukuService.selectChukuckId(ckName));
    }

    //出库表 根据出库id查询详情
    @GetMapping("/selectChukuIdxq")
    public AjaxResponse selectChukuIdxq(int chukuId){
        return AjaxResponse.success(chukuService.selectChukuIdxq(chukuId));
    }
    //出库表 根据出库状态查询
    @GetMapping("/selectChukustate")
    public AjaxResponse selectChukustate(String state){
        return AjaxResponse.success(chukuService.selectChukustate(state));
    }
    //出库表 根据仓库Id 商品状态查询全部
    @GetMapping("/selectChukuckstate")
    public AjaxResponse selectChukuckstate(String ckName,String state){
        return AjaxResponse.success(chukuService.selectChukuckstate(ckName,state));
    }



    //出库表 根据出库id查询商品及出库数量
    //分页
    @GetMapping("/findChukupro")
    public AjaxResponse findChukupro(int chukuId, int pageNum, int pageSize){
        PageInfo<ProductVo> info=chukuService.findChukupro(chukuId,pageNum,pageSize);
        return AjaxResponse.success(info);
    }


    //出库表 修改备注
    @PutMapping("/updateChukubz")
    public AjaxResponse updateChukubz(@RequestBody ChukuVo chukuVo){
        return AjaxResponse.success(chukuService.updateChukubz(chukuVo));
    }

    //出库表 根据仓库id商品id查询库存
    @GetMapping("/selectChukukc")
    public AjaxResponse selectChukukc(String ckName){
        log.debug("出库仓库名称{}:",ckName);
        return AjaxResponse.success(chukuService.selectChukukc(ckName));
    }
    // 修改出库表的状态
    @PostMapping("/updateChukustate")
    public AjaxResponse updateChukustate(@RequestBody ChukuVo chukuVo){
        log.debug("库存表数据{}:",chukuVo);
        return AjaxResponse.success(chukuService.updateChukustate(chukuVo));
    }

    //出库 根据仓库名称跟商品名称查询库存信息（添加通知）
}
