<template>
    <div>
        <el-dialog
                title="更改头像"
                :visible.sync="dialogVisible"
                width="30%"
                :before-close="handleClose">
            <el-avatar :size="100" src="https://empty" @error="errorHandler">
                <el-image class="el-icon-picture-outline"></el-image>
            </el-avatar>
            <el-upload
                    class="avatar-uploader"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload">
                <img v-if="imageUrl" :src="imageUrl" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click=handleClose>取 消</el-button>
                    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name:'avatar',
        data() {
            return {
                dialogVisible: false,
                imageUrl: ''
            };
        },
        methods: {
            handleClose(done) {
                this.$confirm('确定关闭？').then(()=>{
                    done();
                }).catch(()=>{})
            },
            errorHandler() {
                return true
            },
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            }
        }
    };
</script>

<style>

</style>
