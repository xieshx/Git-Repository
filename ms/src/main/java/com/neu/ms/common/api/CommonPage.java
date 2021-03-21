package com.neu.ms.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CommonPage<T> {
    private long total;
    private List<T> list;
}