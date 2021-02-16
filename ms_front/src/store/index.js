/**
 * 我们组装模块并导出 store 的地方
 */

import Vue from 'vue'
//Vuex，它是专门为 Vue 开发的状态管理方案，我们可以把需要在各个组件中传递使用的变量、方法定义在这里
import Vuex from 'vuex'
import user from "@/store/modules/user";
import getters from "@/store/getters";

Vue.use(Vuex);

const store = new Vuex.Store({
    modules:{
        user
    },
    getters
});

export default store