package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShipinkechengDao;
import com.cl.entity.ShipinkechengEntity;
import com.cl.service.ShipinkechengService;
import com.cl.entity.view.ShipinkechengView;

@Service("shipinkechengService")
public class ShipinkechengServiceImpl extends ServiceImpl<ShipinkechengDao, ShipinkechengEntity> implements ShipinkechengService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ShipinkechengEntity> wrapper) {
		Page<ShipinkechengView> page =new Query<ShipinkechengView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShipinkechengEntity> page = this.selectPage(
                new Query<ShipinkechengEntity>(params).getPage(),
                new EntityWrapper<ShipinkechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShipinkechengEntity> wrapper) {
		  Page<ShipinkechengView> page =new Query<ShipinkechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShipinkechengView> selectListView(Wrapper<ShipinkechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShipinkechengView selectView(Wrapper<ShipinkechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
