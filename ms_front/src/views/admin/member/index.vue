<template>
    <div>
        <el-table :data="tableData" stripe>
            <el-table-column
                    prop="createTime"
                    label="日期">
            </el-table-column>
            <el-table-column
                    prop="username"
                    label="姓名">
            </el-table-column>
            <el-table-column
                    prop="status"
                    label="状态">
            </el-table-column>
        </el-table>
        <div class="block">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :page-size=pageSize
                    :total=total
                    layout="total, prev, pager, next">
            </el-pagination>
        </div>
    </div>

</template>

<script>
    import {getAdminList} from '@/api/admin';

    export default {
        data() {
            return {
                pageSize: 5,
                currentPage: 1,
                total: 100,
                tableData: null
            }
        },
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
                getAdminList().then(response=>{
                    console.log(response);
                    this.tableData=response.data.list;
                });
            }
        }
    }
</script>

<style scoped>

</style>