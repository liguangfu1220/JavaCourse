package com.geeek;

import com.geeek.exception.XclassInvokeException;
import com.geeek.invoke.XclassInvoke;

import java.lang.reflect.InvocationTargetException;

/**
 * 入口
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        XclassInvoke biz = new XclassInvoke();

        try {
            biz.invoke();
        } catch (XclassInvokeException e) {
            System.out.println("x class invoke error");
        }
    }
}
