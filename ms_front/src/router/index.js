import Vue from "vue"
import VueRouter from "vue-router"//引入 Vue 路由

Vue.use(VueRouter)//安装VueRouter插件

const constantRouterMap = [
    {path: '/', component: () => import('@/views/login')},
    {path: '/success', component: () => import('@/views/success')},
    {path: '/error', component: () => import('@/views/error')}
]

//1.URL上的#号的特性（即改变 URL 却不请求后端），就可以在前端实现页面的整体变化，而不用每次都去请求后端，
//这种模式被称为hash模式
//2.另一种常用的模式是history模式，这种模式的原理是先把页面的状态保存到一个对象（state）里
//当页面的 URL 变化时找到对应的对象，从而还原这个页面，使用了这种模式，就可以摆脱#号实现前端路由。
export default new VueRouter({
    //把 Vue 中配置的路由从默认的 hash 模式切换为 history 模式
    mode: 'history',
    routes: constantRouterMap
});

//路由也可以这样写，需要在头部导入组件
// routes: [{path: '/login',name: 'Login',component: Login}]