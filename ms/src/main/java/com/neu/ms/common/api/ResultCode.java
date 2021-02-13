package com.neu.ms.common.api;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    // 枚举成员变量
    private long code;
    private String message;

    // 构造器默认private，目的是不允许new，枚举类型是单例模式，只需要实例化一次即可
    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

}
