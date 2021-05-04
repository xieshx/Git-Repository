package com.neu.ms.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: ms
 * @description: 文件上传后返回结果
 * @author: xieshx
 * @create: 2021-04-25 20:40
 **/
@Getter
@Setter
public class MinioUploadDto {
    private String fileUrl;
    private String fileName;
}
