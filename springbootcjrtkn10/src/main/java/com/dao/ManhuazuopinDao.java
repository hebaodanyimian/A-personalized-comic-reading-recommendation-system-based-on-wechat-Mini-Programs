package com.dao;

import com.entity.ManhuazuopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ManhuazuopinVO;
import com.entity.view.ManhuazuopinView;


/**
 * 漫画作品
 * 
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
public interface ManhuazuopinDao extends BaseMapper<ManhuazuopinEntity> {
	
	List<ManhuazuopinVO> selectListVO(@Param("ew") Wrapper<ManhuazuopinEntity> wrapper);
	
	ManhuazuopinVO selectVO(@Param("ew") Wrapper<ManhuazuopinEntity> wrapper);
	
	List<ManhuazuopinView> selectListView(@Param("ew") Wrapper<ManhuazuopinEntity> wrapper);

	List<ManhuazuopinView> selectListView(Pagination page,@Param("ew") Wrapper<ManhuazuopinEntity> wrapper);

	
	ManhuazuopinView selectView(@Param("ew") Wrapper<ManhuazuopinEntity> wrapper);
	

}
