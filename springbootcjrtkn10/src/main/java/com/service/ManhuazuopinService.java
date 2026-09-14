package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ManhuazuopinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ManhuazuopinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ManhuazuopinView;


/**
 * 漫画作品
 *
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
public interface ManhuazuopinService extends IService<ManhuazuopinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ManhuazuopinVO> selectListVO(Wrapper<ManhuazuopinEntity> wrapper);
   	
   	ManhuazuopinVO selectVO(@Param("ew") Wrapper<ManhuazuopinEntity> wrapper);
   	
   	List<ManhuazuopinView> selectListView(Wrapper<ManhuazuopinEntity> wrapper);
   	
   	ManhuazuopinView selectView(@Param("ew") Wrapper<ManhuazuopinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ManhuazuopinEntity> wrapper);

   	

}

