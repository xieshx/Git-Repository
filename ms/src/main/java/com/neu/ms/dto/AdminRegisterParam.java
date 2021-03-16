package com.neu.ms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRegisterParam {
    private String username;
    private String firstPassword;
    private String secondPassword;
    private String nickname;
}
