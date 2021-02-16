<template>
    <!--VUE只允许有一个根元素，外部用一个div来包装-->
    <div>
        <el-card class="login-form-layout">
            <!--:rules="rules"为表单提供验证规则，status-icon校验结果反馈图标-->
            <!--也可以直接把校验规则写在元素标签里:rules="[{校验规则}]"-->
            <!--ref="loginForm"，之后就可以使用this.$refs访问到这个表单的子元素-->
            <!--TODO:(:inline="true")把表单域变成行，让账户和密码及其输入框并排（待确认，与官方文档有异）-->
            <el-form :inline="true" :model="loginForm" status-icon :rules="rules" ref="loginForm">
                <h2 class="login-title">系统登录</h2>
                <!--prop用于表示需要验证的字段-->
                <!--TODO:去掉Label，换成账号密码图标放在输入栏中-->
                <el-form-item label="账号：" prop="username">
                    <el-input placeholder="请输入账号" v-model="loginForm.username" clearable></el-input>
                </el-form-item>
                <el-form-item label="密码：" prop="password">
                    <el-input placeholder="请输入密码" v-model="loginForm.password" show-password></el-input>
                </el-form-item>
                <el-form-item>
                    <!--@click等价于v-on:click-->
                    <!--@click.native.prevent用于阻止默认事件-->
                    <!--:loading="loading"按钮加载效果-->
                    <el-button type="primary" :loading="loading" @click.native.prevent="login">登录</el-button>
                </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "login",
        //下面写法等同于data:function(){ return ...}
        data() {
            //自定义的校验规则
            //TODO:更多的账号密码校验规则
            const checkUsername = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('请输入用户名'))
                }
                //验证结束需要调用callback，否则表单会一直处于校验状态，无法提交
                callback();
            };
            const checkPassword = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('请输入密码'))
                }
                callback();
            };

            return {
                //按钮加载状态
                loading: false,
                //表单数据
                loginForm: {
                    username: '',
                    password: ''
                },
                //Form 组件提供了表单验证的功能，只需要通过 rules 属性传入约定的验证规则，并将 Form-Item 的 prop 属性设置为需校验的字段名即可
                rules: {
                    username: [
                        //trigger:触发验证的时机
                        //blur:输入框失去焦点时
                        //change:数据改变时
                        {validator: checkUsername, trigger: 'change'},
                        {min: 3, max: 10, message: '用户名长度在 3 到 10 个字符', trigger: 'change'}
                    ],
                    password: [
                        {validator: checkPassword, trigger: 'change'},
                        {min: 3, max: 18, message: '密码长度在 3 到 18 个字符', trigger: 'change'}
                    ]
                }
            }
        },

        //注意是methods而不是method
        methods: {
            login() {

                //也可以用this.$refs['loginForm']
                this.$refs.loginForm.validate(

                    // 箭头函数
                    // 1、()=>{}，里面必须加return语句才能返回值
                    // 2、()=>()，将括号内的结果直接返回，不用写return
                    // 3、()=>  ，没有括号的情况与2一致
                    (valid) => {
                        if (valid) {
                            // 箭头函数中是没有this的，这个this是继承而来的
                            this.loading = true;
                            // dispatch(方法名，参数)
                            // store.dispatch可以处理被触发的action的处理函数返回的Promise，并且store.dispatch仍旧返回 Promise
                            // .then()就是当前面的方法执行完后再执行then()内部的程序，这样就避免了，数据没获取到等的问题
                            this.$store.dispatch('Login', this.loginForm).then(() => {
                                this.loading = false;
                                // setCookie("username",this.loginForm.username,15);
                                // setCookie("password",this.loginForm.password,15);
                                this.$router.push({path: '/home'})
                            }).catch(() => {
                                this.loading = false;
                                this.$refs.loginForm.resetFields();
                            })
                        } else {
                            console.log('参数验证不合法！');
                            // TODO:return false这有啥用
                            return false;
                        }
                    }
                )
            }
        }
    }
</script>

<style scoped>
    .login-form-layout {
        position: absolute;
        left: 0;
        right: 0;
        width: 360px;
        margin: 150px auto;
        border-radius: 15px;
        box-shadow: 0 0 25px #cac6c6;
    }
</style>