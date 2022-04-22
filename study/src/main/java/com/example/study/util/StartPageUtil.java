//package com.example.study.util;
//
//import com.github.pagehelper.PageHelper;
//
//public class StartPageUtil {
//    /**
//     *设置请求分页数据
//     *
//     * @param pageNum 当前页
//     * @param pageSize  分页大小
//     */
//    public static void startPage(Integer pageNum, Integer pageSize){
//        startPage(pageNum, pageSize, null);
//    }
//
//    /**
//     *设置请求分页数据
//     *
//     * @param pageNum 当前页
//     * @param pageSize  分页大小
//     * @param orderBy 排序字段
//     */
//    public static void startPage(Integer pageNum, Integer pageSize, String orderBy)
//    {
//        if(pageNum == null || pageNum <= 0){
//            pageNum = 1;
//        }
//        if(pageSize == null || pageSize <= 0){
//            pageSize = 10;
//        }
//        if (StringUtils.isNull(orderBy))
//        {
//            PageHelper.startPage(pageNum, pageSize);
//        }else{
//            PageHelper.startPage(pageNum, pageSize, orderBy);
//        }
//    }
//}
