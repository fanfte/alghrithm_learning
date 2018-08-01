package com.fanfte.java8;

import java.util.function.Function;

/**
 * Created by dell on 2018/8/1
 **/
public class Letter {

    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpellling(String text) {
        return text.replaceAll("labda", "Lambda");
    }

    public static void main(String[] args) {
        Function<String, String> trans = Letter::addHeader;
        Function<String, String> res = trans.andThen(Letter::addFooter).andThen(Letter::checkSpellling);
        String labda = res.apply("labda");
        System.out.println(labda);
    }
}
