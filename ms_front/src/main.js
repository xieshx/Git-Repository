import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'

Vue.config.productionTip = false//关闭生产环境提示
Vue.use(ElementUI);//全局使用ElementUI插件

new Vue({
    //原型如下（createElement=h）
    //render:function(createElement){
    //     return creatElemnt(App);
    // }
    render: h => h(App),
    //使用路由配置
    router
}).$mount('#app')
