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


import com.dao.ManhualeixingDao;
import com.entity.ManhualeixingEntity;
import com.service.ManhualeixingService;
import com.entity.vo.ManhualeixingVO;
import com.entity.view.ManhualeixingView;

@Service("manhualeixingService")
public class ManhualeixingServiceImpl extends ServiceImpl<ManhualeixingDao, ManhualeixingEntity> implements ManhualeixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ManhualeixingEntity> page = this.selectPage(
                new Query<ManhualeixingEntity>(params).getPage(),
                new EntityWrapper<ManhualeixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ManhualeixingEntity> wrapper) {
		  Page<ManhualeixingView> page =new Query<ManhualeixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ManhualeixingVO> selectListVO(Wrapper<ManhualeixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ManhualeixingVO selectVO(Wrapper<ManhualeixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ManhualeixingView> selectListView(Wrapper<ManhualeixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ManhualeixingView selectView(Wrapper<ManhualeixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
