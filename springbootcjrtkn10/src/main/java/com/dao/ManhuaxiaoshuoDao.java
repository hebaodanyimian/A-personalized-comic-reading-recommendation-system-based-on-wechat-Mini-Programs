package com.dao;

import com.entity.ManhuaxiaoshuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ManhuaxiaoshuoVO;
import com.entity.view.ManhuaxiaoshuoView;


/**
 * 漫画小说
 * 
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
public interface ManhuaxiaoshuoDao extends BaseMapper<ManhuaxiaoshuoEntity> {
	
	List<ManhuaxiaoshuoVO> selectListVO(@Param("ew") Wrapper<ManhuaxiaoshuoEntity> wrapper);
	
	ManhuaxiaoshuoVO selectVO(@Param("ew") Wrapper<ManhuaxiaoshuoEntity> wrapper);
	
	List<ManhuaxiaoshuoView> selectListView(@Param("ew") Wrapper<ManhuaxiaoshuoEntity> wrapper);

	List<ManhuaxiaoshuoView> selectListView(Pagination page,@Param("ew") Wrapper<ManhuaxiaoshuoEntity> wrapper);

	
	ManhuaxiaoshuoView selectView(@Param("ew") Wrapper<ManhuaxiaoshuoEntity> wrapper);
	

}
