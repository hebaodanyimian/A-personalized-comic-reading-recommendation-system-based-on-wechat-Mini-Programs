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

import com.entity.DiscussmanhuaxiaoshuoEntity;
import com.entity.view.DiscussmanhuaxiaoshuoView;

import com.service.DiscussmanhuaxiaoshuoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 漫画小说评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
@RestController
@RequestMapping("/discussmanhuaxiaoshuo")
public class DiscussmanhuaxiaoshuoController {
    @Autowired
    private DiscussmanhuaxiaoshuoService discussmanhuaxiaoshuoService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussmanhuaxiaoshuoEntity> ew = new EntityWrapper<DiscussmanhuaxiaoshuoEntity>();


        //查询结果
		PageUtils page = discussmanhuaxiaoshuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmanhuaxiaoshuo), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussmanhuaxiaoshuoEntity> ew = new EntityWrapper<DiscussmanhuaxiaoshuoEntity>();

        //查询结果
		PageUtils page = discussmanhuaxiaoshuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmanhuaxiaoshuo), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo){
       	EntityWrapper<DiscussmanhuaxiaoshuoEntity> ew = new EntityWrapper<DiscussmanhuaxiaoshuoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussmanhuaxiaoshuo, "discussmanhuaxiaoshuo")); 
        return R.ok().put("data", discussmanhuaxiaoshuoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo){
        EntityWrapper< DiscussmanhuaxiaoshuoEntity> ew = new EntityWrapper< DiscussmanhuaxiaoshuoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussmanhuaxiaoshuo, "discussmanhuaxiaoshuo")); 
		DiscussmanhuaxiaoshuoView discussmanhuaxiaoshuoView =  discussmanhuaxiaoshuoService.selectView(ew);
		return R.ok("查询漫画小说评论表成功").put("data", discussmanhuaxiaoshuoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo = discussmanhuaxiaoshuoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussmanhuaxiaoshuo,deSens);
        return R.ok().put("data", discussmanhuaxiaoshuo);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo = discussmanhuaxiaoshuoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussmanhuaxiaoshuo,deSens);
        return R.ok().put("data", discussmanhuaxiaoshuo);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmanhuaxiaoshuo);
        discussmanhuaxiaoshuoService.insert(discussmanhuaxiaoshuo);
        return R.ok().put("data",discussmanhuaxiaoshuo.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmanhuaxiaoshuo);
        discussmanhuaxiaoshuoService.insert(discussmanhuaxiaoshuo);
        return R.ok().put("data",discussmanhuaxiaoshuo.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo = discussmanhuaxiaoshuoService.selectOne(new EntityWrapper<DiscussmanhuaxiaoshuoEntity>().eq("", username));
        return R.ok().put("data", discussmanhuaxiaoshuo);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmanhuaxiaoshuo);
        //全部更新
        discussmanhuaxiaoshuoService.updateById(discussmanhuaxiaoshuo);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussmanhuaxiaoshuoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussmanhuaxiaoshuoEntity discussmanhuaxiaoshuo, HttpServletRequest request,String pre){
        EntityWrapper<DiscussmanhuaxiaoshuoEntity> ew = new EntityWrapper<DiscussmanhuaxiaoshuoEntity>();
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
		PageUtils page = discussmanhuaxiaoshuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmanhuaxiaoshuo), params), params));
        return R.ok().put("data", page);
    }








}
