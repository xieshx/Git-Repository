package com.neu.ms.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 875600608
 */
@Getter
@Setter
public class AdminRegisterParam {
    private String username;
    private String firstPassword;
    private String secondPassword;
    private String nickname;
}
