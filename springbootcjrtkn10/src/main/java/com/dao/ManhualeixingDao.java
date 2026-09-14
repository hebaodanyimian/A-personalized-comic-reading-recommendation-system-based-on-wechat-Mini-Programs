package com.dao;

import com.entity.ManhualeixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ManhualeixingVO;
import com.entity.view.ManhualeixingView;


/**
 * 漫画类型
 * 
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
public interface ManhualeixingDao extends BaseMapper<ManhualeixingEntity> {
	
	List<ManhualeixingVO> selectListVO(@Param("ew") Wrapper<ManhualeixingEntity> wrapper);
	
	ManhualeixingVO selectVO(@Param("ew") Wrapper<ManhualeixingEntity> wrapper);
	
	List<ManhualeixingView> selectListView(@Param("ew") Wrapper<ManhualeixingEntity> wrapper);

	List<ManhualeixingView> selectListView(Pagination page,@Param("ew") Wrapper<ManhualeixingEntity> wrapper);

	
	ManhualeixingView selectView(@Param("ew") Wrapper<ManhualeixingEntity> wrapper);
	

}
