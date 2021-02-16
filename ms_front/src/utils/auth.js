/**
 * js-cookie是一个简单的，轻量级的处理cookies的js API。
 */
import Cookies from 'js-cookie'

const TokenKey = 'loginToken';

export function setToken(token) {
    return Cookies.set(TokenKey, token)
}

export function getToken() {
    return Cookies.get(TokenKey)
}