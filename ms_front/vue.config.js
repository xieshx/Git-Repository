// 如果你的前端应用和后端 API 服务器没有运行在同一个主机上，
// 你需要在开发环境下将 API 请求代理到 API 服务器
// 现在前后端都在同一个主机，暂时用不着
// module.exports = {
//     devServer: {
//         //vue项目端口号
//         port: 8080,
//         //反向代理端口地址及端口为 http://localhost:8088(springboot)
//         proxy:'http://localhost:8088'
//     }
// };