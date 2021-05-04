<template>
    <div>
        <el-dialog
                title="更改头像"
                :visible.sync="dialogVisible"
                width="30%"
                :before-close="handleCloseDialog">
            <el-upload
                    class="avatar-uploader"
                    action=""
                    ref="upload"
                    :show-file-list="false"
                    :before-upload="beforeAvatarUpload"
                    :on-change="changeAvatar"
                    :http-request="handleUploadAvatar"
                    :auto-upload="false">
                <img v-if="imageUrl" :src="imageUrl" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click=handleCloseDialog>取 消</el-button>
                    <el-button type="primary" @click="submitUpload">确 定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
    import {uploadAvatar} from '@/api/minio';

    export default {
        name: 'avatar',
        data() {
            return {
                dialogVisible: false,
                imageUrl: ''
            };
        },
        methods: {
            handleCloseDialog(done) {
                this.$confirm('确定关闭？').then(() => {
                    done();
                }).catch(() => {
                })
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
            },
            changeAvatar(file, fileList) {
                // elementUI中，自带的方法中的file，并不是指图片本身，而是他的一个dom。如果要是拿他的图片，就要用file.raw
                this.imageUrl = URL.createObjectURL(file.raw);
                // 控制列表中只有一张图片且是最新上传的那张
                if (fileList.length > 1) {
                    fileList.splice(0,1)
                }
            },
            submitUpload() {
                // 官方是通过submit方法 走action地址直接请求上传图片，在使用了http-request覆盖了默认的行为之后，
                // 也就是当你调用this->$refs->upload->submit()的时候，就会走http-request属性绑定的方法
                this.$refs.upload.submit();
                this.dialogVisible = false
            },
            handleUploadAvatar(params) {
                // 这里要用花括号括起来！！！
                const {file} = params;
                const fromData = new FormData();
                fromData.append('file', file);
                uploadAvatar(fromData).then(response=>{
                    this.$store.commit('SET_AVATAR',response.data.fileUrl);
                    location.reload();
                    console.log(this.$store.getters.avatarAddr)
                })
            }
        }
    };

</script>

<style>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }

    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>
