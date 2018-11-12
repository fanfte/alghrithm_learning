package com.fanfte.rpc.spring;

import lombok.Data;

/**
 * Created by tianen on 2018/11/8
 *
 * @author fanfte
 * @date 2018/11/8
 **/
@Data
public class User {

    String id;

    private String name;

    private String email;

    private int age;
}
