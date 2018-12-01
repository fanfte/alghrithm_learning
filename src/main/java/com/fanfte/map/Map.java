package com.fanfte.map;

import java.util.HashMap;

/**
 * Created by tianen on 2018/11/23
 *
 * @author fanfte
 * @date 2018/11/23
 **/
public class Map {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("aaa", "111");
        map.put("bbb", "222");
        map.put("aaa", "333");
        for(int i = 0;i < 20; i++) {
            map.put("key" + i, "value" + i);
        }
        System.out.println(map);
    }
}
