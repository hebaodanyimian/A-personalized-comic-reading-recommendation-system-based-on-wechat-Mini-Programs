package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.BookmarkmanhuaxiaoshuoEntity;
import com.entity.view.BookmarkmanhuaxiaoshuoView;

import com.service.BookmarkmanhuaxiaoshuoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 漫画小说书签表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
@RestController
@RequestMapping("/bookmarkmanhuaxiaoshuo")
public class BookmarkmanhuaxiaoshuoController {
    @Autowired
    private BookmarkmanhuaxiaoshuoService bookmarkmanhuaxiaoshuoService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<BookmarkmanhuaxiaoshuoEntity> ew = new EntityWrapper<BookmarkmanhuaxiaoshuoEntity>();


        //查询结果
		PageUtils page = bookmarkmanhuaxiaoshuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bookmarkmanhuaxiaoshuo), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<BookmarkmanhuaxiaoshuoEntity> ew = new EntityWrapper<BookmarkmanhuaxiaoshuoEntity>();

        //查询结果
		PageUtils page = bookmarkmanhuaxiaoshuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bookmarkmanhuaxiaoshuo), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo){
       	EntityWrapper<BookmarkmanhuaxiaoshuoEntity> ew = new EntityWrapper<BookmarkmanhuaxiaoshuoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bookmarkmanhuaxiaoshuo, "bookmarkmanhuaxiaoshuo")); 
        return R.ok().put("data", bookmarkmanhuaxiaoshuoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo){
        EntityWrapper< BookmarkmanhuaxiaoshuoEntity> ew = new EntityWrapper< BookmarkmanhuaxiaoshuoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bookmarkmanhuaxiaoshuo, "bookmarkmanhuaxiaoshuo")); 
		BookmarkmanhuaxiaoshuoView bookmarkmanhuaxiaoshuoView =  bookmarkmanhuaxiaoshuoService.selectView(ew);
		return R.ok("查询漫画小说书签表成功").put("data", bookmarkmanhuaxiaoshuoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo = bookmarkmanhuaxiaoshuoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(bookmarkmanhuaxiaoshuo,deSens);
        return R.ok().put("data", bookmarkmanhuaxiaoshuo);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo = bookmarkmanhuaxiaoshuoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(bookmarkmanhuaxiaoshuo,deSens);
        return R.ok().put("data", bookmarkmanhuaxiaoshuo);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bookmarkmanhuaxiaoshuo);
        bookmarkmanhuaxiaoshuoService.insert(bookmarkmanhuaxiaoshuo);
        return R.ok().put("data",bookmarkmanhuaxiaoshuo.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bookmarkmanhuaxiaoshuo);
        bookmarkmanhuaxiaoshuoService.insert(bookmarkmanhuaxiaoshuo);
        return R.ok().put("data",bookmarkmanhuaxiaoshuo.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo = bookmarkmanhuaxiaoshuoService.selectOne(new EntityWrapper<BookmarkmanhuaxiaoshuoEntity>().eq("", username));
        return R.ok().put("data", bookmarkmanhuaxiaoshuo);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bookmarkmanhuaxiaoshuo);
        //全部更新
        bookmarkmanhuaxiaoshuoService.updateById(bookmarkmanhuaxiaoshuo);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bookmarkmanhuaxiaoshuoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,BookmarkmanhuaxiaoshuoEntity bookmarkmanhuaxiaoshuo, HttpServletRequest request,String pre){
        EntityWrapper<BookmarkmanhuaxiaoshuoEntity> ew = new EntityWrapper<BookmarkmanhuaxiaoshuoEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = bookmarkmanhuaxiaoshuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bookmarkmanhuaxiaoshuo), params), params));
        return R.ok().put("data", page);
    }








}
