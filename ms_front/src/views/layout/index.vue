<template>
    <el-container>
        <el-aside width="200px">
            <el-menu router
                     @open="handleOpen"
                     @close="handleClose"
                     background-color="#304156"
                     text-color="#bfcbd9"
                     active-text-color="#409eff">
                <el-menu-item index="/home">
                    <i class="el-icon-s-home"></i>
                    <template #title>首页</template>
                </el-menu-item>
                <el-menu-item index="/goods">
                    <i class="el-icon-shopping-cart-2"></i>
                    <template #title>商品列表</template>
                </el-menu-item>
                <!--el-submenu的index不写报错-->
                <el-submenu index="">
                    <template #title>
                        <i class="el-icon-s-custom"></i>
                        <span>管理员</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="/admin/member">用户列表</el-menu-item>
                        <el-menu-item index="/admin/role">角色列表</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
            </el-menu>
        </el-aside>
        <el-container>
            <el-header height="40px">
                <!--el-row的高度是被子元素撑起来的（auto），需要设置占据el-header100%高度才能用align="middle"看出垂直居中的效果-->
                <el-row type="flex" justify="space-between" align="middle">
                    <el-col>
                        <el-breadcrumb separator-class="el-icon-arrow-right">
                            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                            <el-breadcrumb-item>活动管理</el-breadcrumb-item>
                            <el-breadcrumb-item>活动列表</el-breadcrumb-item>
                            <el-breadcrumb-item>活动详情</el-breadcrumb-item>
                        </el-breadcrumb>
                    </el-col>
                    <el-col :span="4">
                        <el-dropdown trigger="click">
                            <span class="el-dropdown-link">
                                {{username}}
                                <i class="el-icon-arrow-down"></i>
                            </span>
                            <template #dropdown>
                                <el-dropdown-menu slot="dropdown">
                                    <!--给Vue组件绑定事件,需要在事件后面加上.native,有些组件(el-button..),不用加native是因为底层源码已经实现了native-->
                                    <el-dropdown-item icon="el-icon-switch-button" @click.native="logout">退出
                                    </el-dropdown-item>
                                </el-dropdown-menu>
                            </template>
                        </el-dropdown>
                    </el-col>
                </el-row>
            </el-header>
            <el-divider></el-divider>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    import {getCookie} from "@/utils/support";

    export default {
        name: "layout",
        data() {
            return {
                isCollapse: false,
                username: getCookie('username')
            }
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            logout() {
                this.$store.dispatch('LogOut').then(() => {
                    // js刷新，相当于在浏览器上按下刷新按钮
                    location.reload()
                })
            }
        }
    }
</script>

<style scoped>
    .el-divider {
        margin-top: 1px;
        margin-bottom: 1px;
    }

    .el-dropdown-link,
    .el-icon-switch-button {
        cursor: pointer;
        font-size: 15px;
    }

    .el-aside {
        background-color: #304156;
        height: 100vh;
    }

    .el-row {
        height: 100%;
    }
</style>