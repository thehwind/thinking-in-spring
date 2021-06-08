package org.geekbang.thinking.in.spring.ioc.dependency.injection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 利用反射获取Map属性的每个反射字段值
 */
public class PrintMapGenericType {
    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = PrintMapGenericType.class.getDeclaredField("map");
        System.out.println(field.getGenericType());

        Type genericType = field.getGenericType();
        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        // 获取基本类型信息，即Map
        Type basicType = parameterizedType.getRawType();
        System.out.println("基本类型为：" + basicType);
        // 获取泛型类型的泛型参数
        Type[] types = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < types.length; i++) {
            System.out.println("第" + (i + 1) + "个泛型类型是：" + types[i]);
        }

    }
}
