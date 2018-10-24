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

    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand(carInfo.split(",")[0]);
        car.setName(carInfo.split(",")[1]);
        return car;
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
