/**
 * Getters 我们可以理解为store仓库的一个计算属性
 * 比如把state状态的数据进行一次映射或者筛选，再把这个结果重新计算并提供给组件使用
 */
const getters = {
    token: state => state.user.token,
    avatarAddr: state => state.user.avatarAddr,
    name: state => state.user.name
};


// 此时，getters 会暴露出一个store.getters对象，
// 我们就可以在任何组件中使用this.$store.getters.xxx来绑定数据。
export default getters
