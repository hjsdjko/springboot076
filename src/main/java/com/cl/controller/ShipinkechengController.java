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

import com.cl.entity.ShipinkechengEntity;
import com.cl.entity.view.ShipinkechengView;

import com.cl.service.ShipinkechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 视频课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
@RestController
@RequestMapping("/shipinkecheng")
public class ShipinkechengController {
    @Autowired
    private ShipinkechengService shipinkechengService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShipinkechengEntity shipinkecheng,
		HttpServletRequest request){
        EntityWrapper<ShipinkechengEntity> ew = new EntityWrapper<ShipinkechengEntity>();

		PageUtils page = shipinkechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinkecheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShipinkechengEntity shipinkecheng, 
		HttpServletRequest request){
        EntityWrapper<ShipinkechengEntity> ew = new EntityWrapper<ShipinkechengEntity>();

		PageUtils page = shipinkechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinkecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShipinkechengEntity shipinkecheng){
       	EntityWrapper<ShipinkechengEntity> ew = new EntityWrapper<ShipinkechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shipinkecheng, "shipinkecheng")); 
        return R.ok().put("data", shipinkechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShipinkechengEntity shipinkecheng){
        EntityWrapper< ShipinkechengEntity> ew = new EntityWrapper< ShipinkechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shipinkecheng, "shipinkecheng")); 
		ShipinkechengView shipinkechengView =  shipinkechengService.selectView(ew);
		return R.ok("查询视频课程成功").put("data", shipinkechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShipinkechengEntity shipinkecheng = shipinkechengService.selectById(id);
		shipinkecheng = shipinkechengService.selectView(new EntityWrapper<ShipinkechengEntity>().eq("id", id));
        return R.ok().put("data", shipinkecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShipinkechengEntity shipinkecheng = shipinkechengService.selectById(id);
		shipinkecheng = shipinkechengService.selectView(new EntityWrapper<ShipinkechengEntity>().eq("id", id));
        return R.ok().put("data", shipinkecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShipinkechengEntity shipinkecheng, HttpServletRequest request){
    	shipinkecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shipinkecheng);
        shipinkechengService.insert(shipinkecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShipinkechengEntity shipinkecheng, HttpServletRequest request){
    	shipinkecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shipinkecheng);
        shipinkechengService.insert(shipinkecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShipinkechengEntity shipinkecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipinkecheng);
        shipinkechengService.updateById(shipinkecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shipinkechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
