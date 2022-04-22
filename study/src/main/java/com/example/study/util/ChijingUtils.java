//package com.example.study.util;
//
//import com.ruoyi.collect.exception.BusinessException;
//
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Predicate;
//
///**
// * 我自己用的工具类
// */
//public class ChijingUtils {
//
//    /**
//     * 判断
//     *
//     * @param t   任何类型对象
//     * @param msg 报错信息
//     */
//    public static <T> void checkT(T t, Predicate<T> predicate, String msg) {
//        if (predicate.test(t)) {
//            throw new BusinessException(msg);
//        }
//    }
//
//    /**
//     * 判断是否是空
//     *
//     * @param t   任何类型对象
//     * @param msg 报错信息
//     */
//    public static <T> void isNullExce(T t, String msg) {
//        if (t == null) {
//            throw new BusinessException(msg);
//        }
//    }
//
//    /**
//     * 判断是否不为空
//     */
//    public static <T> void notNullExce(T t, String msg) {
//        if (t != null) {
//            throw new BusinessException(msg);
//        }
//    }
//
//    /**
//     * 获得的格式化后当前时间
//     *
//     * @return 当前时间
//     */
//    public static String now() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//    }
//
//    /**
//     * 获得的格式化后当前时间
//     *
//     * @return 当前时间
//     */
//    public static String now(String format) {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
//    }
//
//    /**
//     * 对date类型时间格式化后返回字符窜时间
//     *
//     * @param date   时间参数
//     * @param format 格式
//     * @return 字符串时间
//     */
//    public static String dateToString(Date date, String format) {
//        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(format));
//    }
//
//    /**
//     * 把eneity包装成map
//     *
//     * @param obj 数据
//     * @return map
//     */
//    public static Map<String, Object> createMapEntity(String key, Object obj) {
//        Map<String, Object> map = new HashMap<>();
//        map.put(key, obj);
//        return map;
//    }
//
//}
