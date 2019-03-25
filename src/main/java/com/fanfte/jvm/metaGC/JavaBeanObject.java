package com.fanfte.jvm.metaGC;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * Created by tianen on 2019/1/3
 *
 * @author fanfte
 * @date 2019/1/3
 **/
public class JavaBeanObject {

    private String name = "java";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws CannotCompileException, IllegalAccessException, InstantiationException, NotFoundException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            CtClass ctClass = ClassPool.getDefault().makeClass("Geym" + i);
            ctClass.setSuperclass(ClassPool.getDefault().get("jcom.fanfte.jvm.metaGC.JavaBeanObject"));
            Class<?> clzz = ctClass.toClass();
            JavaBeanObject javaBeanObject = (JavaBeanObject) clzz.newInstance();
        }
    }
}
