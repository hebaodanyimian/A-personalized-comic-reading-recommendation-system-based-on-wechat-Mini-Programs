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
import com.entity.TokenEntity;
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

import com.entity.ZuojiaEntity;
import com.entity.view.ZuojiaView;

import com.service.ZuojiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 作家
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
@RestController
@RequestMapping("/zuojia")
public class ZuojiaController {
    @Autowired
    private ZuojiaService zuojiaService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        ZuojiaEntity u = zuojiaService.selectOne(new EntityWrapper<ZuojiaEntity>().eq("zuojiazhanghao", username));
        // 当用户不存在或验证密码不通过时
		if(u==null || !u.getMima().equals(password)) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
		
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"zuojia",  "管理员" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ZuojiaEntity zuojia){
    	//ValidatorUtils.validateEntity(zuojia);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	ZuojiaEntity u = zuojiaService.selectOne(new EntityWrapper<ZuojiaEntity>().eq("zuojiazhanghao", zuojia.getZuojiazhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同作家账号，否则返回错误信息
        if(zuojiaService.selectCount(new EntityWrapper<ZuojiaEntity>().eq("zuojiazhanghao", zuojia.getZuojiazhanghao()))>0) {
            return R.error("作家账号已存在");
        }
		Long uId = new Date().getTime();
		zuojia.setId(uId);
        //保存用户
        zuojiaService.insert(zuojia);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ZuojiaEntity u = zuojiaService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        ZuojiaEntity u = zuojiaService.selectOne(new EntityWrapper<ZuojiaEntity>().eq("zuojiazhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456
        u.setMima("123456");
        zuojiaService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuojiaEntity zuojia,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZuojiaEntity> ew = new EntityWrapper<ZuojiaEntity>();


        //查询结果
		PageUtils page = zuojiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuojia), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZuojiaEntity zuojia, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZuojiaEntity> ew = new EntityWrapper<ZuojiaEntity>();

        //查询结果
		PageUtils page = zuojiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuojia), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuojiaEntity zuojia){
       	EntityWrapper<ZuojiaEntity> ew = new EntityWrapper<ZuojiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuojia, "zuojia")); 
        return R.ok().put("data", zuojiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuojiaEntity zuojia){
        EntityWrapper< ZuojiaEntity> ew = new EntityWrapper< ZuojiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuojia, "zuojia")); 
		ZuojiaView zuojiaView =  zuojiaService.selectView(ew);
		return R.ok("查询作家成功").put("data", zuojiaView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuojiaEntity zuojia = zuojiaService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zuojia,deSens);
        return R.ok().put("data", zuojia);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuojiaEntity zuojia = zuojiaService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zuojia,deSens);
        return R.ok().put("data", zuojia);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuojiaEntity zuojia, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(zuojiaService.selectCount(new EntityWrapper<ZuojiaEntity>().eq("zuojiazhanghao", zuojia.getZuojiazhanghao()))>0) {
            return R.error("作家账号已存在");
        }
        //ValidatorUtils.validateEntity(zuojia);
        //验证账号唯一性，否则返回错误信息
        ZuojiaEntity u = zuojiaService.selectOne(new EntityWrapper<ZuojiaEntity>().eq("zuojiazhanghao", zuojia.getZuojiazhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	zuojia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		zuojia.setId(new Date().getTime());
        zuojiaService.insert(zuojia);
        return R.ok().put("data",zuojia.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuojiaEntity zuojia, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(zuojiaService.selectCount(new EntityWrapper<ZuojiaEntity>().eq("zuojiazhanghao", zuojia.getZuojiazhanghao()))>0) {
            return R.error("作家账号已存在");
        }
        //ValidatorUtils.validateEntity(zuojia);
        //验证账号唯一性，否则返回错误信息
        ZuojiaEntity u = zuojiaService.selectOne(new EntityWrapper<ZuojiaEntity>().eq("zuojiazhanghao", zuojia.getZuojiazhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	zuojia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		zuojia.setId(new Date().getTime());
        zuojiaService.insert(zuojia);
        return R.ok().put("data",zuojia.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuojiaEntity zuojia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuojia);
        //验证字段唯一性，否则返回错误信息
        if(zuojiaService.selectCount(new EntityWrapper<ZuojiaEntity>().ne("id", zuojia.getId()).eq("zuojiazhanghao", zuojia.getZuojiazhanghao()))>0) {
            return R.error("作家账号已存在");
        }
        //全部更新
        zuojiaService.updateById(zuojia);
        if(null!=zuojia.getZuojiazhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(zuojia.getZuojiazhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", zuojia.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuojiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
