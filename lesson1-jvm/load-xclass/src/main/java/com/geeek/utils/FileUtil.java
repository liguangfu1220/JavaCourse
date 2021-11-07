package com.geeek.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileUtil {
    private FileUtil() { }

    public static String absolutePath(String fileName) throws IOException {
        URL base = Thread.currentThread().getContextClassLoader().getResource("");

        if (null == base) {
            throw new IOException("classpath root dir not found!");
        }

        return new File(base.getFile(), fileName).getCanonicalPath();
    }
}