package com.fanfte.designPattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by dell on 2018/7/19
 **/
public class Helper implements MethodInterceptor{

    public Object getInstance(Class clazz) throws Exception {
        Enhancer enhancer = new Enhancer();
        // 告诉cglib生成的子类需要继承哪个类
        enhancer.setSuperclass(clazz);
        // 设置回调，需要调用本类的intercept方法
        enhancer.setCallback(this);
        // 第一步，生成源代码
        // 第二步，编译源代码文件
        // 第三步，加载到JVM中，并返回被代理对象
        return enhancer.create();
    }

    /**
     * 字节码重组，自动生成一个子类继承自
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("I am proxy");
        System.out.println("--------------");
        // o的这个引用是CGLib帮我们new出来的
        // cgLib new 出来的，其实是被代理对象的子类（继承了Student类）
        // OOP new子类之前，默认需要先调用super()构造方法,
        // new了子类的同时也必须先new出来父类，相当于是间接持有了父类的引用
        // 子类重写了父类的所有方法，改变子类对象的某些属性是可以间接地操作父类属性的
        methodProxy.invokeSuper(o, objects);
        System.out.println("-------------");
        System.out.println("After work");
        return null;
    }
}
