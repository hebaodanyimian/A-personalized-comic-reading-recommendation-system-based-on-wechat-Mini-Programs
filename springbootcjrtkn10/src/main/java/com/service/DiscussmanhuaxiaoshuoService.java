package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmanhuaxiaoshuoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmanhuaxiaoshuoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmanhuaxiaoshuoView;


/**
 * 漫画小说评论表
 *
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
public interface DiscussmanhuaxiaoshuoService extends IService<DiscussmanhuaxiaoshuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmanhuaxiaoshuoVO> selectListVO(Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper);
   	
   	DiscussmanhuaxiaoshuoVO selectVO(@Param("ew") Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper);
   	
   	List<DiscussmanhuaxiaoshuoView> selectListView(Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper);
   	
   	DiscussmanhuaxiaoshuoView selectView(@Param("ew") Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper);

   	

}

