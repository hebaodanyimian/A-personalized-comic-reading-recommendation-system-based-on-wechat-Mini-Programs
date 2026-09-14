<template>
	<view class="content">
		<view :style='{"alignContent":"flex-start","alignItems":"flex-start","flexWrap":"wrap","background":"#f3f5f9","display":"flex","width":"100%","height":"auto"}'>
			<view class="list-swiper-4" :style='{"width":"calc(100% - 48rpx)","margin":"20rpx auto","position":"relative","height":"360rpx","order":"-1"}' @touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd">
				<view :style='{"top":"0%","borderRadius":"32rpx","left":"0%","background":"none","width":"100%","position":"absolute","height":"360rpx"}' class="item animate__animated" :class="prevNumList4 == index  ? 'animate__zoomOutRight' : (numList4 == index  ? 'animate__zoomInLeft' : '')" v-for="(swiper,index) in swiperList" :key="index" v-if="numList4 == index || prevNumList4 == index">
					<image :style='{"width":"100%","objectFit":"cover","borderRadius":"32rpx","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img" @tap="onSwiperTap(swiper)"></image>
					<view :style='{"padding":"8rpx 20rpx","margin":"-20rpx 0 0 0","transform":"translate3d(-50%, -50%, 0)","top":"50%","color":"#000","left":"50%","background":"rgba(255, 255, 255, 0.3)","display":"none","lineHeight":"1.5","fontSize":"40rpx","position":"absolute"}'>{{ swiper.title }}</view>
				</view>
				<view class="animate__navigation" :style='{"alignItems":"center","left":"0%","bottom":"20rpx","background":"rgba(0,0,0,0)","display":"flex","width":"100%","position":"absolute","justifyContent":"center","height":"40rpx"}'>
					<block v-for="(swiper,index) in swiperList" :key="index">
						<text class="navigation-item" v-if="numList4 == index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#23baf7","height":"16rpx"}'></text>
						<text class="navigation-item" v-if="numList4 != index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"}'></text>
					</block>
				</view>
			</view>
			<!-- menu -->
			<view v-if="true" class="menu_view">
				<block v-for="(item,index1) in menuList" v-bind:key="item.roleName">
					<block v-if="index1==0" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
						<block v-bind:key="sort" v-for=" (child,sort) in menu.child">
							<block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
								<view class="menu-item" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2(child.tableName)">
									<view class="iconarr" :class="child.appFrontIcon" :style="{'color':menuColor[index]}"></view>
									
									<view class="text">{{child.menu.split("列表")[0]}}</view>
								</view>
							</block>
						</block>
					</block>
				</block>
			</view>
			<!-- 关于我们 -->
			<view :style='{"padding":"0","margin":"40rpx auto","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 48rpx)","position":"relative","height":"auto","order":"3"}'>
				<view :style='{"padding":"0 0 0 80rpx","margin":"0 0 40rpx","borderColor":"#23baf7","color":"#000","textAlign":"left","background":"url(http://codegen.caihongy.cn/20241110/8dff7d1201304c20b53f3530844a8261.png) no-repeat left center","borderWidth":"0 0 0 0px","width":"100%","fontSize":"44rpx","lineHeight":"80rpx","position":"relative","borderStyle":"solid","fontWeight":"600"}'>{{aboutUsDetail.title}}</view>
				<view :style='{"margin":"0 0 20rpx","color":"#999","textAlign":"center","display":"none","width":"100%","lineHeight":"1.5","fontSize":"32rpx"}'>{{aboutUsDetail.subtitle}}</view>
				<view :style='{"padding":"24rpx","margin":"0px 0 0","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
					<img :style='{"width":"30%","margin":"0 2% 0 0","objectFit":"cover","borderRadius":"0px","display":"inline-block","height":"200rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
					<img :style='{"width":"30%","margin":"0 2% 0 0","objectFit":"cover","borderRadius":"0px","display":"inline-block","height":"200rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
					<img :style='{"width":"30%","margin":"0","objectFit":"cover","borderRadius":"0px","display":"inline-block","height":"200rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
				</view>
				<view :style='{"padding":"24rpx","margin":"0px 0 0px 0","overflow":"hidden","color":"#666","borderRadius":"0","maxHeight":"480rpx","background":"#fff","width":"100%","lineHeight":"48rpx","fontSize":"30rpx"}' v-html="aboutUsDetail.content"></view>
				<view :style='{"border":"2rpx solid #1ccb96","padding":"0 40rpx","margin":"0 auto","textAlign":"center","display":"block","right":"20rpx","top":"0px","borderRadius":"0px","background":"#e8fff8","width":"auto","lineHeight":"72rpx","position":"absolute","zIndex":"999"}' @tap="onDetailTap('aboutus',1)">
					<text :style='{"color":"#1ccb96","fontSize":"30rpx"}'>查看更多</text>
					<text class="icon iconfont icon-tianjia14" :style='{"color":"#f5f5f5","fontSize":"28rpx","display":"none"}'></text>
				</view>
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			</view>
			<!-- 系统简介 -->
			<view :style='{"padding":"0","margin":"40rpx auto","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 48rpx)","position":"relative","height":"auto","order":"6"}'>
				<view :style='{"padding":"0 0 0 80rpx","margin":"0 0 40rpx","borderColor":"#23baf7","color":"#000","textAlign":"left","background":"url(http://codegen.caihongy.cn/20241110/8dff7d1201304c20b53f3530844a8261.png) no-repeat left center","borderWidth":"0 0 0 0px","width":"100%","fontSize":"44rpx","lineHeight":"80rpx","position":"relative","borderStyle":"solid","fontWeight":"600"}'>{{systemIntroductionDetail.title}}</view>
				<view :style='{"margin":"0 0 20rpx","color":"#999","textAlign":"center","display":"none","width":"100%","lineHeight":"1.5","fontSize":"32rpx"}'>{{systemIntroductionDetail.subtitle}}</view>
				<view :style='{"padding":"24rpx","margin":"0px 0 0","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
					<img :style='{"width":"30%","margin":"0 2% 0 0","objectFit":"cover","borderRadius":"0px","display":"inline-block","height":"200rpx"}' v-if="systemIntroductionDetail.picture1" :src="baseUrl+systemIntroductionDetail.picture1">
					<img :style='{"width":"30%","margin":"0 2% 0 0","objectFit":"cover","borderRadius":"0px","display":"inline-block","height":"200rpx"}' v-if="systemIntroductionDetail.picture2" :src="baseUrl+systemIntroductionDetail.picture2">
					<img :style='{"width":"30%","margin":"0","objectFit":"cover","borderRadius":"0px","display":"inline-block","height":"200rpx"}' v-if="systemIntroductionDetail.picture3" :src="baseUrl+systemIntroductionDetail.picture3">
				</view>
				<view :style='{"padding":"24rpx","margin":"0px 0 0px 0","overflow":"hidden","color":"#666","borderRadius":"0","maxHeight":"480rpx","background":"#fff","width":"100%","lineHeight":"48rpx","fontSize":"30rpx"}' v-html="systemIntroductionDetail.content"></view>
				<view :style='{"border":"2rpx solid #1ccb96","padding":"0 40rpx","margin":"0 auto","textAlign":"center","display":"block","right":"20rpx","top":"0px","borderRadius":"0px","background":"#e8fff8","width":"auto","lineHeight":"72rpx","position":"absolute","zIndex":"999"}' @tap="onDetailTap('systemintro',1)">
					<text :style='{"color":"#1ccb96","fontSize":"30rpx"}'>查看更多</text>
					<text class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"28rpx","display":"none"}'></text>
				</view>
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			</view>
			<!-- 商品推荐 -->
			<view class="listBox recommend" :style='{"width":"100%","padding":"0 24rpx","margin":"40rpx auto","background":"none","order":"1"}'>
				<view class="title" :style='{"padding":"0 0 0 80rpx","margin":"0 0 40rpx","borderColor":"#23baf7","textAlign":"left","background":"url(http://codegen.caihongy.cn/20241110/8dff7d1201304c20b53f3530844a8261.png) no-repeat left center","borderWidth":"0 0 0 0px","width":"100%","position":"relative","borderStyle":"solid","fontWeight":"600"}'>
					<view :style='{"color":"#000","fontSize":"44rpx"}'>漫画小说推荐</view>
				</view>
				<!-- 样式3 -->
				<view class="list-box style3" :style='{"width":"100%","padding":"0","margin":"0","height":"auto"}'>
					<view @tap="onDetailTap('manhuaxiaoshuo',product.id)" v-for="(product,index) in manhuaxiaoshuolist" :key="index" class="list-item" :style='{"alignContent":"center","margin":"0 0 40rpx","borderColor":"#1ccb96","alignItems":"center","flexWrap":"wrap","background":"#ffffff","borderWidth":"0 0 0 8rpx","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"space-between","height":"auto"}'>
						<image :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"180rpx"}' class="list-item-image" mode="aspectFill" v-if="product.tupian.substring(0,4)=='http'" :src="product.tupian"></image>
						<image :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"180rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.tupian?baseUrl+product.tupian.split(',')[0]:''"></image>
						<view class="list-item-body" :style='{"padding":"0","margin":"0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"calc(100% - 220rpx)","height":"auto"}'>
							<view :style='{"padding":"0 0px","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#1ccb96","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="list-item-title">{{product.manhuamingcheng}}</view>
							<view :style='{"padding":"0 0px","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#1ccb96","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}' class="list-item-title">{{product.manhualeixing}}</view>
							<view :style='{"width":"49%","padding":"0 0px","margin":"0 0px 0 0","display":"inline-block","order":"3"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"width":"49%","padding":"0 0px","margin":"0 0px 0 0","display":"inline-block","order":"4"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.zuojiazhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","color":"#c7ab63","display":"inline-block","order":"6"}'>
								<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.thumbsupnum}}</text>
							</view>
							<view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","color":"#82daa2","display":"inline-block","order":"5"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 0px","margin":"0 10rpx 0 0","color":"#42caa1","display":"inline-block","order":"8"}'>
								<text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.clicknum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<!-- 商品推荐 -->
			
			<!-- 商品列表 -->
			<!-- 商品列表 -->
			<!-- 新闻资讯 -->
			<view class="listBox news" :style='{"padding":"0px","margin":"40rpx auto","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 48rpx)","position":"relative","height":"auto","order":"4"}'>
				<view class="title" :style='{"padding":"0 0 0 80rpx","margin":"0 0 40rpx","borderColor":"#23baf7","color":"#000","textAlign":"left","background":"url(http://codegen.caihongy.cn/20241110/8dff7d1201304c20b53f3530844a8261.png) no-repeat left center","borderWidth":"0 0 0 0px","width":"100%","lineHeight":"80rpx","position":"relative","borderStyle":"solid","fontWeight":"600"}'>
					<view :style='{"color":"#000","fontSize":"44rpx"}'>漫画资讯</view>
					<view :style='{"border":"2rpx solid #1ccb96","padding":"0 40rpx","margin":"0 auto","textAlign":"center","display":"block","right":"0px","top":"0px","borderRadius":"0px","background":"#e8fff8","width":"auto","lineHeight":"72rpx","position":"absolute","zIndex":"999"}' @tap="onPageTap('news')">
					  <text :style='{"color":"#1ccb96","fontSize":"30rpx"}'>查看更多</text>
					  <text class="icon iconfont icon-gengduo1" :style='{"color":"#fff","fontSize":"28rpx","display":"none"}'></text>
					</view>
				</view>
				<!-- 样式9 -->
				<view class="news-box6" :style='{"width":"100%","padding":"0","margin":"0","height":"auto"}'>
					<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"boxShadow":"none","padding":"8rpx 24rpx 8rpx 200rpx","margin":"0 0 40rpx","borderRadius":"0px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20241110/bef2733079a04994a410211430010d19.jpg) no-repeat left center / 200rpx 100%,#fff","display":"flex","width":"100%","position":"relative","height":"auto"}'>
						<view :style='{"padding":"0","margin":"-36rpx 0 0 0","borderColor":"#03b882","color":"#03b882","textAlign":"center","borderRadius":"100%","top":"50%","left":"60rpx","borderWidth":"2rpx","background":"#e8fff8","width":"72rpx","lineHeight":"68rpx","fontSize":"28rpx","position":"absolute","borderStyle":"solid","height":"72rpx"}' class="num">
							<view style="width: 100%;height: 100%;position: absolute;left: 0;top: 0;" :style="{transform: 'rotate('+(-index*60)+'deg)'}" class="dian">
								<view :style='{"transform":"translateX(-50%)","borderRadius":"100%","top":"-8rpx","left":"50%","background":"#03b882","width":"16rpx","position":"absolute","height":"16rpx"}'></view>
							</view>{{ index + 1 < 10 ? '0'+(index+1) : index+1 }}
						</view>
						<view class="item-list-body" :style='{"width":"100%","padding":"20rpx 20rpx","margin":"0","borderRadius":"0 60rpx  0 0","height":"auto"}'>
							<view :style='{"padding":"4rpx 0","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"90%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","fontWeight":"600"}' class="title ">{{item.title}}</view>
							<view :style='{"padding":"0","margin":"0 0 20rpx 0","overflow":"hidden","whiteSpace":"nowrap","color":"#666","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="text">{{item.introduction}}</view>
							<view :style='{"color":"#999","margin":"0 20rpx 0 0","display":"inline-block"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"color":"#999","margin":"0 20rpx 0 0","display":"inline-block"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.name}}</text>
							</view>
							<view :style='{"color":"#bd8d3a","margin":"0 20rpx 0 0","display":"inline-block"}'>
								<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.thumbsupnum}}</text>
							</view>
							<view :style='{"color":"#3abd4c","margin":"0 20rpx 0 0","display":"inline-block"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.storeupnum}}</text>
							</view>
							<view :style='{"color":"#3abdbb","margin":"0 20rpx 0 0","display":"inline-block"}'>
								<text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.clicknum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<!-- 新闻资讯 -->
			<view v-if="scrollTop>200" @tap="scrollTopClick" :style='{"boxShadow":"0 8rpx 16rpx rgba(0,0,0,.3)","borderRadius":"50%","textAlign":"center","bottom":"20%","background":"#ff000030","width":"60rpx","lineHeight":"60rpx","position":"fixed","right":"20rpx","height":"60rpx","zIndex":"9999"}'>
				<span class="icon iconfont icon-jiantou07" :style='{"color":"#fff"}'></span>
			</view>
		</view>
	</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				startX: 0,
				prevNumList4: '',
				numList4: 0,
				timerList4: null,
				flagList4: false,
				navigationActive: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#23baf7","height":"16rpx"},
				navigationDefault: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"},
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
					'cuIcon-same',
					'cuIcon-deliver',
					'cuIcon-evaluate',
					'cuIcon-shop',
					'cuIcon-ticket',
					'cuIcon-cascades',
					'cuIcon-discover',
					'cuIcon-question',
					'cuIcon-pic',
					'cuIcon-filter',
					'cuIcon-footprint',
					'cuIcon-pulldown',
					'cuIcon-pullup',
					'cuIcon-moreandroid',
					'cuIcon-refund',
					'cuIcon-qrcode',
					'cuIcon-remind',
					'cuIcon-profile',
					'cuIcon-home',
					'cuIcon-message',
					'cuIcon-link',
					'cuIcon-lock',
					'cuIcon-unlock',
					'cuIcon-vip',
					'cuIcon-weibo',
					'cuIcon-activity',
					'cuIcon-friendadd',
					'cuIcon-friendfamous',
					'cuIcon-friend',
					'cuIcon-goods',
					'cuIcon-selection'
				],
				role : '',
				aboutUsDetail: {},
				systemIntroductionDetail: {},
				menuList: [],
				swiperMenuList:[],
				user: {},
				tableName:'',
				menuColor: '#1ccb96,#85e8a9,#03b882,#a8cc70,#6388fa,#ffbd65,#0fd38c,#52c9e1,#6388fa,#ffbd65,#0fd38c,#52c9e1'.split(','),

				//轮播
				swiperList: [],
				manhuaxiaoshuolist: [],
				news: [],
				scrollTop: 0,
			}
		},
		onPageScroll(e) {
			this.scrollTop = e.scrollTop
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
			this.menuColor = this.menuColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		async onShow() {
			if (this.timerList4&&this.timerList4!=null) clearInterval(this.timerList4)
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
				if(key==0) {
					item.frontMenu.forEach((item2,key2) => {
						if(item2.child[0].buttons.indexOf("查看")>-1) {
							this.swiperMenuList.push(item2);
						}
					})
				}
			})
			// let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
						title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			
			this.prevNumList4 = this.swiperList.length - 1
			this.timerList4 = setInterval(this.autoPlayList4, 3000)

			this.getAboutUs();
			this.getSystemIntroduction();
			// 推荐信息
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},
		methods: {
			scrollTopClick(){
				uni.pageScrollTo({
					scrollTop: 0
				})
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				// 漫画资讯
				res = await this.$api.list('news', params)
				this.news = res.data.list
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
				// 推荐信息
				params = {
					page: 1,
					limit: 4,
				}
				if(uni.getStorageSync("appUserid")) {
					res = await this.$api.recommend2('manhuaxiaoshuo', params);
				} else {
					res = await this.$api.recommend('manhuaxiaoshuo', params);
				}
				this.manhuaxiaoshuolist = res.data.list
				

			},
			autoPlayList4() {
				this.prevNumList4 = this.numList4
			
				this.numList4++
				if (this.numList4 == this.swiperList.length) this.numList4 = 0
			},
			touchStart(event) {
				this.startX = event.touches[0].clientX
				
				clearInterval(this.timerList4)
				this.flagList4 = true
			},
			touchMove(event) {
				const currentX = event.touches[0].clientX;
				const deltaX = currentX - this.startX;
				
				if (deltaX > 50) {
					// 向右滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4++
						if (this.numList4 == this.swiperList.length) this.numList4 = 0
					}
					
				} else if (deltaX < -50) {
					// 向左滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4--
						if (this.numList4 < 0) this.numList4 = this.swiperList.length - 1
					}
				}
			},
			touchEnd() {
				this.startX = 0
				this.timerList4 = setInterval(this.autoPlayList4, 3000)
				this.flagList4 = false
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						// #ifdef MP-WEIXIN
						uni.navigateTo({
						    url: '../../common/linkOthers/linkOthers?url=' + encodeURIComponent(e.url),
						});
						return false
						// #endif
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
			async getAboutUs() {
				let res = await this.$api.info('aboutus', 1)
				this.aboutUsDetail = res.data;
			},
			async getSystemIntroduction() {
				let res = await this.$api.info('systemintro', 1)
				this.systemIntroductionDetail = res.data;
			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
			onPageTap2(index) {
				let url = '../' + index + '/list'
				uni.setStorageSync("useridTag",0);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.list-swiper-4 .animate__animated {
		--animate-delay: 300ms;
	}

	.menu_view {
		border-radius: 20rpx;
		padding: 0;
		margin: 20rpx auto 0;
		background: none;
		display: flex;
		width: calc(100% - 48rpx);
		flex-wrap: wrap;
		height: auto;
		.menu-item {
			border-radius: 8rpx;
			padding: 12rpx 0;
			margin: 10rpx 0px;
			width: calc(25% - 0px);
			height: auto;
			.iconarr {
				border-radius: 20rpx;
				padding: 0;
				margin: 0px auto;
				color: #fff;
				background: none;
				display: block;
				width: 96rpx;
				font-size: 96rpx;
				line-height: 96rpx;
				text-align: center;
				height: 96rpx;
			}
			.text {
				padding: 0;
				margin: 12rpx auto 0;
				color: #333;
				width: 100%;
				font-size: 26rpx;
				line-height: 28rpx;
				text-align: center;
			}
		}
	}
</style>
