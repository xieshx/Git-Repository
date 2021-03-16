<template>
    <div>
        <el-card class="register-form-layout">
            <el-form :inline="true" :model="registerForm" status-icon :rules="rules" ref="registerForm">
                <h2 class="login-title">用户注册</h2>
                <!--TODO:去掉Label，换成账号密码图标放在输入栏中-->
                <el-form-item  prop="username">
                    <el-input placeholder="请输入账号" v-model="registerForm.username" clearable></el-input>
                </el-form-item>
                <el-form-item prop="nickname">
                    <el-input placeholder="请输入昵称" v-model="registerForm.nickname" clearable></el-input>
                </el-form-item>
                <el-form-item  prop="firstPassword">
                    <el-input placeholder="请输入密码"  v-model="registerForm.firstPassword" show-password></el-input>
                </el-form-item>
                <el-form-item  prop="secondPassword">
                    <el-input placeholder="请再次输入密码" v-model="registerForm.secondPassword" show-password></el-input>
                </el-form-item>
                <div>
                    <el-form-item>
                        <el-button type="primary" :loading="loading" @click.prevent="register">注册</el-button>
                    </el-form-item>
                </div>
            </el-form>
        </el-card>
    </div>
</template>

<script>
    import {createAdmin} from '@/api/login';

    export default {
        name: "register",
        data(){

            const checkPassword=(rule, value, callback)=>{
                if (value!== this.registerForm.firstPassword) {
                    return callback(new Error('两次输入的账号密码不一致'))
                }
                callback();
            };

            return{
                loading: false,
                registerForm:{
                    username:'',
                    firstPassword:'',
                    secondPassword:'',
                    nickname:''
                },
                rules:{
                    username:[
                        {trigger: 'blur',message: '请输入用户名',required: true}
                    ],
                    firstPassword:[
                        {trigger: 'blur',message: '请输入密码',required: true}
                    ],
                    nickname:[
                        {trigger: 'blur',message: '请输入昵称',required: true}
                    ],
                    secondPassword:[
                        {validator: checkPassword, trigger: 'blur'},
                        {trigger: 'blur',message: '请再次输入密码',required: true}
                    ]
                }
            }
        },
        methods:{
            register(){
                this.$refs.registerForm.validate(
                    (valid)=>{
                        if (valid){
                            this.loading = true;
                            createAdmin(this.registerForm);
                            this.loading = false;
                        }else {
                            console.log('参数验证不合法！');
                            return false;
                        }
                    }
                )
            }
        }
    }
</script>

<style scoped>
    .register-form-layout {
        position: absolute;
        left: 0;
        right: 0;
        width: 360px;
        margin: 150px auto;
        border-radius: 15px;
        box-shadow: 0 0 25px #cac6c6;
    }
</style>