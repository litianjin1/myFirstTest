//package com.example.study.util;
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CheckFieldUtils {
//
//    public static <T> List<String[]> check(T t,Object oldBean, Object newBean) {
//        String str="";
//        T pojo1 = (T) oldBean;
//        T pojo2 = (T) newBean;
//        try {
//            Class clazz = pojo1.getClass();
//            Field[] fields = pojo1.getClass().getDeclaredFields();
//            List<String[]> result = new ArrayList<>();
//
//            for (Field field : fields) {
//                if("serialVersionUID".equals(field.getName()) || "bannerUrl".equals(field.getName())){
//                    continue;
//                }
//                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
//                Method getMethod = pd.getReadMethod();
//                Object o1 = getMethod.invoke(pojo1);
//                Object o2 = getMethod.invoke(pojo2);
//                if(o1 == null && (o2 == null ||  StringUtils.isEmpty(o2.toString()))){//现值等于null不比对（等于null不跟新）
//                    continue;
//                }
//                if (o1 == null || (o2!=null && !o1.toString().equals(o2.toString()))) {
//                    String[] strings = new String[4];
//                    FieldName fieldName = field.getAnnotation(FieldName.class);
//                    strings[0] = field.getName();//字段名
//                    strings[1] = fieldName == null?field.getName(): fieldName.value();//中文（如果没空就展示字段名)
//                    strings[2] = o1 == null?"null":o1.toString();//原值
//                    strings[3] = o2.toString();//现值
//                    result.add(strings);
//                }
//            }
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}