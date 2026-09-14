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


import com.dao.DiscussmanhuaxiaoshuoDao;
import com.entity.DiscussmanhuaxiaoshuoEntity;
import com.service.DiscussmanhuaxiaoshuoService;
import com.entity.vo.DiscussmanhuaxiaoshuoVO;
import com.entity.view.DiscussmanhuaxiaoshuoView;

@Service("discussmanhuaxiaoshuoService")
public class DiscussmanhuaxiaoshuoServiceImpl extends ServiceImpl<DiscussmanhuaxiaoshuoDao, DiscussmanhuaxiaoshuoEntity> implements DiscussmanhuaxiaoshuoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmanhuaxiaoshuoEntity> page = this.selectPage(
                new Query<DiscussmanhuaxiaoshuoEntity>(params).getPage(),
                new EntityWrapper<DiscussmanhuaxiaoshuoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper) {
		  Page<DiscussmanhuaxiaoshuoView> page =new Query<DiscussmanhuaxiaoshuoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussmanhuaxiaoshuoVO> selectListVO(Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmanhuaxiaoshuoVO selectVO(Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmanhuaxiaoshuoView> selectListView(Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmanhuaxiaoshuoView selectView(Wrapper<DiscussmanhuaxiaoshuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
