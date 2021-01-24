import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'
import axios from "axios";

Vue.config.productionTip = false//关闭生产环境提示
Vue.use(ElementUI)//全局使用ElementUI插件
Vue.prototype.$axios=axios// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
// 前端请求默认发送到 http://localhost:8088(vue)
axios.defaults.baseURL = 'http://localhost:8088'

new Vue({
    //原型如下（createElement=h）
    //render:function(createElement){
    //     return creatElemnt(App);
    // }
    render: h => h(App),
    //使用路由配置
    router
}).$mount('#app')
