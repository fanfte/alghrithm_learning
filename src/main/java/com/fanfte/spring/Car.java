package com.fanfte.spring;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tianen on 2018/9/27
 *
 * @author fanfte
 * @date 2018/9/27
 **/
@Data
@NoArgsConstructor
public class Car {

    private String name;

    private String brand;

    public Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }


}
