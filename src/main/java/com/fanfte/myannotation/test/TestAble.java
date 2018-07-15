package com.fanfte.myannotation.test;

import com.fanfte.myannotation.annotation.Test;
import com.fanfte.myannotation.annotation.UseCase;

/**
 * Created by dell on 2018/5/22
 **/
public class TestAble {

    public void execute() {
        System.out.println("executing");
    }

    @UseCase(id = 1 ,description = "aaa")
    public void testExecute() {
        execute();
    }
}
