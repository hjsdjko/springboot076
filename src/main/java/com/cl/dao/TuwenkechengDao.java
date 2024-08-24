package com.cl.dao;

import com.cl.entity.TuwenkechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TuwenkechengView;


/**
 * 图文课程
 * 
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
public interface TuwenkechengDao extends BaseMapper<TuwenkechengEntity> {
	
	List<TuwenkechengView> selectListView(@Param("ew") Wrapper<TuwenkechengEntity> wrapper);

	List<TuwenkechengView> selectListView(Pagination page,@Param("ew") Wrapper<TuwenkechengEntity> wrapper);
	
	TuwenkechengView selectView(@Param("ew") Wrapper<TuwenkechengEntity> wrapper);
	
	List<TuwenkechengView> selectGroupBy(Pagination page,@Param("ew") Wrapper<TuwenkechengEntity> wrapper);

}
