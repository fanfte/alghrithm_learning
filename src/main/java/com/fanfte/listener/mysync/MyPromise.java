package com.fanfte.listener.mysync;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2018/11/6
 *
 * @author fanfte
 * @date 2018/11/6
 **/
public class MyPromise {

    private List<MyListener> listeners = new ArrayList<>();

    private Object result;

    private boolean success;

    private Integer failCount;

    public boolean setSuccess(Object result) {
        if(success) {
            return false;
        }
        this.result = result;
        this.success = true;
        notifyListeners();
        return true;
    }

    private void notifyListeners() {
        for (MyListener listener : listeners) {
            listener.operationComplete(this);
        }
    }

    public boolean setFailure(Object result) {
        if(failCount > 0) {
            return false;
        }
        failCount ++;
        this.result = result;
        this.success = false;
        notifyListeners();
        return true;
    }

    public boolean isSuccess() {
        return success;
    }

    public void addListener(MyListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(MyListener listener) {
        this.listeners.remove(listener);
    }

    public Object get() {
        return result;
    }
}
