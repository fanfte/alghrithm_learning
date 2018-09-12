package com.fanfte.guava;

import com.google.common.collect.ComparisonChain;

/**
 * Created by tianen on 2018/9/5
 *
 * @author fanfte
 * @date 2018/9/5
 **/
public class Person implements Comparable<Person> {

    private String lastName;

    private String firstName;

    private int zipCode;

    @Override
    public int compareTo(Person other) {
        return ComparisonChain.start()
                .compare(this.lastName, other.lastName)
                .compare(this.firstName, other.lastName)
                .compare(this.zipCode, other.zipCode)
                .result();
    }
}
