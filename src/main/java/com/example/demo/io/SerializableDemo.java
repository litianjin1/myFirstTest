package com.example.demo.io;

import com.example.demo.facade.User;

import java.io.*;
import java.sql.Timestamp;

public class SerializableDemo {

    public static void main(String[] args) {
        main3();
    }
    public static void main1()  {
        User e = new User();
        e.setName("Reyan Ali");
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("D:/pic/user.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in D:/pic/user.txt");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
    public static void main3() {
        File f = new File("D:/pic/test.txt");
        try {
            User u = new User();
            u.setName("nama");
            u.setAge(10);
            u.setTestTime(new Timestamp(System.currentTimeMillis()));

            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(u);
            oos.close();
            fos.close();

            FileInputStream fileInputStream = new FileInputStream(f);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            User user = (User) objectInputStream.readObject();
            System.out.println(user);
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main2() {

    }
}
