package com.example.saxjiexixml;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    public HttpUtils(){

    }

    public static InputStream getXML(String path){
        try {
            URL url = new URL(path);
            if(url!=null){
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setDoInput(true);
                connection.setConnectTimeout(3000);
                connection.setRequestMethod("GET");
                int requestCode = connection.getResponseCode();
                if (requestCode == HttpURLConnection.HTTP_OK){
                    return connection.getInputStream();
                }
            }

        } catch (Exception e){

        }
        return null;
    }
}
