package com.fanfte.reflect;

import java.lang.reflect.Field;

public class TestReflect {

    private static final String urlPattern = "http://www.baidu.com?";

    public static String reflect(Object o){
        StringBuffer sb = new StringBuffer(urlPattern);
        //获取参数类
        Class cls = o.getClass();
        //将参数类转换为对应属性数量的Field类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
        Field[] fields = cls.getDeclaredFields();
        for(int i = 0;i < fields.length; i ++){
            Field f = fields[i];
            f.setAccessible(true);
            try {
                //f.getName()得到对应字段的属性名，f.get(o)得到对应字段属性值,f.getGenericType()得到对应字段的类型
                System.out.println("属性名："+f.getName()+"；属性值："+f.get(o)+";字段类型：" + f.getGenericType());
                if(i != fields.length - 1) {
                    sb.append(f.getName()).append("=").append(f.get(o)).append("&");
                }else {
                    sb.append(f.getName()).append("=").append(f.get(o));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("张三");
        s.setAge(12);
        String url = reflect(s);
        System.out.println("url " + url);
    }
}
