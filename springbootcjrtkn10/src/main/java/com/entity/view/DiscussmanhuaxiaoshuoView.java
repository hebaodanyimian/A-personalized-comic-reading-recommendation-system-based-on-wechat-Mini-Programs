package com.entity.view;

import com.entity.DiscussmanhuaxiaoshuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 漫画小说评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
@TableName("discussmanhuaxiaoshuo")
public class DiscussmanhuaxiaoshuoView  extends DiscussmanhuaxiaoshuoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussmanhuaxiaoshuoView(){
	}
 
 	public DiscussmanhuaxiaoshuoView(DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuoEntity){
 	try {
			BeanUtils.copyProperties(this, discussmanhuaxiaoshuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
