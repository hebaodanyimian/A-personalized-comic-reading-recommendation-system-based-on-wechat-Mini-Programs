package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ManhuaxiaoshuoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ManhuaxiaoshuoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ManhuaxiaoshuoView;


/**
 * 漫画小说
 *
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
public interface ManhuaxiaoshuoService extends IService<ManhuaxiaoshuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ManhuaxiaoshuoVO> selectListVO(Wrapper<ManhuaxiaoshuoEntity> wrapper);
   	
   	ManhuaxiaoshuoVO selectVO(@Param("ew") Wrapper<ManhuaxiaoshuoEntity> wrapper);
   	
   	List<ManhuaxiaoshuoView> selectListView(Wrapper<ManhuaxiaoshuoEntity> wrapper);
   	
   	ManhuaxiaoshuoView selectView(@Param("ew") Wrapper<ManhuaxiaoshuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ManhuaxiaoshuoEntity> wrapper);

   	

}

