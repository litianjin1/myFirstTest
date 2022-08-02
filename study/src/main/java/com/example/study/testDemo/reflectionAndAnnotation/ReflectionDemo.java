package com.example.study.testDemo.reflectionAndAnnotation;

import com.example.study.facade.User;

import java.lang.reflect.Field;

public class ReflectionDemo {

    /**
     *
     * 解析方法注解
     * 1、获取类中的变量（Field）
     *
     * Field[] getFields()：获取类中所有被public修饰的所有变量 Field getField(String
     * name)：根据变量名获取类中的一个变量，该变量必须被public修饰 Field[]
     * getDeclaredFields()：获取类中所有的变量，但无法获取继承下来的变量 Field
     * getDeclaredField(String name)：根据姓名获取类中的某个变量，无法获取继承下来的变量
     *
     * 2、获取类中的方法（Method）
     *
     * Method[] getMethods()：获取类中被public修饰的所有方法
     * Method getMethod(String name, Class…<?>
     * paramTypes)：根据名字和参数类型获取对应方法，该方法必须被public修饰
     * Method[] getDeclaredMethods()：获取所有方法，但无法获取继承下来的方法
     * Method getDeclaredMethod(String name, Class…<?>
     * paramTypes)：根据名字和参数类型获取对应方法，无法获取继承下来的方法
     *
     * 3、获取类的构造器（Constructor）
     *
     * Constuctor[] getConstructors()：获取类中所有被public修饰的构造器 Constructor
     * getConstructor(Class…<?> paramTypes)：根据参数类型获取类中某个构造器，该构造器必须被public修饰
     * Constructor[] getDeclaredConstructors()：获取类中所有构造器 Constructor
     * getDeclaredConstructor(class…<?> paramTypes)：根据参数类型获取对应的构造器
     * ————————————————
     * 版权声明：本文为CSDN博主「负债程序猿」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_33709582/article/details/113550163
     *
     * @description --
     * @author -- ltj
     * @date -- 2022/7/22 9:22
     * @param
     * @return -- void
     */
    public  static  void test01(){
        Class<MyAnnotation> myAnnotationClass = MyAnnotation.class;
        Class<User> userClass = User.class;

        //1、获取类中所有被public修饰的所有变量
        Field[] fields = userClass.getFields();
        System.out.println("===============================所有public 属性=====================================");
        for (Field field : fields) {
            System.out.println(field.getName()+"    "+field.getAnnotatedType());
            System.out.println(field.getGenericType() );
            System.out.println(field.getType());
            System.out.println("__________________________________________________________");


        }
//        2、获取类中所有变量
        Field[] declaredFields = userClass.getDeclaredFields();
        System.out.println("====================================== 所有属性，包括公开私有 ============================");
        for (Field field : declaredFields) {
            System.out.println(field.getName()+"    "+field.getAnnotatedType());
            System.out.println(field.getType());
            System.out.println("__________________________________________________________");


        }
    }

    public static void main(String[] args) {
        test01();
    }
}
