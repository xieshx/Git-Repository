package com.neu.ms.common.api;

import lombok.Getter;

/**
 * 设置通用返回对象
 */

//一定要给属性添加get方法，不然spring读取不到属性，就没办法把封装的结果转换为json
@Getter
public class CommonResult<T> {


    // 状态码
    private long code;
    // 提示信息
    private String message;
    // 数据封装
    private T data;


    // 构造方法仅包内和子类可用
    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    // 成功：返回成功码+通用成功信息+封装成功数据
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }


    // 成功：返回成功码+自定义成功信息+封装成功数据
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }


    // 失败：返回错误码+自定义错误信息+无返回数据
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }


    // 验证失败：返回错误码+自定义错误信息+无返回数据
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }


    // 无权访问：返回错误码+通用无权访问信息+封装无权访问数据
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }


    // 禁止访问：返回错误码+通用禁止信息+封装禁止访问数据
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }


}
