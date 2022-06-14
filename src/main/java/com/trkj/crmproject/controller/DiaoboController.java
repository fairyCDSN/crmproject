package com.trkj.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Apprecords;
import com.trkj.crmproject.entity.Diaobo;
import com.trkj.crmproject.service.DiaoboService;
import com.trkj.crmproject.vo.AjaxResponse;
import com.trkj.crmproject.vo.DiaoboVo;
import com.trkj.crmproject.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class DiaoboController {

    @Autowired
    private DiaoboService diaoboService;

    //分页
    @GetMapping("/finddb")
    public AjaxResponse finddb(int pageNum, int pageSize){
        PageInfo<DiaoboVo> info=diaoboService.finddb(pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    //调拨详情  根据调拨id查询商品信息
    @GetMapping("/selectDbidproName")
    public AjaxResponse selectDbidproName(int dbId){
        return AjaxResponse.success(diaoboService.selectDbidproName(dbId));
    }
    @GetMapping("/finddbproName")
    public AjaxResponse finddbproName(int dbId,int pageNum, int pageSize){
        PageInfo<ProductVo> info=diaoboService.finddbproName(dbId,pageNum,pageSize);
        return AjaxResponse.success(info);
    }

    //调拨详情 根据调拨id查询调拨信息
    @GetMapping("/selectDbidxq")
    public AjaxResponse selectDbidxq(int dbId){
        return AjaxResponse.success(diaoboService.selectDbidxq(dbId));
    }

    //调拨管理  修改
    @PutMapping("/updateDbidbz")
    public AjaxResponse updateDbidbz(@RequestBody DiaoboVo diaoboVo){
        return AjaxResponse.success(diaoboService.updateDbidbz(diaoboVo));
    }

    //调拨列表 根据调出仓库查询全部
    @GetMapping("/selectDbdcName")
    public AjaxResponse selectDbdcName(String dcName){
        return AjaxResponse.success(diaoboService.selectDbdcName(dcName));
    }
    //调拨列表 根据调入仓库查询全部
    @GetMapping("/selectDbdrName")
    public AjaxResponse selectDbdrName(String drName){
        return AjaxResponse.success(diaoboService.selectDbdrName(drName));
    }

    //调拨列表 根据时间，调出调入仓库查询
    @GetMapping("/selectDbTimeandckName")
    public AjaxResponse selectDbTimeandckName(String dcName,String drName,String ksdbTime,String jsdbTime){
        log.debug("调拨列表根据时间查询ksdbTime"+ksdbTime);
        log.debug("调拨列表根据时间查询jsdbTime"+jsdbTime);
        log.debug("调拨列表dcName"+dcName);
        log.debug("调拨列表drName"+drName);
        return AjaxResponse.success(diaoboService.selectDbTimeandckName(dcName,drName,ksdbTime,jsdbTime));
    }


    //调拨表 根据仓库id，商品名称查询
    @GetMapping("/selectPdckIdproName")
    public AjaxResponse selectPdckIdproName(int ckId,String[] proName){
        log.debug("调拨列表仓库id"+ckId);
        List list=new ArrayList<>();
        for (int i=0;i<proName.length;i++){
            log.debug("商品名称："+proName[i]);
            list.add(diaoboService.selectPdckIdproName(ckId,proName[i]));
        }
        return AjaxResponse.success(list);
    }




    //调拨表 查询不等于出库id的入库id
    @GetMapping("/selectdbckdrId")
    public AjaxResponse selectdbckdrId(int ckId){
        return AjaxResponse.success(diaoboService.selectdbckdrId(ckId));
    }

    //审批，查询最大编号
    @GetMapping("/selectdbAppId")
    public AjaxResponse selectdbAppId(){
        return AjaxResponse.success(diaoboService.selectdbAppId());
    }
    //查询调拨最大编号
    @GetMapping("/selectdbId")
    public AjaxResponse selectdbId(){
        return AjaxResponse.success(diaoboService.selectdbId());
    }


    //添加审批子表，查询有审批权限的用户id
    @GetMapping("/selectdbusersId")
    public AjaxResponse selectdbusersId(){
        return AjaxResponse.success(diaoboService.selectdbusersId());
    }



    //添加调拨单
    @PostMapping("/insertDiaobo")
    public AjaxResponse insertDiaobo(@RequestBody Diaobo diaobo){
        System.out.println(diaobo);
        return AjaxResponse.success(diaoboService.insertDiaobo(diaobo));
    }

    //根据调拨id查询审批状态（通过）
    @GetMapping("/selectdbappState")
    public AjaxResponse selectdbappState(int dbId){
        return AjaxResponse.success(diaoboService.selectdbappState(dbId));
    }
}
