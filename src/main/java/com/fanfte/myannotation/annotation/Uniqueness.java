package com.fanfte.myannotation.annotation;

/**
 * Created by dell on 2018/5/23
 **/
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true, primaryKey = true, allowNull = false);
}
