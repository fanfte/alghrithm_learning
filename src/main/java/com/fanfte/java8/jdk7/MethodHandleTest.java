package com.fanfte.java8.jdk7;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by tianen on 2018/11/6
 *
 * @author fanfte
 * @date 2018/11/6
 **/
public class MethodHandleTest {

    static class ClassA {
        public void println(String s) {
            System.out.println("Hi " + s + ",I`m Class A");
        }
    }

    static class ClassB {
        public void println(String s) {
            System.out.println("Hi " + s + ",I`m Class B");
        }
    }

    private static MethodHandle getPrintlnMH(Object obj) throws NoSuchMethodException, IllegalAccessException {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(obj.getClass(), "println", methodType).bindTo(obj);
    }

    public static void main(String[] args) throws Throwable {
        getPrintlnMH(new ClassA()).invokeExact("MethodHandle");
    }
}
