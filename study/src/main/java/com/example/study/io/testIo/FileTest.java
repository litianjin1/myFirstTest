package com.example.study.io.testIo;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        File f = new File("E:/workspace/testDemo/src/main/java/com/example/demo/demoFile");
        if(!f.exists()){
                f.mkdir();
        }else{
            File file = new File(f, "hello.txt");
            try {
                file.createNewFile();
                System.out.println(file.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("句对路径："+f.getAbsolutePath());
        System.out.println("句对文件："+f.getAbsoluteFile());
    }
}
