package com.fanfte.java8.jdk7;


/**
 * Created by tianen on 2018/11/6
 *
 * @author fanfte
 * @date 2018/11/6
 **/
public class DelegateService {

    public String name;

    public DelegateService(String name) {
        this.name = name;
    }

    public void say() {
        String desc = "DelegateService#say";
        SampleService sampleService = () -> name + ":" + desc;
        System.out.println(sampleService.say());
    }

    public interface SampleService {
        public String say();
    }
}
