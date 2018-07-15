package com.fanfte.myannotation.test;

import com.fanfte.myannotation.annotation.UseCase;

/**
 * Created by dell on 2018/5/22
 **/
public class PasswordUtil {

    @UseCase(id = 99, description = "password ")
    public String encodePassword(String password) {
        return new StringBuffer(password).toString();
    }

    @UseCase(id = 100, description = "new Username")
    public String reNameUser(String username) {
        return username + "rename";
    }
}
