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


import com.dao.ManhuaxiaoshuoDao;
import com.entity.ManhuaxiaoshuoEntity;
import com.service.ManhuaxiaoshuoService;
import com.entity.vo.ManhuaxiaoshuoVO;
import com.entity.view.ManhuaxiaoshuoView;

@Service("manhuaxiaoshuoService")
public class ManhuaxiaoshuoServiceImpl extends ServiceImpl<ManhuaxiaoshuoDao, ManhuaxiaoshuoEntity> implements ManhuaxiaoshuoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ManhuaxiaoshuoEntity> page = this.selectPage(
                new Query<ManhuaxiaoshuoEntity>(params).getPage(),
                new EntityWrapper<ManhuaxiaoshuoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ManhuaxiaoshuoEntity> wrapper) {
		  Page<ManhuaxiaoshuoView> page =new Query<ManhuaxiaoshuoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ManhuaxiaoshuoVO> selectListVO(Wrapper<ManhuaxiaoshuoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ManhuaxiaoshuoVO selectVO(Wrapper<ManhuaxiaoshuoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ManhuaxiaoshuoView> selectListView(Wrapper<ManhuaxiaoshuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ManhuaxiaoshuoView selectView(Wrapper<ManhuaxiaoshuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
