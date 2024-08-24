package com.cl.dao;

import com.cl.entity.DiscussshipinkechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshipinkechengView;


/**
 * 视频课程评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
public interface DiscussshipinkechengDao extends BaseMapper<DiscussshipinkechengEntity> {
	
	List<DiscussshipinkechengView> selectListView(@Param("ew") Wrapper<DiscussshipinkechengEntity> wrapper);

	List<DiscussshipinkechengView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshipinkechengEntity> wrapper);
	
	DiscussshipinkechengView selectView(@Param("ew") Wrapper<DiscussshipinkechengEntity> wrapper);
	
	List<DiscussshipinkechengView> selectGroupBy(Pagination page,@Param("ew") Wrapper<DiscussshipinkechengEntity> wrapper);

}
