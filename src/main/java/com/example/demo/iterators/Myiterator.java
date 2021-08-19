package com.example.demo.iterators;

import com.example.demo.TestUtil.CommonUseObject;
import com.example.demo.facade.User;
import org.apache.poi.ss.formula.functions.T;

import java.util.*;

public class Myiterator {

    public static void main(String[] args) {
        Bar<String> stringBar = new Bar<String>();
        stringBar.setVa(new String("sasasaffasf"));

        generics("saas");
        iteratorMap();
    }

    public static<E> void  generics(E s){

        String s1 = s.getClass().toString();
        System.out.println(s1);
    }

    public static void  iteratorList(){
        List<User> listUser = CommonUseObject.getListUser();
        Iterator iterator = listUser.iterator();
        while (iterator.hasNext()){
            System.out.println();
            User user =(User)iterator.next();
            if(user.getAge()>20){
                iterator.remove();
            }
        }
        System.out.println(listUser);
    }
    public static void  iteratorMap(){
        Map<String, String> map = CommonUseObject.creratMap();
        String replace = map.replace("key111", "哒哒哒");
        boolean b = map.replace("key1112", "哒哒哒", "asasasfasf");
        System.out.println(b);
        System.out.println("replace,返回老值"+replace);
        String s3 = map.putIfAbsent("key3", "你好");
        String s99 = map.putIfAbsent("key99", "你好");

        System.out.println("putIfAbsent:如果存在key,返回key对应的值，如果不存在，插入，并返回 null"+s3);
        System.out.println("putIfAbsent:如果存在key,返回key对应的值，如果不存在，插入，并返回 null"+s99);

        HashMap<String, String> cloneMap = (HashMap<String, String>)((HashMap<String, String>) map).clone();

        System.out.println("集合克隆，hashMap有克隆方法{}"+cloneMap);

        //遍历key,取值
        Set<String> keySet = map.keySet();
        System.out.println("keySet");
        for(String m:keySet){
            System.out.print(m+":"+map.get(m)+"\t");
        }
        System.out.println("\n");
        //遍历试图取值  entrySet[key1=valueA, key2=valueB, key5=valueE, key6=valueF, key3=valueC, key4=valueD, key9=valueH, key7=valueD, key8=valueG]
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        System.out.println("entrySet第一种遍历");
        for(Map.Entry<String, String> mm:entrySet){
            System.out.print(mm.getKey()+":"+mm.getValue()+"\t");
        }
        System.out.println("\n");
        System.out.println("entrySet第二种遍历，迭代");
        Iterator<Map.Entry<String, String>> iterators = entrySet.iterator();
        while (iterators.hasNext()){
            Map.Entry<String, String> entry = iterators.next();
            System.out.print(entry.getKey()+":"+entry.getValue()+"\t");
        }

    }
}

class  Bar<T>{

    private T va;

    public void setVa(T va) {
        this.va = va;
    }

    public T getVa() {
        return va;
    }
}