package com.neu.ms.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author 875600608
 */
@Getter
@Setter
public class AdminVo {
    private String nickName;
    private String username;
    private Date createTime;
    private Date endTime;
    private Boolean status;
    private String avatarAddress;
}
