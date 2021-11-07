package com.geeek.classloader;

import com.geeek.exception.XclassNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader{


    /**
     * extension class file path
     */
    private final String filePath;

    /**
     * constructor
     */
    public HelloClassLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] classBytes = null;
        Path path;

        try {
            //load file to byte array
            path = Paths.get(filePath);
            classBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            System.out.println("class loader error.");
        }

        //empty check
        if (null == classBytes || classBytes.length == 0) {
            throw new XclassNotFoundException("x class not found,name:".concat(name));
        }

        //offset calculate
        for (int i = 0; i < classBytes.length; i++) {
            int temp = 255 - classBytes[i];
            classBytes[i] = (byte) temp;
        }

        //load class and return
        return defineClass(name, classBytes, 0, classBytes.length);
    }
}
