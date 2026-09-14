package com.dao;

import com.entity.DiscussmanhuaxiaoshuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussmanhuaxiaoshuoVO;
import com.entity.view.DiscussmanhuaxiaoshuoView;


/**
 * 漫画小说评论表
 * 
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
public interface DiscussmanhuaxiaoshuoDao extends BaseMapper<DiscussmanhuaxiaoshuoEntity> {
	
	List<DiscussmanhuaxiaoshuoVO> selectListVO(@Param("ew") Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper);
	
	DiscussmanhuaxiaoshuoVO selectVO(@Param("ew") Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper);
	
	List<DiscussmanhuaxiaoshuoView> selectListView(@Param("ew") Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper);

	List<DiscussmanhuaxiaoshuoView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper);

	
	DiscussmanhuaxiaoshuoView selectView(@Param("ew") Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper);
	

}
