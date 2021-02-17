import Vue from 'vue'
import App from '@/App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from "@/store"
import router from '@/router'
import "@/router/permission" //对组件自定义一些方法后，要在main.js中导入

// 在vue导入文件时，import router from '@/router'等效于
// import router from './router/index.js'，
// 这个不是vue的规定而是node加载模块的方式，node是这样的寻找目标的:
// 1.首先寻找目录下有没有router.js或者router.node,如果有就导入
// 2.如果没有看是否有router目录,如果没有就require失败,抛出异常"Cannot find module ‘./router’"
// 3.如果有router目录会在其下寻找package.json文件,如果有则按照package的配置来导入
// 4.如果没有package.json,看是否有index.js或者index.node,如果有就导入没有就失败

Vue.config.productionTip = false;// 关闭生产环境提示
Vue.use(ElementUI);// 全局使用ElementUI插件

new Vue({
    // 原型如下（createElement=h）
    // render:function(createElement){
    //     return creatElemnt(App);
    // }
    render: h => h(App),
    // 使用路由配置
    router,
    // 自定义的store组件
    store
}).$mount('#app');