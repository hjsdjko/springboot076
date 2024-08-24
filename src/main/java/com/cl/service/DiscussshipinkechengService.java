package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussshipinkechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshipinkechengView;


/**
 * 视频课程评论表
 *
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
public interface DiscussshipinkechengService extends IService<DiscussshipinkechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshipinkechengView> selectListView(Wrapper<DiscussshipinkechengEntity> wrapper);
   	
   	DiscussshipinkechengView selectView(@Param("ew") Wrapper<DiscussshipinkechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshipinkechengEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<DiscussshipinkechengEntity> wrapper);

}

