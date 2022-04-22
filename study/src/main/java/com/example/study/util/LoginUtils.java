//package com.example.study.util;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 登录信息获取工具类
// *
// * @author zxk
// * @date 14:55 2021/5/17
// **/
//public class LoginUtils {
//
//    /**
//     * 获取登录用户id
//     */
//    public static Long getCurrentUserId()
//    {
//        Long id = Long.parseLong(getRequest().getAttribute("userId").toString());
//        if (null == id)
//        {
//            id = 0l;
//        }
//        return id;
//    }
//
//    /**
//     * 获取request
//     */
//    public static HttpServletRequest getRequest()
//    {
//        return ServletUtils.getRequest();
//    }
//}
