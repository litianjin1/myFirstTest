package com.example.study.testDemo.ossDemo;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class OSSUpLoad {

    public  static  String uploadImg(){
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tFFaVrVi8K3Dczx7UyH";
        String accessKeySecret = "UATk9RBtq6X0NN2PADiY5mexz9lcjQ";
        String bucketName = "xiaofeng-oss-demo";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        try {
            inputStream = new FileInputStream("D:\\pic\\test.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
// 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
         ossClient.putObject(bucketName, "exampledir/exampleobject.txt", inputStream);

// 关闭OSSClient。
        ossClient.shutdown();

        return "success";
    }

    public static void main(String[] args) {
        uploadImg();
    }

}
