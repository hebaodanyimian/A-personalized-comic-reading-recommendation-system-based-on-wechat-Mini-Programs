package com.entity.view;

import com.entity.ChaptermanhuaxiaoshuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 漫画小说章节表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
@TableName("chaptermanhuaxiaoshuo")
public class ChaptermanhuaxiaoshuoView  extends ChaptermanhuaxiaoshuoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChaptermanhuaxiaoshuoView(){
	}
 
 	public ChaptermanhuaxiaoshuoView(ChaptermanhuaxiaoshuoEntity chaptermanhuaxiaoshuoEntity){
 	try {
			BeanUtils.copyProperties(this, chaptermanhuaxiaoshuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
