import axios from 'axios'
import {Message, MessageBox} from 'element-ui'
import store from "@/store";
import {getToken} from '@/utils/auth'

// 自定义创建的axios实例
const service = axios.create({
    baseURL: 'http://localhost:8088', // 向后端请求的地址
    // timeout: 15000 // 请求超时时间，开发时不要用
});

// 添加请求（request）拦截器
service.interceptors.request.use(
    config => {
        if (store.getters.token) {
            // 每次发送请求时，如有token，将token带在Authorization头后再发送请求，后端会根据这个token决定怎么处理这个请求
            config.headers['Authorization'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
        }
        return config
    },
    error => {
        // Do something with request error
        console.log(error);// for debug
        return Promise.reject(error)
    });

// 添加响应（response）拦截器
service.interceptors.response.use(
    response => {
        const res = response.data;

        // 后端给的响应码不是200，报错
        if (res.code !== 200) {
            Message({
                // message: res.message,
                message: res.message,
                type: 'error',
                duration: 3 * 1000
            });

            // 401:未登录;
            if (res.code === 401) {
                MessageBox.confirm('你已被登出，可以取消继续留在该页面，或者重新登录', '确定登出', {
                    confirmButtonText: '重新登录',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // 登出操作，清空cookie和store中的token
                    store.dispatch('FedLogOut').then(() => {
                        // 刷新当前页面，为了重新实例化vue-router对象 避免bug
                        location.reload()
                    })
                })
            }
            return Promise.reject('error')
        } else {
            return response.data
        }
    },
    error => {
        console.log(error);// for debug
        Message({
            message: error.message,
            type: 'error',
            duration: 3 * 1000
        });
        return Promise.reject(error)
    }
);

export default service
