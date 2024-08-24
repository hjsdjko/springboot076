package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShipinkechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShipinkechengView;


/**
 * 视频课程
 *
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
public interface ShipinkechengService extends IService<ShipinkechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShipinkechengView> selectListView(Wrapper<ShipinkechengEntity> wrapper);
   	
   	ShipinkechengView selectView(@Param("ew") Wrapper<ShipinkechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShipinkechengEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ShipinkechengEntity> wrapper);

}

