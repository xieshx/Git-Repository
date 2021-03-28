import request from '@/utils/request'

export function uploadAvatar(formData) {
    return request({
        url: '/minio/upload',
        method: 'post',
        contentType: 'multipart/form-data',
        data: formData
    })
}