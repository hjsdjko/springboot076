package com.cl.entity.view;

import com.cl.entity.DiscussshipinkechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 视频课程评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-25 10:23:31
 */
@TableName("discussshipinkecheng")
public class DiscussshipinkechengView  extends DiscussshipinkechengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussshipinkechengView(){
	}
 
 	public DiscussshipinkechengView(DiscussshipinkechengEntity discussshipinkechengEntity){
 	try {
			BeanUtils.copyProperties(this, discussshipinkechengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
