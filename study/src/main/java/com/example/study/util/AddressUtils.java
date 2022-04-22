//package com.example.study.util;
//
//
//import org.codehaus.jettison.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 获取地址类
// *
// * @author ruoyi
// */
//public class AddressUtils {
//
//    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);
//
//    public static final String BAI_DU_IP_URL = "http://api.map.baidu.com/location/ip?ak=CKfZhvBBla770nmK6yT3py6QVit4zgEP&ip={}&coor=bd09ll";
//
//    public static String getRealAddressByIP(String ip) {
//        String address = "XX XX";
//        // 内网不查询
//        if (IpUtils.internalIp(ip)) {
//            return "内网IP";
//        }
//        try {
//             JSONObject content = getRealContentByIP(ip);
//            if(content == null){
//                return "内网IP";
//            }
//            address = content.getSxtr("address");
//        } catch (Exception e) {
//            log.error("获取地理位置异常 {}", ip);
//        }
//        return address;
//    }
//
//    public static String getRealProvinceByIP(String ip) {
//        String province = "其他";
//        // 内网不查询
//        if (IpUtils.internalIp(ip)) {
//            return "其他";
//        }
//        try {
//            JSONObject content = getRealContentByIP(ip);
//            if(content == null){
//                return "其他";
//            }
//            JSONObject address_detail = content.getObj("address_detail");
//            province = address_detail.getStr("province");
//        } catch (Exception e) {
//            log.error("获取地理位置异常 {}", ip);
//        }
//        return province;
//    }
//
//    public static Map getJsonInfo(String ip) {
//        Map map =  new HashMap();
//        map.put("address","内网ip");
//        map.put("province","其他");
//        if (IpUtils.internalIp(ip)) {
//            return map;
//        }
//        try {
//            JSONObject content = getRealContentByIP(ip);
//            if(content == null){
//                return map;
//            }
//            JSONObject address_detail = content.getObj("address_detail");
//            map.put("address", content.getStr("address"));
//            map.put("province",address_detail.getStr("province"));
//        } catch (Exception e) {
//            log.error("获取地理位置异常 {}", ip);
//        }
//        return map;
//    }
//
//    private static JSONObject getRealContentByIP(String ip) {
//        String rspStr = HttpUtils.sendPost(StringUtils.format(BAI_DU_IP_URL, ip));
//        if (StringUtils.isEmpty(rspStr)) {
//            log.error("获取地理位置异常 {}", ip);
//            return null;
//        }
//        JSONObject content = new JSONObject();
//        try {
//            JSONObject obj = JSON.unmarshal(rspStr, JSONObject.class);
//            content = obj.getObj("content");
//        } catch (Exception e) {
//            log.error("获取地理位置异常 {}", ip);
//        }
//        return content;
//    }
//}
