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


import com.dao.ChaptermanhuaxiaoshuoDao;
import com.entity.ChaptermanhuaxiaoshuoEntity;
import com.service.ChaptermanhuaxiaoshuoService;
import com.entity.vo.ChaptermanhuaxiaoshuoVO;
import com.entity.view.ChaptermanhuaxiaoshuoView;

@Service("chaptermanhuaxiaoshuoService")
public class ChaptermanhuaxiaoshuoServiceImpl extends ServiceImpl<ChaptermanhuaxiaoshuoDao, ChaptermanhuaxiaoshuoEntity> implements ChaptermanhuaxiaoshuoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChaptermanhuaxiaoshuoEntity> page = this.selectPage(
                new Query<ChaptermanhuaxiaoshuoEntity>(params).getPage(),
                new EntityWrapper<ChaptermanhuaxiaoshuoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper) {
		  Page<ChaptermanhuaxiaoshuoView> page =new Query<ChaptermanhuaxiaoshuoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChaptermanhuaxiaoshuoVO> selectListVO(Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChaptermanhuaxiaoshuoVO selectVO(Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChaptermanhuaxiaoshuoView> selectListView(Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChaptermanhuaxiaoshuoView selectView(Wrapper<ChaptermanhuaxiaoshuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
