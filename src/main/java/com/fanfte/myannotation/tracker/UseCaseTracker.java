package com.fanfte.myannotation.tracker;

import com.fanfte.myannotation.annotation.UseCase;
import com.fanfte.myannotation.test.PasswordUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dell on 2018/5/22
 **/
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> clz) {
        for(Method m : clz.getDeclaredMethods()) {
            UseCase useCase = m.getAnnotation(UseCase.class);
            if(useCase != null) {
                System.out.println("usecase id : " + useCase.id() + " description " + useCase.description());
                useCases.remove(new Integer(useCase.id()));
            }
        }
        for(int i : useCases) {
            System.out.println("Warning : missing useCase : " + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtil.class);
    }
}
