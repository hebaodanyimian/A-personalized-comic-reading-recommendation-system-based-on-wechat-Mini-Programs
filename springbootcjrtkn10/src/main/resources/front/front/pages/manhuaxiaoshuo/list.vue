<template>
<!-- category 1 -->
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
		<view class="content">
			<view :style='{"width":"100%","padding":"0 20rpx 48rpx","position":"relative","background":"#f3f5f9","height":"auto"}'>
				<view class="cu-bar bg-white search" :style='{"width":"calc(100% - 90rpx)","padding":"20rpx 0","background":"none","display":"flex","height":"auto"}'>
					<view :style='{"margin":"0 12rpx","flex":"1","position":"relative"}' class="search-form round">
						<text class="icon iconfont icon-fangdajing07" :style='{"color":"#03b882","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
						<input :style='{"border":"0","padding":"12rpx 20rpx 12rpx 80rpx","color":"#333","borderRadius":"0px","background":"#ffffff","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.manhuamingcheng" type="text" placeholder="漫画名称" ></input>
					</view>
					<button :style='{"border":"0","padding":"0px","margin":"0","color":"#fff","borderRadius":"0px","background":"#03b882","width":"136rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
				</view>
			

				<view :style='{"padding":"0px","margin":"40rpx auto","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"center"}'>
					<view @click="sortClick('clicknum')" :style='{"border":"0","padding":"0 20rpx","margin":"0 20rpx 0 0","outline":"0","borderRadius":"40rpx","background":"#fff","display":"flex"}'>
						<text :style='{"color":"inherit","lineHeight":"60rpx","fontSize":"inherit"}'>点击量</text>
						<text v-if="listSort!='clicknum'" class="icon iconfont icon-liulan04" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
						<text v-else-if="listSort=='clicknum'&&listOrder=='asc'" class="icon iconfont icon-liulan04" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
						<text v-else-if="listSort=='clicknum'&&listOrder=='desc'" class="icon iconfont icon-liulan04" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
					</view>
					<view @click="sortClick('addtime')" :style='{"border":"0","padding":"0 20rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"40rpx","background":"#fff","display":"flex"}'>
						<text :style='{"color":"inherit","lineHeight":"60rpx","fontSize":"inherit"}'>按日期</text>
						<text v-if="listSort!='addtime'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
					</view>
				</view>
				<view :style='{"padding":"0","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"flex","width":"100%","height":"auto"}'>
					<scroll-view scroll-x="true" class="category-one" :style='{"minHeight":"100vh","margin":"0px 20rpx 0 -20rpx","borderRadius":"0px 0 0 0px","background":"#fff","display":"block","width":"200rpx","height":"100%"}'>
						<view :class='categoryName === item.manhualeixing ? "active" : ""' class="tab" v-for="(item,index) in categoryList" :key="index" @tap="categoryClick(item.manhualeixing)">{{item.manhualeixing}}</view>
					</scroll-view>
					<!-- 样式1 -->
					<view class="uni-product-list" :style='{"padding":"0","margin":"0","flexWrap":"wrap","flex":"1","display":"flex","width":"calc(100% - 220rpx)","justifyContent":"space-between","height":"auto"}'>
						<view @tap="onDetailTap(product)" class="uni-product" :style='{"padding":"20rpx 10rpx","margin":"0 0 40rpx","backgroundColor":"#fff","borderColor":"#1ccb96","borderRadius":"0","flexWrap":"wrap","borderWidth":"8rpx 0 0 0","display":"flex","width":"48%","borderStyle":"solid","height":"auto"}' v-for="(product,index) in list" :key="index">
							<view class="uni-product-title" :style='{"padding":"4rpx 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#03b882","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}'>{{product.manhuamingcheng}}</view>
							<view class="uni-product-title" :style='{"padding":"4rpx 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#03b882","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}'>{{product.manhualeixing}}</view>
							<image :style='{"padding":"0","margin":"0","objectFit":"cover","borderRadius":"0 0px 0 0","display":"block","width":"100%","height":"240rpx","order":"-1"}' mode="aspectFill" class="uni-product-image" v-if="preHttp(product.tupian)" :src="product.tupian.split(',')[0]"></image>
							<image :style='{"padding":"0","margin":"0","objectFit":"cover","borderRadius":"0 0px 0 0","display":"block","width":"100%","height":"240rpx","order":"-1"}' mode="aspectFill" class="uni-product-image" v-else :src="product.tupian?baseUrl+product.tupian.split(',')[0]:''"></image>

							<view :style='{"color":"#999","margin":"0 10rpx 0 0"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"color":"#3a7ebd","margin":"0 10rpx 0 0"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.zuojiazhanghao}}</text>
							</view>
							<view :style='{"color":"#bd873a","margin":"0 10rpx 0 0"}'>
								<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.thumbsupnum}}</text>
							</view>
							<view :style='{"color":"#3abd40","margin":"0 10rpx 0 0"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.storeupnum}}</text>
							</view>
							<view :style='{"color":"#3abdbb","margin":"0 10rpx 0 0"}'>
								<text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.clicknum}}</text>
							</view>
							<!-- #ifdef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 8rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('manhuaxiaoshuo','修改')) || (!userid && isAuthFront('manhuaxiaoshuo','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#03b882","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#03b882","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('manhuaxiaoshuo','删除')) || (!userid && isAuthFront('manhuaxiaoshuo','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#f00","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#f00","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
							<!-- #ifndef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 8rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('manhuaxiaoshuo','修改')) || (!userid && isAuthFront('manhuaxiaoshuo','修改'))" @tap.stop.proevent="onUpdateTap(product)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#03b882","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#03b882","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('manhuaxiaoshuo','删除')) || (!userid && isAuthFront('manhuaxiaoshuo','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#f00","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#f00","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
						</view>
					</view>
			
			
			


			
			
			
			
				</view>
				<button :style='{"border":"0","color":"#fff","right":"20rpx","outline":"none","borderRadius":"0","top":"20rpx","background":"#03b882","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' class="add-btn" @click="screenBoxShow=true">筛</button>
				<button :style='{"border":"0","color":"rgb(255, 255, 255)","bottom":"80rpx","right":"120rpx","outline":"none","borderRadius":"100%","background":"#EF7061","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('manhuaxiaoshuo','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","color":"rgb(255, 255, 255)","bottom":"80rpx","right":"120rpx","outline":"none","borderRadius":"100%","background":"#EF7061","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('manhuaxiaoshuo','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<view :style='{"top":"0","left":"0","background":"rgba(0, 0, 0, .3)","width":"100%","position":"absolute","height":"100%","zIndex":"665"}' v-if="screenBoxShow" @click="screenBoxShow=false"></view>
				<view class="screenBox" :class="screenBoxShow?'screenBoxActive':''">
					<view :style='{"width":"100%","padding":"20rpx 0 20rpx 0"}'>
						<view :style='{"width":"100%","padding":"0 0 20rpx 20rpx","fontSize":"24rpx"}'>漫画类型</view>
						<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-around","display":"flex"}'>
							<view @click="manhualeixingChange(item)" v-for="(item,index) in manhualeixingOptions" :key="index" class="screenTab" :class="searchForm.manhualeixing==item?'screenTabActive':''">{{item}}</view>
						</view>
					</view>
					<view :style='{"width":"100%","padding":"40rpx 0 0","alignItems":"center","justifyContent":"space-around","display":"flex"}'>
						<div :style='{"color":"#888","borderRadius":"8rpx","textAlign":"center","background":"#ededed","width":"30%","lineHeight":"68rpx","height":"68rpx"}' @click="screenReset">重置</div>
						<div :style='{"color":"#fff","borderRadius":"8rpx","textAlign":"center","background":"#03b882","width":"30%","lineHeight":"68rpx","height":"68rpx"}' @click="search">搜索</div>
					</view>
				</view>
			</view>
		</view>
	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				manhualeixingOptions:[],
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				clicknumColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{
					manhuamingcheng: '',
					manhualeixing: '',
				},
				categoryList:[],
				categoryName :'全部',
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
				screenBoxShow: false,
			};
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
		async onShow() {
            if(uni.getStorageSync("useridTag")==1){
                this.userid=uni.getStorageSync("useridTag");
                uni.removeStorageSync("useridTag");
            } else {
                this.userid = "";
            }
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.clicknumColor = this.clicknumColor.sort(()=> {
				return (0.5-Math.random());
			});
            let res = {};
            if(this.userid) {
                res = await this.$api.page('manhualeixing', {page:1,limit:100});
            } else {
                res = await this.$api.list('manhualeixing', {page:1,limit:100});
            }
			res.data.list.splice(0,0,{id:0,manhualeixing:'全部'})
			this.categoryList = res.data.list;
			this.hasNext = true
			// 重新加载数据
			// if (this.mescroll) this.mescroll.resetUpScroll()
		},
		async onLoad(options) {
            if(uni.getStorageSync("useridTag")==1){
                this.userid=uni.getStorageSync("useridTag");
                uni.removeStorageSync("useridTag");
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
			let res = {};
			//manhualeixing筛选
			res = await this.$api.option(`manhualeixing`,`manhualeixing`,{});
			this.manhualeixingOptions = res.data;
		},
		components: {
		},
		methods: {
			manhualeixingChange(e){
				this.searchForm.manhualeixing = e
				this.$forceUpdate()
			},
			screenReset(){
				this.searchForm = {}
				this.$forceUpdate()
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
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//类别搜索
			categoryClick(categoryName){
				this.categoryName = categoryName;
				this.mescroll.resetUpScroll();
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size,
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.categoryName!='全部'){
					params.manhualeixing = '%' + this.categoryName + '%'
				}
				if(this.searchForm.manhuamingcheng){
					params['manhuamingcheng'] = '%' + this.searchForm.manhuamingcheng + '%'
				}
				if(this.searchForm.manhualeixing){
					params['manhualeixing'] = '%' + this.searchForm.manhualeixing + '%'
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`manhuaxiaoshuo`, params);
                } else {
                    res = await this.$api.list(`manhuaxiaoshuo`, params);
                }

				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				this.$forceUpdate()
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			onUpdate(e){
				this.onUpdateTap(e.currentTarget.dataset.row)
			},
			// 修改
			onUpdateTap(row){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDelete(e){
				this.onDeleteTap(e.currentTarget.dataset.row.id)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('manhuaxiaoshuo', JSON.stringify([id]));
							let obj = await _this.$api.list('storeup',{
								page: 1,
								limit: 100,
								tablename: 'manhuaxiaoshuo',
								refid: id,
							})
							if(obj.data.list.length){
								let arr = []
								for(let x in obj.data.list){
									arr.push(obj.data.list[x].id)
								}
								await _this.$api.del('storeup',JSON.stringify(arr))
							}
							_this.$utils.msg('删除成功');
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size,
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.searchForm.manhuamingcheng){
					searchForm['manhuamingcheng'] = '%' + this.searchForm.manhuamingcheng + '%'
				}
				if(this.categoryName!='全部'){
					searchForm.manhualeixing = '%' + this.categoryName + '%'
				}
				if(this.searchForm.manhualeixing){
					searchForm['manhualeixing'] = '%' + this.searchForm.manhualeixing + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`manhuaxiaoshuo`, searchForm);
                } else {
                    res = await this.$api.list(`manhuaxiaoshuo`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
				this.screenBoxShow = false
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.category-one .tab {
		cursor: pointer;
		padding: 0 20rpx 0 32rpx;
		color: #333;
		background: #fff;
		display: inline-block;
		width: 100%;
		font-size: 30rpx;
		line-height: 80rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		padding: 0 20rpx 0 32rpx;
		color: #03b882;
		background: url(http://codegen.caihongy.cn/20241110/34939a3b37e84f58afefd5a614f48476.png) no-repeat 10rpx center / 12rpx,#f3f5f9;
		display: inline-block;
		width: 100%;
		font-size: 30rpx;
		line-height: 80rpx;
	}
	.screenBox {
		padding: 120rpx 0 20rpx 0;
		transform: translate3d(100%, 0, 0);
		z-index: 6666;
		top: 0;
		background: #fff;
		width: 80%;
		position: fixed;
		right: 0;
		transition: transform .3s;
		height: 100%;
		.screenTab {
			border-radius: 8rpx;
			margin: 10rpx 0 10rpx 0;
			background: #f3f5f9;
			width: calc(100% / 3 - 24rpx);
			line-height: 64rpx;
			text-align: center;
		}
		.screenTabActive {
			border-radius: 8rpx;
			margin: 10rpx 0 10rpx 0;
			color: #fff;
			background: #03b882;
			width: calc(100% / 3 - 20rpx);
			line-height: 64rpx;
			text-align: center;
		}
	}
	.screenBoxActive {
		transform: translate3d(0, 0, 0);
	}
</style>
