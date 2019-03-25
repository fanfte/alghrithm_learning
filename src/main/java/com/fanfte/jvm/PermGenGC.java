package com.fanfte.jvm;

/**
 * Created by tianen on 2019/1/3
 *
 * @author fanfte
 * @date 2019/1/3
 **/
public class PermGenGC {

    public static void main(String[] args) {
        for(int i = 0;i < Integer.MAX_VALUE; i++) {
            // 加入常量池
            String s = String.valueOf(i).intern();
        }
    }
}
