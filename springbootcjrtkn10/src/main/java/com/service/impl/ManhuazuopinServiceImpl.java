package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ManhuazuopinDao;
import com.entity.ManhuazuopinEntity;
import com.service.ManhuazuopinService;
import com.entity.vo.ManhuazuopinVO;
import com.entity.view.ManhuazuopinView;

@Service("manhuazuopinService")
public class ManhuazuopinServiceImpl extends ServiceImpl<ManhuazuopinDao, ManhuazuopinEntity> implements ManhuazuopinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ManhuazuopinEntity> page = this.selectPage(
                new Query<ManhuazuopinEntity>(params).getPage(),
                new EntityWrapper<ManhuazuopinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ManhuazuopinEntity> wrapper) {
		  Page<ManhuazuopinView> page =new Query<ManhuazuopinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ManhuazuopinVO> selectListVO(Wrapper<ManhuazuopinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ManhuazuopinVO selectVO(Wrapper<ManhuazuopinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ManhuazuopinView> selectListView(Wrapper<ManhuazuopinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ManhuazuopinView selectView(Wrapper<ManhuazuopinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
