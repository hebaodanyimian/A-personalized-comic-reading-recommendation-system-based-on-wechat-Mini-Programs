import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import news from '@/views/modules/news/list'
	import aboutus from '@/views/modules/aboutus/list'
	import manhualeixing from '@/views/modules/manhualeixing/list'
	import manhuaxiaoshuo from '@/views/modules/manhuaxiaoshuo/list'
	import storeup from '@/views/modules/storeup/list'
	import chaptermanhuaxiaoshuo from '@/views/modules/chaptermanhuaxiaoshuo/list'
	import systemintro from '@/views/modules/systemintro/list'
	import yonghu from '@/views/modules/yonghu/list'
	import zuojia from '@/views/modules/zuojia/list'
	import discussmanhuazuopin from '@/views/modules/discussmanhuazuopin/list'
	import discussmanhuaxiaoshuo from '@/views/modules/discussmanhuaxiaoshuo/list'
	import manhuazuopin from '@/views/modules/manhuazuopin/list'
	import config from '@/views/modules/config/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/news',
		name: '漫画资讯',
		component: news
	}
	,{
		path: '/aboutus',
		name: '关于我们',
		component: aboutus
	}
	,{
		path: '/manhualeixing',
		name: '漫画类型',
		component: manhualeixing
	}
	,{
		path: '/manhuaxiaoshuo',
		name: '漫画小说',
		component: manhuaxiaoshuo
	}
	,{
		path: '/storeup',
		name: '我的收藏',
		component: storeup
	}
	,{
		path: '/chaptermanhuaxiaoshuo',
		name: '漫画小说章节',
		component: chaptermanhuaxiaoshuo
	}
	,{
		path: '/systemintro',
		name: '系统简介',
		component: systemintro
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/zuojia',
		name: '作家',
		component: zuojia
	}
	,{
		path: '/discussmanhuazuopin',
		name: '漫画作品评论',
		component: discussmanhuazuopin
	}
	,{
		path: '/discussmanhuaxiaoshuo',
		name: '漫画小说评论',
		component: discussmanhuaxiaoshuo
	}
	,{
		path: '/manhuazuopin',
		name: '漫画作品',
		component: manhuazuopin
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/newstype',
		name: '漫画资讯分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
