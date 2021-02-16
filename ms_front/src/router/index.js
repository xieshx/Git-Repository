import Vue from "vue"
import VueRouter from "vue-router"//引入 Vue 路由

Vue.use(VueRouter);//安装VueRouter插件

const constantRouterMap = [
    {path: '/', component: () => import('@/views/login/index')},
    {path: '/success', component: () => import('@/views/success')},
    {path: '/error', component: () => import('@/views/error')},
    {path:'/home',component: ()=>import('@/views/home/index')}
];

// 1.URL上的#号的特性（即改变 URL 却不请求后端），就可以在前端实现页面的整体变化，而不用每次都去请求后端，
// 这种模式被称为hash模式
// 2.另一种常用的模式是history模式，这种模式的原理是先把页面的状态保存到一个对象（state）里
// 当页面的 URL 变化时找到对应的对象，从而还原这个页面，使用了这种模式，就可以摆脱#号实现前端路由。
const router=new VueRouter({
    //把 Vue 中配置的路由从默认的 hash 模式切换为 history 模式
    mode: 'history',
    routes: constantRouterMap
});

// 这个拦截器只是简单的前端路由控制，如果token失效了，但是token仍然保留在本地，
// 访问页面之前都需要先重新登录，换一个新的token，
// 这时候就需要统一处理http的请求和响应，必须用上axios的拦截器
// 这里要将router new出来以后才能使用beforeEach
// 直接构造VueRouter并导出（export default new VueRouter）是没办法给组件直接使用beforeEach的
router.beforeEach((to, from, next) => {
    // TODO: 等待token存入store中，再设计路由拦截
    console.log("拦截一下");
    next();
});


export default router