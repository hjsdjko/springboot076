package com.cl.dao;

import com.cl.entity.ShipinkechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShipinkechengView;


/**
 * 视频课程
 * 
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
public interface ShipinkechengDao extends BaseMapper<ShipinkechengEntity> {
	
	List<ShipinkechengView> selectListView(@Param("ew") Wrapper<ShipinkechengEntity> wrapper);

	List<ShipinkechengView> selectListView(Pagination page,@Param("ew") Wrapper<ShipinkechengEntity> wrapper);
	
	ShipinkechengView selectView(@Param("ew") Wrapper<ShipinkechengEntity> wrapper);
	
	List<ShipinkechengView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ShipinkechengEntity> wrapper);

}
