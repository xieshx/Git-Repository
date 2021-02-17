import {login, logout} from "@/api/login";
import {getToken, removeToken, setToken} from '@/utils/auth';

const user = {

    state: {
        token: getToken(),
    },

    // 更改 Vuex 的 store 中的状态的唯一方法是提交 mutation。
    mutations: {

        // 这个回调函数就是我们实际进行状态更改的地方，并且它会接受state作为第一个参数，额外的参数即mutation的载荷（payload）
        SET_TOKEN: (state, token) => {
            state.token = token
        }

    },

    actions: {
        Login({commit}, userInfo) {
            // trim():去除字符串的头尾空格
            const username = userInfo.username.trim();
            // Promise构造接收的参数是一个函数，这个函数有两个参数resolve和reject
            // 分别代表了异步执行成功与失败的回调函数
            return new Promise((resolve, reject) => {
                // login函数返回的也是一个Promise对象，axios是一个基于promise的 HTTP库
                login(username, userInfo.password).then(response => {
                    const data = response.data;
                    const tokenStr = data.tokenHead + data.token;
                    // 将token存储到cookie中
                    setToken(tokenStr);
                    // 并且将token更新到store中
                    commit('SET_TOKEN', tokenStr);
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })
        },

        LogOut({commit, state}) {
            return new Promise((resolve, reject) => {
                logout(state.token).then(() => {
                    commit('SET_TOKEN', '');
                    // TODO:权限清空
                    removeToken();
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })
        }

    }
};


export default user