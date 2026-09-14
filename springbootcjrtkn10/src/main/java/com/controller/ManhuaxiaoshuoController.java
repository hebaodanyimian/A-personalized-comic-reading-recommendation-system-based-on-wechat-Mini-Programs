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

import com.entity.ManhuaxiaoshuoEntity;
import com.entity.view.ManhuaxiaoshuoView;

import com.service.ManhuaxiaoshuoService;
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
 * 漫画小说
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
@RestController
@RequestMapping("/manhuaxiaoshuo")
public class ManhuaxiaoshuoController {
    @Autowired
    private ManhuaxiaoshuoService manhuaxiaoshuoService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ManhuaxiaoshuoEntity manhuaxiaoshuo,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuojia")) {
			manhuaxiaoshuo.setZuojiazhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ManhuaxiaoshuoEntity> ew = new EntityWrapper<ManhuaxiaoshuoEntity>();


        //查询结果
		PageUtils page = manhuaxiaoshuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, manhuaxiaoshuo), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ManhuaxiaoshuoEntity manhuaxiaoshuo, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ManhuaxiaoshuoEntity> ew = new EntityWrapper<ManhuaxiaoshuoEntity>();

        //查询结果
		PageUtils page = manhuaxiaoshuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, manhuaxiaoshuo), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ManhuaxiaoshuoEntity manhuaxiaoshuo){
       	EntityWrapper<ManhuaxiaoshuoEntity> ew = new EntityWrapper<ManhuaxiaoshuoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( manhuaxiaoshuo, "manhuaxiaoshuo")); 
        return R.ok().put("data", manhuaxiaoshuoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ManhuaxiaoshuoEntity manhuaxiaoshuo){
        EntityWrapper< ManhuaxiaoshuoEntity> ew = new EntityWrapper< ManhuaxiaoshuoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( manhuaxiaoshuo, "manhuaxiaoshuo")); 
		ManhuaxiaoshuoView manhuaxiaoshuoView =  manhuaxiaoshuoService.selectView(ew);
		return R.ok("查询漫画小说成功").put("data", manhuaxiaoshuoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ManhuaxiaoshuoEntity manhuaxiaoshuo = manhuaxiaoshuoService.selectById(id);
		manhuaxiaoshuo.setClicknum(manhuaxiaoshuo.getClicknum()+1);
		manhuaxiaoshuo.setClicktime(new Date());
		manhuaxiaoshuoService.updateById(manhuaxiaoshuo);
        manhuaxiaoshuo = manhuaxiaoshuoService.selectView(new EntityWrapper<ManhuaxiaoshuoEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(manhuaxiaoshuo,deSens);
        return R.ok().put("data", manhuaxiaoshuo);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ManhuaxiaoshuoEntity manhuaxiaoshuo = manhuaxiaoshuoService.selectById(id);
		manhuaxiaoshuo.setClicknum(manhuaxiaoshuo.getClicknum()+1);
		manhuaxiaoshuo.setClicktime(new Date());
		manhuaxiaoshuoService.updateById(manhuaxiaoshuo);
        manhuaxiaoshuo = manhuaxiaoshuoService.selectView(new EntityWrapper<ManhuaxiaoshuoEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(manhuaxiaoshuo,deSens);
        return R.ok().put("data", manhuaxiaoshuo);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ManhuaxiaoshuoEntity manhuaxiaoshuo = manhuaxiaoshuoService.selectById(id);
        if(type.equals("1")) {
        	manhuaxiaoshuo.setThumbsupnum(manhuaxiaoshuo.getThumbsupnum()+1);
        } else {
        	manhuaxiaoshuo.setCrazilynum(manhuaxiaoshuo.getCrazilynum()+1);
        }
        manhuaxiaoshuoService.updateById(manhuaxiaoshuo);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ManhuaxiaoshuoEntity manhuaxiaoshuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(manhuaxiaoshuo);
        manhuaxiaoshuoService.insert(manhuaxiaoshuo);
        return R.ok().put("data",manhuaxiaoshuo.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ManhuaxiaoshuoEntity manhuaxiaoshuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(manhuaxiaoshuo);
        manhuaxiaoshuoService.insert(manhuaxiaoshuo);
        return R.ok().put("data",manhuaxiaoshuo.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ManhuaxiaoshuoEntity manhuaxiaoshuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(manhuaxiaoshuo);
        //全部更新
        manhuaxiaoshuoService.updateById(manhuaxiaoshuo);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        manhuaxiaoshuoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ManhuaxiaoshuoEntity manhuaxiaoshuo, HttpServletRequest request,String pre){
        EntityWrapper<ManhuaxiaoshuoEntity> ew = new EntityWrapper<ManhuaxiaoshuoEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = manhuaxiaoshuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, manhuaxiaoshuo), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ManhuaxiaoshuoEntity manhuaxiaoshuo, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "manhualeixing";
        // 查询收藏集合
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "manhuaxiaoshuo").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ManhuaxiaoshuoEntity> manhuaxiaoshuoList = new ArrayList<ManhuaxiaoshuoEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            List<String> typeList = new ArrayList<String>();
            for(StoreupEntity s : storeups) {
                if(typeList.contains(s.getInteltype())) continue;
                typeList.add(s.getInteltype());
                manhuaxiaoshuoList.addAll(manhuaxiaoshuoService.selectList(new EntityWrapper<ManhuaxiaoshuoEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ManhuaxiaoshuoEntity> ew = new EntityWrapper<ManhuaxiaoshuoEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        // 根据协同结果查询结果并返回
        PageUtils page = manhuaxiaoshuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, manhuaxiaoshuo), params), params));
        List<ManhuaxiaoshuoEntity> pageList = (List<ManhuaxiaoshuoEntity>)page.getList();
        if(manhuaxiaoshuoList.size()<limit) {
            int toAddNum = (limit-manhuaxiaoshuoList.size())<=pageList.size()?(limit-manhuaxiaoshuoList.size()):pageList.size();
            for(ManhuaxiaoshuoEntity o1 : pageList) {
                boolean addFlag = true;
                for(ManhuaxiaoshuoEntity o2 : manhuaxiaoshuoList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    manhuaxiaoshuoList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(manhuaxiaoshuoList.size()>limit) {
            manhuaxiaoshuoList = manhuaxiaoshuoList.subList(0, limit);
        }
        page.setList(manhuaxiaoshuoList);
        return R.ok().put("data", page);
    }






}
