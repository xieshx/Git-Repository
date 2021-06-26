// 这个拦截器只是简单的前端路由控制，如果token失效了，但是token仍然保留在本地，
// 访问页面之前都需要先重新登录，换一个新的token，
// 这时候就需要统一处理http的请求和响应，必须用上axios的拦截器
import router from '@/router/index'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css' // Progress 进度条样式
import {getToken} from "@/utils/auth";
// import store from '@/store'

// 白名单，随意访问
const whiteList = ['/login', '/error', '/register'];

// next():一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数。
// 1.next()进入路由 2.取消进入该路由，返回from 3.next(path:'')进入新路由
router.beforeEach((to, from, next) => {
    NProgress.start();
    // 若token已存在且未过期（用户已经登录了）
    if (getToken()) {
        // TODO：token存在需要去后端判断是否过期
        // 访问登录页面会直接跳转到主页
        if (to.path === '/login') {
            next({path: '/home'});
        } else {
            // 直接放行
            // 拉取当前用户的登录信息
            // store.dispatch('GetInfo').then();
            next();
        }
    } else {
        // token不存在（用户未登录）
        // 如果你要访问的路由在白名单中，就可以路由过去，否则路由到登录界面
        if (whiteList.indexOf(to.path) !== -1) { // indexOf：返回指定字符串首次出现的位置，若没有找到，返回-1
            next()
        } else {
            next('/login');
        }
    }
});

router.afterEach(() => {
    NProgress.done() // 结束Progress
});
