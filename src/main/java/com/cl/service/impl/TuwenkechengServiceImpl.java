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


import com.cl.dao.TuwenkechengDao;
import com.cl.entity.TuwenkechengEntity;
import com.cl.service.TuwenkechengService;
import com.cl.entity.view.TuwenkechengView;

@Service("tuwenkechengService")
public class TuwenkechengServiceImpl extends ServiceImpl<TuwenkechengDao, TuwenkechengEntity> implements TuwenkechengService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<TuwenkechengEntity> wrapper) {
		Page<TuwenkechengView> page =new Query<TuwenkechengView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuwenkechengEntity> page = this.selectPage(
                new Query<TuwenkechengEntity>(params).getPage(),
                new EntityWrapper<TuwenkechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuwenkechengEntity> wrapper) {
		  Page<TuwenkechengView> page =new Query<TuwenkechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TuwenkechengView> selectListView(Wrapper<TuwenkechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuwenkechengView selectView(Wrapper<TuwenkechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
