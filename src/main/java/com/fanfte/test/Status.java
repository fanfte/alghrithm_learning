package com.fanfte.test;

/**
 * Created by dell on 2018/7/27
 **/
public enum Status {

    SUCCESS(200),
    CREATED(201),
    ACCEPTED(202),
    FOUND(302),
    UNAUTHORIZED(401),
    ERROR(500),
    CONTINUE(100);


    private int code;

    Status(int code) {
        this.code = code;
    }
}
