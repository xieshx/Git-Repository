import Vue from "vue"
import VueRouter from "vue-router"//引入 Vue 路由

Vue.use(VueRouter)//安装VueRouter插件

const constantRouterMap=[
    {path:'/',component:()=>import('@/views/login')}
]

export default new VueRouter({
    routes:constantRouterMap
})