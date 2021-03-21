import request from '@/utils/request'

export function login(username, password) {
    return request({
        url: '/admin/login',
        method: 'post',
        data: {
            username,
            password
        }
    })
}

export function logout() {
    return request({
        url: '/admin/logout',
        method: 'post'
    })
}

export function createAdmin(data) {
    return request({
        url: '/admin/register',
        method: 'post',
        data: data
    })
}

export function getAdminList() {
    return request({
        url: '/admin/list',
        method: 'get',
    })
}