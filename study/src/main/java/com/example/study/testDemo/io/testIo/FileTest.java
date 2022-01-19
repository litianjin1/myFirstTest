package com.example.study.testDemo.io.testIo;

public class FileTest {
    public static void main(String[] args) {
        float v = Float.parseFloat("0.01");
        System.out.println(v);
        if(v<0.01){
            System.out.println("float（0.01）直接和0.01比较，居然小于0.01");
        }else{
            System.out.println("float（0.01）直接和0.01比较，不小于0.01");

        }

        System.out.println("==============================换行符====================================");
        if(v<Float.parseFloat("0.01")){
            System.out.println("float（0.01）和float的0.01比较，居然小于0.01");
        }else{
            System.out.println("float（0.01）和float的0.01比较，不小于0.01");

        }


/*        File f = new File("E:/workspace/testDemo/src/main/java/com/example/demo/demoFile");
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
        System.out.println("句对文件："+f.getAbsoluteFile());*/
    }
}
