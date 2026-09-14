package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BookmarkmanhuaxiaoshuoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BookmarkmanhuaxiaoshuoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BookmarkmanhuaxiaoshuoView;


/**
 * 漫画小说书签表
 *
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
public interface BookmarkmanhuaxiaoshuoService extends IService<BookmarkmanhuaxiaoshuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BookmarkmanhuaxiaoshuoVO> selectListVO(Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper);
   	
   	BookmarkmanhuaxiaoshuoVO selectVO(@Param("ew") Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper);
   	
   	List<BookmarkmanhuaxiaoshuoView> selectListView(Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper);
   	
   	BookmarkmanhuaxiaoshuoView selectView(@Param("ew") Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper);

   	

}

