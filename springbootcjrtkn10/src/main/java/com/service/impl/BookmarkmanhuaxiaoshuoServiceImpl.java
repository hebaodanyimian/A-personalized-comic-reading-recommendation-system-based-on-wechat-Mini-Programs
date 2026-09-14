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


import com.dao.BookmarkmanhuaxiaoshuoDao;
import com.entity.BookmarkmanhuaxiaoshuoEntity;
import com.service.BookmarkmanhuaxiaoshuoService;
import com.entity.vo.BookmarkmanhuaxiaoshuoVO;
import com.entity.view.BookmarkmanhuaxiaoshuoView;

@Service("bookmarkmanhuaxiaoshuoService")
public class BookmarkmanhuaxiaoshuoServiceImpl extends ServiceImpl<BookmarkmanhuaxiaoshuoDao, BookmarkmanhuaxiaoshuoEntity> implements BookmarkmanhuaxiaoshuoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BookmarkmanhuaxiaoshuoEntity> page = this.selectPage(
                new Query<BookmarkmanhuaxiaoshuoEntity>(params).getPage(),
                new EntityWrapper<BookmarkmanhuaxiaoshuoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper) {
		  Page<BookmarkmanhuaxiaoshuoView> page =new Query<BookmarkmanhuaxiaoshuoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<BookmarkmanhuaxiaoshuoVO> selectListVO(Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BookmarkmanhuaxiaoshuoVO selectVO(Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BookmarkmanhuaxiaoshuoView> selectListView(Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BookmarkmanhuaxiaoshuoView selectView(Wrapper<BookmarkmanhuaxiaoshuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
