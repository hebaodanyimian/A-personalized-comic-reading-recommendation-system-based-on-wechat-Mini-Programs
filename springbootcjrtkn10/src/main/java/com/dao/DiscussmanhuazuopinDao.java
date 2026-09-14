package com.dao;

import com.entity.DiscussmanhuazuopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussmanhuazuopinVO;
import com.entity.view.DiscussmanhuazuopinView;


/**
 * 漫画作品评论表
 * 
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
public interface DiscussmanhuazuopinDao extends BaseMapper<DiscussmanhuazuopinEntity> {
	
	List<DiscussmanhuazuopinVO> selectListVO(@Param("ew") Wrapper<DiscussmanhuazuopinEntity> wrapper);
	
	DiscussmanhuazuopinVO selectVO(@Param("ew") Wrapper<DiscussmanhuazuopinEntity> wrapper);
	
	List<DiscussmanhuazuopinView> selectListView(@Param("ew") Wrapper<DiscussmanhuazuopinEntity> wrapper);

	List<DiscussmanhuazuopinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmanhuazuopinEntity> wrapper);

	
	DiscussmanhuazuopinView selectView(@Param("ew") Wrapper<DiscussmanhuazuopinEntity> wrapper);
	

}
