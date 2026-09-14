package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChaptermanhuaxiaoshuoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChaptermanhuaxiaoshuoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChaptermanhuaxiaoshuoView;


/**
 * 漫画小说章节表
 *
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
public interface ChaptermanhuaxiaoshuoService extends IService<ChaptermanhuaxiaoshuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChaptermanhuaxiaoshuoVO> selectListVO(Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper);
   	
   	ChaptermanhuaxiaoshuoVO selectVO(@Param("ew") Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper);
   	
   	List<ChaptermanhuaxiaoshuoView> selectListView(Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper);
   	
   	ChaptermanhuaxiaoshuoView selectView(@Param("ew") Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper);

   	

}

