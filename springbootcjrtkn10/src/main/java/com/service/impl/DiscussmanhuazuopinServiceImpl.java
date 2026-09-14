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


import com.dao.DiscussmanhuazuopinDao;
import com.entity.DiscussmanhuazuopinEntity;
import com.service.DiscussmanhuazuopinService;
import com.entity.vo.DiscussmanhuazuopinVO;
import com.entity.view.DiscussmanhuazuopinView;

@Service("discussmanhuazuopinService")
public class DiscussmanhuazuopinServiceImpl extends ServiceImpl<DiscussmanhuazuopinDao, DiscussmanhuazuopinEntity> implements DiscussmanhuazuopinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmanhuazuopinEntity> page = this.selectPage(
                new Query<DiscussmanhuazuopinEntity>(params).getPage(),
                new EntityWrapper<DiscussmanhuazuopinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmanhuazuopinEntity> wrapper) {
		  Page<DiscussmanhuazuopinView> page =new Query<DiscussmanhuazuopinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussmanhuazuopinVO> selectListVO(Wrapper<DiscussmanhuazuopinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmanhuazuopinVO selectVO(Wrapper<DiscussmanhuazuopinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmanhuazuopinView> selectListView(Wrapper<DiscussmanhuazuopinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmanhuazuopinView selectView(Wrapper<DiscussmanhuazuopinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
