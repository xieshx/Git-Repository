module.exports = {
    devServer: {
        //vue项目端口号
        port: 8080,
        //反向代理端口地址及端口为 http://localhost:8088(springboot)
        proxy:'http://localhost:8088'
    }
}