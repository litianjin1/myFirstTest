package com.example.study.emails;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class SendEmail {
    public static void main(String [] args)
    {
        // 收件人电子邮箱
        String to = "ltj231617@163.com";

        // 发件人电子邮箱
        String from = "litianjin_ztj@163.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.163.com";

        // 获取系统属性
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        // 获取默认session对象
//        Session session = Session.getDefaultInstance(properties);
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication("litianjin_ztj@163.com", "UDXEXPELVUWSHXUM"); //发件人邮件用户名、授权码
        }
    });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
//            message.setText("This is actual message");

            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();

            // 消息
            messageBodyPart.setText("This is message body");

            // 创建多重消息
            Multipart multipart = new MimeMultipart();

            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);

            // 附件部分
            messageBodyPart = new MimeBodyPart();
            String filename = "text.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // 发送完整消息
            message.setContent(multipart );


            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
