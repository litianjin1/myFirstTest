package com.example.study.soketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class URLConnDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.runoob.com");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpURLConnection = null;
            if(urlConnection instanceof HttpURLConnection){
                httpURLConnection =(HttpURLConnection) urlConnection;
            }else{
                System.out.println("ssssssse");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String str = "";
            String content ="";
            while((content = br.readLine())!=null){
                str+=content;
            }
            System.out.println(str);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
