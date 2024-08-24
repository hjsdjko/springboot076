package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.TuwenkechengEntity;
import com.cl.entity.view.TuwenkechengView;

import com.cl.service.TuwenkechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 图文课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
@RestController
@RequestMapping("/tuwenkecheng")
public class TuwenkechengController {
    @Autowired
    private TuwenkechengService tuwenkechengService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuwenkechengEntity tuwenkecheng,
		HttpServletRequest request){
        EntityWrapper<TuwenkechengEntity> ew = new EntityWrapper<TuwenkechengEntity>();

		PageUtils page = tuwenkechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuwenkecheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuwenkechengEntity tuwenkecheng, 
		HttpServletRequest request){
        EntityWrapper<TuwenkechengEntity> ew = new EntityWrapper<TuwenkechengEntity>();

		PageUtils page = tuwenkechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuwenkecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuwenkechengEntity tuwenkecheng){
       	EntityWrapper<TuwenkechengEntity> ew = new EntityWrapper<TuwenkechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuwenkecheng, "tuwenkecheng")); 
        return R.ok().put("data", tuwenkechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuwenkechengEntity tuwenkecheng){
        EntityWrapper< TuwenkechengEntity> ew = new EntityWrapper< TuwenkechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuwenkecheng, "tuwenkecheng")); 
		TuwenkechengView tuwenkechengView =  tuwenkechengService.selectView(ew);
		return R.ok("查询图文课程成功").put("data", tuwenkechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuwenkechengEntity tuwenkecheng = tuwenkechengService.selectById(id);
		tuwenkecheng = tuwenkechengService.selectView(new EntityWrapper<TuwenkechengEntity>().eq("id", id));
        return R.ok().put("data", tuwenkecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuwenkechengEntity tuwenkecheng = tuwenkechengService.selectById(id);
		tuwenkecheng = tuwenkechengService.selectView(new EntityWrapper<TuwenkechengEntity>().eq("id", id));
        return R.ok().put("data", tuwenkecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuwenkechengEntity tuwenkecheng, HttpServletRequest request){
    	tuwenkecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuwenkecheng);
        tuwenkechengService.insert(tuwenkecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuwenkechengEntity tuwenkecheng, HttpServletRequest request){
    	tuwenkecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuwenkecheng);
        tuwenkechengService.insert(tuwenkecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TuwenkechengEntity tuwenkecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuwenkecheng);
        tuwenkechengService.updateById(tuwenkecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuwenkechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
