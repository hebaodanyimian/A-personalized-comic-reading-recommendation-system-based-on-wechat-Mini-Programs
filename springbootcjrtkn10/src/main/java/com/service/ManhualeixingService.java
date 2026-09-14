package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ManhualeixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ManhualeixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ManhualeixingView;


/**
 * 漫画类型
 *
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
public interface ManhualeixingService extends IService<ManhualeixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ManhualeixingVO> selectListVO(Wrapper<ManhualeixingEntity> wrapper);
   	
   	ManhualeixingVO selectVO(@Param("ew") Wrapper<ManhualeixingEntity> wrapper);
   	
   	List<ManhualeixingView> selectListView(Wrapper<ManhualeixingEntity> wrapper);
   	
   	ManhualeixingView selectView(@Param("ew") Wrapper<ManhualeixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ManhualeixingEntity> wrapper);

   	

}

