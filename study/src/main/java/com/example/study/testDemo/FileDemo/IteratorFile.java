package com.example.study.testDemo.FileDemo;

import java.io.File;
import java.util.Random;

public class IteratorFile {
    public static void changeName(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()){
                changeName(files[i].toString());
            }else{
                String name = files[i].getAbsolutePath();
                files[i].renameTo(new File("E:\\pipeline\\sougou\\temp\\meinv1"+files[i].getName()));
            }

        }

    }

    public static String getChar(){
        String[] datas = {"a","b","c","d","e","f","g","h","k","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random r = new Random();
        return datas[r.nextInt(datas.length-1)];
    }
    public static void main(String[] args) {
        changeName("E:\\pipeline\\sougou\\beauty");
    }
}
