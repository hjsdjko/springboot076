package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusstuwenkechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusstuwenkechengView;


/**
 * 图文课程评论表
 *
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
public interface DiscusstuwenkechengService extends IService<DiscusstuwenkechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstuwenkechengView> selectListView(Wrapper<DiscusstuwenkechengEntity> wrapper);
   	
   	DiscusstuwenkechengView selectView(@Param("ew") Wrapper<DiscusstuwenkechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstuwenkechengEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<DiscusstuwenkechengEntity> wrapper);

}

