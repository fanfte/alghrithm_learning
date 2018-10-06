package com.fanfte.spring;

import lombok.Data;

/**
 * Created by tianen on 2018/9/27
 *
 * @author fanfte
 * @date 2018/9/27
 **/
@Data
public class Car {

    private String name;

    private String brand;

    public Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }
}
