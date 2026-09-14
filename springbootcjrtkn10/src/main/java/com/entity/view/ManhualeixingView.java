package com.entity.view;

import com.entity.ManhualeixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 漫画类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
@TableName("manhualeixing")
public class ManhualeixingView  extends ManhualeixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ManhualeixingView(){
	}
 
 	public ManhualeixingView(ManhualeixingEntity manhualeixingEntity){
 	try {
			BeanUtils.copyProperties(this, manhualeixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
