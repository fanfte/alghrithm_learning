package com.fanfte.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by tianen on 2018/9/27
 *
 * @author fanfte
 * @date 2018/9/27
 **/
@Component("carFactoryBean")
public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        return new Car("BMW", "BMW");
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public static void main(String[] args) {

    }
}
