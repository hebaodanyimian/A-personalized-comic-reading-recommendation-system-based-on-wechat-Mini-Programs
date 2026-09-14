package com.entity.vo;

import com.entity.ManhuaxiaoshuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 漫画小说
 * @author 
 * @email 
 * @date 2025-02-14 19:40:50
 */
public class ManhuaxiaoshuoVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 漫画名称
	 */
	
	private String manhuamingcheng;
		
	/**
	 * 漫画类型
	 */
	
	private String manhualeixing;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 漫画简介
	 */
	
	private String manhuajianjie;
		
	/**
	 * 作家账号
	 */
	
	private String zuojiazhanghao;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：漫画名称
	 */
	 
	public void setManhuamingcheng(String manhuamingcheng) {
		this.manhuamingcheng = manhuamingcheng;
	}
	
	/**
	 * 获取：漫画名称
	 */
	public String getManhuamingcheng() {
		return manhuamingcheng;
	}
				
	
	/**
	 * 设置：漫画类型
	 */
	 
	public void setManhualeixing(String manhualeixing) {
		this.manhualeixing = manhualeixing;
	}
	
	/**
	 * 获取：漫画类型
	 */
	public String getManhualeixing() {
		return manhualeixing;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：漫画简介
	 */
	 
	public void setManhuajianjie(String manhuajianjie) {
		this.manhuajianjie = manhuajianjie;
	}
	
	/**
	 * 获取：漫画简介
	 */
	public String getManhuajianjie() {
		return manhuajianjie;
	}
				
	
	/**
	 * 设置：作家账号
	 */
	 
	public void setZuojiazhanghao(String zuojiazhanghao) {
		this.zuojiazhanghao = zuojiazhanghao;
	}
	
	/**
	 * 获取：作家账号
	 */
	public String getZuojiazhanghao() {
		return zuojiazhanghao;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
