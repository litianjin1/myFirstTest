package com.example.study.testDemo.serializeDemo;


import org.testng.annotations.Test;

import java.io.*;


/**
 * ObjectOutputStream 类用来序列化一个对象，如下的 SerializeDemo 例子实例化了一个 Employee 对象，并将该对象序列化到一个文件中。
 *
 * 该程序执行后，就创建了一个名为 employee.ser 文件。该程序没有任何输出，但是你可以通过代码研读来理解程序的作用。
 *
 * 注意： 当序列化一个对象到文件时， 按照 Java 的标准约定是给文件一个 .ser 扩展名。
 */
public class SerializeDemo
{
   public static void main(String [] args)
   {
      Employee e = new Employee();
      e.name = "Reyan Ali";
      e.address = "Phokka Kuan, Ambehta Peer";
      e.SSN = 11122333;
      e.number = 101;
      try
      {
         FileOutputStream fileOut =
         new FileOutputStream("/tmp/employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /tmp/employee.ser");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
   }






   @Test
   public void test(){
      Employee employee = new Employee();
      employee.setAddress("地址");
      employee.setName("名字");
      employee.setSSN(1000);
      employee.setNumber(666);


      try {
 /*        //最好先判断有没有文件夹，再去生成
         File cacheDir = new File("tmp");//设置目录参数
         cacheDir.mkdirs();//新建目录
         String filename;
         //获得文件名的长度
         filename = "employee.ser";
         //文件名
         File cacheFile = new File(cacheDir,filename);//设置参数
         cacheFile.createNewFile();//生成文件
*/

         FileOutputStream fos = new FileOutputStream("tmp/employee.ser");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(employee);
         oos.close();
         fos.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }


   /**
    * readObject() 方法中的 try/catch代码块尝试捕获 ClassNotFoundException 异常。对于 JVM 可以反序列化对象，它必须是能够找到字节码的类。
    * 如果JVM在反序列化对象的过程中找不到该类，则抛出一个 ClassNotFoundException 异常。
    * 注意，readObject() 方法的返回值被转化成 Employee 引用。
    * 当对象被序列化时，属性 SSN 的值为 111222333，但是因为该属性是短暂的，该值没有被发送到输出流。所以反序列化后 Employee 对象的 SSN 属性为 0。
    */
   @Test
   public void  test2(){

      try {
         FileInputStream fis = new FileInputStream("tmp/employee.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         Employee e = (Employee)ois.readObject();

         System.out.println(e.getAddress());
         System.out.println(e.getName());
         System.out.println(e.getNumber());
         System.out.println(e.getSSN());

         ois.close();
         fis.close();


      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }finally {

      }

   }


}