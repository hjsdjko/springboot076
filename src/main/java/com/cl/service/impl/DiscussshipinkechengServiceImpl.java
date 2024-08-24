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


import com.cl.dao.DiscussshipinkechengDao;
import com.cl.entity.DiscussshipinkechengEntity;
import com.cl.service.DiscussshipinkechengService;
import com.cl.entity.view.DiscussshipinkechengView;

@Service("discussshipinkechengService")
public class DiscussshipinkechengServiceImpl extends ServiceImpl<DiscussshipinkechengDao, DiscussshipinkechengEntity> implements DiscussshipinkechengService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<DiscussshipinkechengEntity> wrapper) {
		Page<DiscussshipinkechengView> page =new Query<DiscussshipinkechengView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshipinkechengEntity> page = this.selectPage(
                new Query<DiscussshipinkechengEntity>(params).getPage(),
                new EntityWrapper<DiscussshipinkechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshipinkechengEntity> wrapper) {
		  Page<DiscussshipinkechengView> page =new Query<DiscussshipinkechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussshipinkechengView> selectListView(Wrapper<DiscussshipinkechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshipinkechengView selectView(Wrapper<DiscussshipinkechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
