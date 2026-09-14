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

import com.entity.DiscussmanhuazuopinEntity;
import com.entity.view.DiscussmanhuazuopinView;

import com.service.DiscussmanhuazuopinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 漫画作品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-14 19:40:51
 */
@RestController
@RequestMapping("/discussmanhuazuopin")
public class DiscussmanhuazuopinController {
    @Autowired
    private DiscussmanhuazuopinService discussmanhuazuopinService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussmanhuazuopinEntity discussmanhuazuopin,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussmanhuazuopinEntity> ew = new EntityWrapper<DiscussmanhuazuopinEntity>();


        //查询结果
		PageUtils page = discussmanhuazuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmanhuazuopin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscussmanhuazuopinEntity discussmanhuazuopin, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussmanhuazuopinEntity> ew = new EntityWrapper<DiscussmanhuazuopinEntity>();

        //查询结果
		PageUtils page = discussmanhuazuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmanhuazuopin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussmanhuazuopinEntity discussmanhuazuopin){
       	EntityWrapper<DiscussmanhuazuopinEntity> ew = new EntityWrapper<DiscussmanhuazuopinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussmanhuazuopin, "discussmanhuazuopin")); 
        return R.ok().put("data", discussmanhuazuopinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussmanhuazuopinEntity discussmanhuazuopin){
        EntityWrapper< DiscussmanhuazuopinEntity> ew = new EntityWrapper< DiscussmanhuazuopinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussmanhuazuopin, "discussmanhuazuopin")); 
		DiscussmanhuazuopinView discussmanhuazuopinView =  discussmanhuazuopinService.selectView(ew);
		return R.ok("查询漫画作品评论表成功").put("data", discussmanhuazuopinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussmanhuazuopinEntity discussmanhuazuopin = discussmanhuazuopinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussmanhuazuopin,deSens);
        return R.ok().put("data", discussmanhuazuopin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussmanhuazuopinEntity discussmanhuazuopin = discussmanhuazuopinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussmanhuazuopin,deSens);
        return R.ok().put("data", discussmanhuazuopin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussmanhuazuopinEntity discussmanhuazuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmanhuazuopin);
        discussmanhuazuopinService.insert(discussmanhuazuopin);
        return R.ok().put("data",discussmanhuazuopin.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussmanhuazuopinEntity discussmanhuazuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmanhuazuopin);
        discussmanhuazuopinService.insert(discussmanhuazuopin);
        return R.ok().put("data",discussmanhuazuopin.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussmanhuazuopinEntity discussmanhuazuopin = discussmanhuazuopinService.selectOne(new EntityWrapper<DiscussmanhuazuopinEntity>().eq("", username));
        return R.ok().put("data", discussmanhuazuopin);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussmanhuazuopinEntity discussmanhuazuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmanhuazuopin);
        //全部更新
        discussmanhuazuopinService.updateById(discussmanhuazuopin);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussmanhuazuopinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussmanhuazuopinEntity discussmanhuazuopin, HttpServletRequest request,String pre){
        EntityWrapper<DiscussmanhuazuopinEntity> ew = new EntityWrapper<DiscussmanhuazuopinEntity>();
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
		PageUtils page = discussmanhuazuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmanhuazuopin), params), params));
        return R.ok().put("data", page);
    }








}
