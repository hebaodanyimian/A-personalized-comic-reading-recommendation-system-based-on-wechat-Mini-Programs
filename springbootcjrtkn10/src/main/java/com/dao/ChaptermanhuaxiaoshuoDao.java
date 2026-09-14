package com.dao;

import com.entity.ChaptermanhuaxiaoshuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChaptermanhuaxiaoshuoVO;
import com.entity.view.ChaptermanhuaxiaoshuoView;


/**
 * 漫画小说章节表
 * 
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
public interface ChaptermanhuaxiaoshuoDao extends BaseMapper<ChaptermanhuaxiaoshuoEntity> {
	
	List<ChaptermanhuaxiaoshuoVO> selectListVO(@Param("ew") Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper);
	
	ChaptermanhuaxiaoshuoVO selectVO(@Param("ew") Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper);
	
	List<ChaptermanhuaxiaoshuoView> selectListView(@Param("ew") Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper);

	List<ChaptermanhuaxiaoshuoView> selectListView(Pagination page,@Param("ew") Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper);

	
	ChaptermanhuaxiaoshuoView selectView(@Param("ew") Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper);
	

}
