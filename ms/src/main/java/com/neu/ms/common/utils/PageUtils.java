package com.neu.ms.common.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class PageUtils {
    /**
     * 将PageInfo对象泛型中的Po对象转化为Vo对象
     *
     * @param pageInfoPo PageInfo<Po>对象</>
     * @param <P>        Po类型
     * @param <V>        Vo类型
     * @return
     */
    public static <P, V> PageInfo<V> PageInfo2PageInfoVo(PageInfo<P> pageInfoPo, Class<V> vClass) {
        // 创建Page对象，实际上是一个ArrayList类型的集合
        Page<V> page = new Page<>(pageInfoPo.getPageNum(), pageInfoPo.getPageSize());
        page.setTotal(pageInfoPo.getTotal());
        for (P p : pageInfoPo.getList()) {
            V v = null;
            try {
                // Java9之后newInstance()已过时，推荐下面这个方法
                v = vClass.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(p, v);
                page.add(v);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return new PageInfo<>(page);
    }
}

