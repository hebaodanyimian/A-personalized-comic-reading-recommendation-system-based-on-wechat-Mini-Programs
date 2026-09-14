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

import com.entity.ManhuazuopinEntity;
import com.entity.view.ManhuazuopinView;

import com.service.ManhuazuopinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 漫画作品
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
@RestController
@RequestMapping("/manhuazuopin")
public class ManhuazuopinController {
    @Autowired
    private ManhuazuopinService manhuazuopinService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ManhuazuopinEntity manhuazuopin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuojia")) {
			manhuazuopin.setZuojiazhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ManhuazuopinEntity> ew = new EntityWrapper<ManhuazuopinEntity>();


        //查询结果
		PageUtils page = manhuazuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, manhuazuopin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ManhuazuopinEntity manhuazuopin, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ManhuazuopinEntity> ew = new EntityWrapper<ManhuazuopinEntity>();

        //查询结果
		PageUtils page = manhuazuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, manhuazuopin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ManhuazuopinEntity manhuazuopin){
       	EntityWrapper<ManhuazuopinEntity> ew = new EntityWrapper<ManhuazuopinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( manhuazuopin, "manhuazuopin")); 
        return R.ok().put("data", manhuazuopinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ManhuazuopinEntity manhuazuopin){
        EntityWrapper< ManhuazuopinEntity> ew = new EntityWrapper< ManhuazuopinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( manhuazuopin, "manhuazuopin")); 
		ManhuazuopinView manhuazuopinView =  manhuazuopinService.selectView(ew);
		return R.ok("查询漫画作品成功").put("data", manhuazuopinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ManhuazuopinEntity manhuazuopin = manhuazuopinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(manhuazuopin,deSens);
        return R.ok().put("data", manhuazuopin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ManhuazuopinEntity manhuazuopin = manhuazuopinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(manhuazuopin,deSens);
        return R.ok().put("data", manhuazuopin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ManhuazuopinEntity manhuazuopin = manhuazuopinService.selectById(id);
        if(type.equals("1")) {
        	manhuazuopin.setThumbsupnum(manhuazuopin.getThumbsupnum()+1);
        } else {
        	manhuazuopin.setCrazilynum(manhuazuopin.getCrazilynum()+1);
        }
        manhuazuopinService.updateById(manhuazuopin);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ManhuazuopinEntity manhuazuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(manhuazuopin);
        manhuazuopinService.insert(manhuazuopin);
        return R.ok().put("data",manhuazuopin.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ManhuazuopinEntity manhuazuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(manhuazuopin);
        manhuazuopinService.insert(manhuazuopin);
        return R.ok().put("data",manhuazuopin.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ManhuazuopinEntity manhuazuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(manhuazuopin);
        //全部更新
        manhuazuopinService.updateById(manhuazuopin);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        manhuazuopinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
