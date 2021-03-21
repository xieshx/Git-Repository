package com.neu.ms.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageInfo<T> {
    private long total;
    private List<T> data;
}
