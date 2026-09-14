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

import com.entity.ManhualeixingEntity;
import com.entity.view.ManhualeixingView;

import com.service.ManhualeixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 漫画类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
@RestController
@RequestMapping("/manhualeixing")
public class ManhualeixingController {
    @Autowired
    private ManhualeixingService manhualeixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ManhualeixingEntity manhualeixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ManhualeixingEntity> ew = new EntityWrapper<ManhualeixingEntity>();


        //查询结果
		PageUtils page = manhualeixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, manhualeixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ManhualeixingEntity manhualeixing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ManhualeixingEntity> ew = new EntityWrapper<ManhualeixingEntity>();

        //查询结果
		PageUtils page = manhualeixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, manhualeixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ManhualeixingEntity manhualeixing){
       	EntityWrapper<ManhualeixingEntity> ew = new EntityWrapper<ManhualeixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( manhualeixing, "manhualeixing")); 
        return R.ok().put("data", manhualeixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ManhualeixingEntity manhualeixing){
        EntityWrapper< ManhualeixingEntity> ew = new EntityWrapper< ManhualeixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( manhualeixing, "manhualeixing")); 
		ManhualeixingView manhualeixingView =  manhualeixingService.selectView(ew);
		return R.ok("查询漫画类型成功").put("data", manhualeixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ManhualeixingEntity manhualeixing = manhualeixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(manhualeixing,deSens);
        return R.ok().put("data", manhualeixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ManhualeixingEntity manhualeixing = manhualeixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(manhualeixing,deSens);
        return R.ok().put("data", manhualeixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ManhualeixingEntity manhualeixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(manhualeixing);
        manhualeixingService.insert(manhualeixing);
        return R.ok().put("data",manhualeixing.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ManhualeixingEntity manhualeixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(manhualeixing);
        manhualeixingService.insert(manhualeixing);
        return R.ok().put("data",manhualeixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ManhualeixingEntity manhualeixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(manhualeixing);
        //全部更新
        manhualeixingService.updateById(manhualeixing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        manhualeixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
