package com.geek.clientServer.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClient {

    public static void main(String[] args) {
        String request = doGet("http://localhost:8801");
        System.out.println(request);
    }

    private static String doGet(String urlPath) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(urlPath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            System.out.println(connection.getResponseCode() + "\t" + connection.getResponseMessage());

            inputStream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                stringBuilder.append(temp);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            close(bufferedReader);
            close(inputStream);
        }
        return stringBuilder.toString();
    }

    /**
     * 关闭流
     */
    private static void close(Closeable res) {
        if (res != null) {
            try {
                res.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
