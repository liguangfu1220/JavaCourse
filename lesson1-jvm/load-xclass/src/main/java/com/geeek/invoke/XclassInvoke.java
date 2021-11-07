package com.geeek.invoke;

import com.geeek.classloader.HelloClassLoader;
import com.geeek.exception.XclassInvokeException;
import com.geeek.utils.FileUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class XclassInvoke {

    public static final String FILE_NAME = "Hello.xlass";

    public static final String CLASS_NAME = "Hello";

    public static final String METHOD_NAME = "hello";

    public void invoke() throws XclassInvokeException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //get file path
        String filePath;

        try {
            filePath = FileUtil.absolutePath(FILE_NAME);
        } catch (IOException e) {
            throw new XclassInvokeException(e);
        }

        HelloClassLoader loader = new HelloClassLoader(filePath);

        //load class
        Class<?> helloClass = loader.loadClass(CLASS_NAME);

        //reflect method
        Method helloClassMethod = helloClass.getMethod(METHOD_NAME);

        //invoke method
        Object helloObject = helloClass.newInstance();
        helloClassMethod.invoke(helloObject);

    }
}
