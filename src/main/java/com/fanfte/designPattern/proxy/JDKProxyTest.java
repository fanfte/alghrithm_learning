package com.fanfte.designPattern.proxy;

import sun.misc.ProxyGenerator;

import javax.security.auth.Subject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Created by dell on 2018/7/19
 **/
public class JDKProxyTest {

    public static void main(String[] args) {
        //参数为调用类，接口类，handler
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(),
                                new Class[]{HelloWorld.class},
                                new MyInvocationHandler(new HelloWorldImpl()));
        proxy.sayHello("James");

        System.out.println("动态代理对象的类型" + proxy.getClass().getName());
        createProxyClassFile();
    }

    private static void createProxyClassFile(){
        String name = "HelloWorldProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name,new Class[]{HelloWorld.class});
        FileOutputStream out =null;
        try {
            out = new FileOutputStream(name+".class");
            System.out.println((new File("hello")).getAbsolutePath());
            out.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if(null!=out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
