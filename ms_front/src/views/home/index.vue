<template>
    <div>
        <el-container>
            <el-header>
                <!--Row默认一列24，提供gutter属性来指定每一栏之间的间隔，默认间隔为0-->
                <el-row :gutter="10">
                    <!--:offset偏移-->
                    <el-col :span="4" :offset="20" >
                        <el-dropdown trigger="click">
                            <span class="el-dropdown-link">
                                {{username}}
                                <i class="el-icon-arrow-down"></i>
                            </span>
                            <template #dropdown>
                            <el-dropdown-menu slot="dropdown">
                                <!--给Vue组件绑定事件,需要在事件后面加上.native,有些组件(el-button..),不用加native是因为底层源码已经实现了native-->
                                <el-dropdown-item icon="el-icon-switch-button" @click.native="logout">退出</el-dropdown-item>
                            </el-dropdown-menu>
                            </template>
                        </el-dropdown>
                    </el-col>
                </el-row>
            </el-header>
            <el-container>
                <el-aside width="200px">
                    <h5>默认颜色</h5>
                    <el-menu
                            default-active="2"
                            class="el-menu-vertical-demo"
                            @open="handleOpen"
                            @close="handleClose">
                        <el-submenu index="1">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>导航一</span>
                            </template>
                            <el-menu-item-group>
                                <template slot="title">分组一</template>
                                <el-menu-item index="1-1">选项1</el-menu-item>
                                <el-menu-item index="1-2">选项2</el-menu-item>
                            </el-menu-item-group>
                            <el-menu-item-group title="分组2">
                                <el-menu-item index="1-3">选项3</el-menu-item>
                            </el-menu-item-group>
                            <el-submenu index="1-4">
                                <template slot="title">选项4</template>
                                <el-menu-item index="1-4-1">选项1</el-menu-item>
                            </el-submenu>
                        </el-submenu>
                        <el-menu-item index="2">
                            <i class="el-icon-menu"></i>
                            <span slot="title">导航二</span>
                        </el-menu-item>
                        <el-menu-item index="3" disabled>
                            <i class="el-icon-document"></i>
                            <span slot="title">导航三</span>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <i class="el-icon-setting"></i>
                            <span slot="title">导航四</span>
                        </el-menu-item>
                    </el-menu>
                </el-aside>
                <el-main>Main</el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>

    import {getCookie} from "@/utils/support";

    export default {

        name: 'home',

        data() {
            // 不使用return包裹的数据会在项目的全局可见，会造成变量污染；使用return包裹后数据中变量只在当前组件中生效，不会影响其他组件
            return {
                // TODO:cookie删除后就不会显示了，有没有更好的办法?
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

    .el-dropdown-link,
    .el-icon-switch-button {
        cursor: pointer;
        color: #dcd9dd;
        font-size: 15px;
    }

    .el-header {
        background-color: #24262f;
        line-height: 60px;
    }

    .el-main {
        background-color: #E9EEF3;
        line-height: 160px;
    }

</style>