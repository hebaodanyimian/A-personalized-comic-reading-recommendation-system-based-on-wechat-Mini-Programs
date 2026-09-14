package com.dao;

import com.entity.BookmarkmanhuaxiaoshuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BookmarkmanhuaxiaoshuoVO;
import com.entity.view.BookmarkmanhuaxiaoshuoView;


/**
 * 漫画小说书签表
 * 
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
public interface BookmarkmanhuaxiaoshuoDao extends BaseMapper<BookmarkmanhuaxiaoshuoEntity> {
	
	List<BookmarkmanhuaxiaoshuoVO> selectListVO(@Param("ew") Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper);
	
	BookmarkmanhuaxiaoshuoVO selectVO(@Param("ew") Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper);
	
	List<BookmarkmanhuaxiaoshuoView> selectListView(@Param("ew") Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper);

	List<BookmarkmanhuaxiaoshuoView> selectListView(Pagination page,@Param("ew") Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper);

	
	BookmarkmanhuaxiaoshuoView selectView(@Param("ew") Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper);
	

}
