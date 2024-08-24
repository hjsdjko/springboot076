package com.cl.dao;

import com.cl.entity.DiscusstuwenkechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusstuwenkechengView;


/**
 * 图文课程评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
public interface DiscusstuwenkechengDao extends BaseMapper<DiscusstuwenkechengEntity> {
	
	List<DiscusstuwenkechengView> selectListView(@Param("ew") Wrapper<DiscusstuwenkechengEntity> wrapper);

	List<DiscusstuwenkechengView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusstuwenkechengEntity> wrapper);
	
	DiscusstuwenkechengView selectView(@Param("ew") Wrapper<DiscusstuwenkechengEntity> wrapper);
	
	List<DiscusstuwenkechengView> selectGroupBy(Pagination page,@Param("ew") Wrapper<DiscusstuwenkechengEntity> wrapper);

}
