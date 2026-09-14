package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmanhuazuopinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmanhuazuopinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmanhuazuopinView;


/**
 * 漫画作品评论表
 *
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
public interface DiscussmanhuazuopinService extends IService<DiscussmanhuazuopinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmanhuazuopinVO> selectListVO(Wrapper<DiscussmanhuazuopinEntity> wrapper);
   	
   	DiscussmanhuazuopinVO selectVO(@Param("ew") Wrapper<DiscussmanhuazuopinEntity> wrapper);
   	
   	List<DiscussmanhuazuopinView> selectListView(Wrapper<DiscussmanhuazuopinEntity> wrapper);
   	
   	DiscussmanhuazuopinView selectView(@Param("ew") Wrapper<DiscussmanhuazuopinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmanhuazuopinEntity> wrapper);

   	

}

