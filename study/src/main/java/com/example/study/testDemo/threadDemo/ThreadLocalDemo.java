package com.example.study.testDemo.threadDemo;


import io.swagger.models.auth.In;

import java.util.Random;

public class ThreadLocalDemo {

    public static ThreadLocal<Context> threadLocal = new ThreadLocal(){
        @Override
        protected Context initialValue() {
            Context context = new Context();
            context.setTransactionId("hello");
            return context;
        }
    };


    public static void main(String[] args) {

        Context context = new Context();
        Random random = new Random();
        int i = random.nextInt(100);
        context.setTransactionId(i+"");

        threadLocal.set(context);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new BusinessService().businessMethod();
        threadLocal.remove();
    }


}

//threadlocal里存的变量
class Context {
    private String transactionId = null;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}

//模拟其它位置取到变量
class BusinessService {
    public void businessMethod() {
        Context context = ThreadLocalDemo.threadLocal.get();
        System.out.println(Thread.currentThread().getName()+":"+ context.getTransactionId());
    }
}