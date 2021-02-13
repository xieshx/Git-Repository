<template>
    <div>
        <el-container>
            <el-header>
                <!--Row默认一列24，提供gutter属性来指定每一栏之间的间隔，默认间隔为0-->
                <el-row :gutter="10">
                    <!--:offset偏移-->
                    <el-col :span="8" :offset="8">
                        <el-dropdown trigger="click">
                            <span class="el-dropdown-link">
                                下拉菜单
                                <i class="el-icon-arrow-down"></i>
                            </span>
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item icon="el-icon-plus">黄金糕</el-dropdown-item>
                                <el-dropdown-item icon="el-icon-circle-plus">狮子头</el-dropdown-item>
                                <el-dropdown-item icon="el-icon-circle-plus-outline">螺蛳粉</el-dropdown-item>
                                <el-dropdown-item icon="el-icon-check">双皮奶</el-dropdown-item>
                                <el-dropdown-item icon="el-icon-circle-check">蚵仔煎</el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                    </el-col>
                    <el-col :span="8" >
                        <i class="el-icon-switch-button">注销</i>
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
    export default {
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
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