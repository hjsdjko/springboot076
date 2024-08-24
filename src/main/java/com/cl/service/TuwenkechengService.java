package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TuwenkechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TuwenkechengView;


/**
 * 图文课程
 *
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
public interface TuwenkechengService extends IService<TuwenkechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuwenkechengView> selectListView(Wrapper<TuwenkechengEntity> wrapper);
   	
   	TuwenkechengView selectView(@Param("ew") Wrapper<TuwenkechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuwenkechengEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<TuwenkechengEntity> wrapper);

}

