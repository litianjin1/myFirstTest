//package com.example.study.mainTest;
//
//import com.example.study.testDemo.mysqlDemo.Txconfig;
//import com.example.study.testDemo.mysqlDemo.UserService;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Main_txTest {
//
//    @SuppressWarnings("resource")
//    @Test
//    public void test01(){
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Txconfig.class);
//        UserService bean = annotationConfigApplicationContext.getBean(UserService.class);
//        bean.insertUser();
//        annotationConfigApplicationContext.close();
//    }
//
//
//}
