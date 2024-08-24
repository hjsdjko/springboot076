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


import com.cl.dao.DiscusstuwenkechengDao;
import com.cl.entity.DiscusstuwenkechengEntity;
import com.cl.service.DiscusstuwenkechengService;
import com.cl.entity.view.DiscusstuwenkechengView;

@Service("discusstuwenkechengService")
public class DiscusstuwenkechengServiceImpl extends ServiceImpl<DiscusstuwenkechengDao, DiscusstuwenkechengEntity> implements DiscusstuwenkechengService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<DiscusstuwenkechengEntity> wrapper) {
		Page<DiscusstuwenkechengView> page =new Query<DiscusstuwenkechengView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstuwenkechengEntity> page = this.selectPage(
                new Query<DiscusstuwenkechengEntity>(params).getPage(),
                new EntityWrapper<DiscusstuwenkechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstuwenkechengEntity> wrapper) {
		  Page<DiscusstuwenkechengView> page =new Query<DiscusstuwenkechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscusstuwenkechengView> selectListView(Wrapper<DiscusstuwenkechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstuwenkechengView selectView(Wrapper<DiscusstuwenkechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
