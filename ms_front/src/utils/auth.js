/**
 * js-cookie是一个简单的，轻量级的处理cookies的js API。
 */
import Cookies from 'js-cookie'

const TokenKey = 'loginToken';

// Cookies.set()默认有效期是关闭浏览器，这里设置为7天，重新打开浏览器后仍然可以自动登录
export function setToken(token) {
    return Cookies.set(TokenKey, token, {expires: 7})
}

export function getToken() {
    return Cookies.get(TokenKey)
}

export function removeToken() {
    return Cookies.remove(TokenKey)
}