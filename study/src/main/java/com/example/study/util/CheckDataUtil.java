//package com.example.study.util;
//
//import com.github.pagehelper.PageHelper;
//import com.ruoyi.collect.domain.BasePageEntity;
//import com.ruoyi.collect.exception.FormatException;
//
//import java.util.regex.Pattern;
//
///**
// * 数据check
// * @author zdd
// * @date 2019-08-19
// */
//public class CheckDataUtil {
//    /**
//     * 正则表达式（汉字，字母，数字，与半角逗号【,】）
//     */
//    public static  final String STR_CHIN_LET_NUM_COM = "[a-zA-Z\\d\\u4e00-\\u9fa5\\,]*";
//
//    /**
//     * 正则表达式（汉字，字母，数字）
//     */
//    public static  final String STR_CHIN_LET_NUM = "[a-zA-Z\\d\\u4e00-\\u9fa5]*";
//
//    /**
//     * 正则表达式（汉字，字母）
//     */
//    public static  final String STR_CHIN_LET = "[a-zA-Z\\u4e00-\\u9fa5]*";
//
//    /**
//     * 正则表达式（汉字，字母）
//     */
//    public static  final String STR_NUM = "[0-9]*";
//
//    /**密码正则表达式*/
//    public static final String PASSWORD = "(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]{6,16}$";
//    /**用户密码正则*/
//    public static final String MEMBER_PASSWORD = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,20}$";
//
//    /**6-20个字符(包含字母、数字、符号)*/
//    public static final String CHAR_NUM_SYMBOL = "[\\x21-\\x7e]{6,20}";
//
//
//    /**
//     * 汉字，字母，数字，与【,】组合check
//     * @param strMsg
//     * @param strCheck
//     * @throws Exception
//     */
//    public static void checkSTR_CHIN_LET_NUM_COM(String strMsg,Integer length,String strCheck) throws Exception {
//
//        checkNUll(strMsg, strCheck);
//        if(!Pattern.matches(STR_CHIN_LET_NUM_COM ,strCheck)){
//            throw new Exception("请输入汉字，字母，数字，与半角逗号【,】组合" + strMsg + "！");
//        }
//        checkLength(strMsg,length,strCheck);
//    }
//
//    /**
//     * 汉字，字母，数字组合check
//     * @param strMsg
//     * @param strCheck
//     * @throws Exception
//     */
//    public static void checkSTR_CHIN_LET_NUM(String strMsg,Integer length,String strCheck) throws Exception {
//
//        checkNUll(strMsg, strCheck);
//        if(!Pattern.matches(STR_CHIN_LET_NUM ,strCheck)){
//            throw new Exception("请输入汉字，字母，数字组合" + strMsg + "！");
//        }
//        checkLength(strMsg,length,strCheck);
//    }
//
//    /**
//     * 汉字，字母组合check
//     * @param strMsg
//     * @param strCheck
//     * @throws Exception
//     */
//    public static void checkSTR_CHIN_LET(String strMsg,Integer length,String strCheck) throws Exception {
//
//        checkNUll(strMsg, strCheck);
//        if(!Pattern.matches(STR_CHIN_LET ,strCheck)){
//            throw new Exception("请输入汉字，字母组合" + strMsg + "！");
//        }
//        checkLength(strMsg,length,strCheck);
//    }
//
//    /**
//     * 汉字，字母组合check
//     * @param strMsg
//     * @param intCheck
//     * @throws Exception
//     */
//    public static void checkSTR_NUM(String strMsg,Integer length,Integer intCheck) throws Exception {
//
//        checkNUll(strMsg, intCheck);
//        if(!Pattern.matches(STR_NUM ,intCheck.toString())){
//            throw new Exception("请输入汉字，字母组合" + strMsg + "！");
//        }
//        checkLength(strMsg,length,intCheck.toString());
//    }
//
//    /**
//     * 数字组合check(最大长度)
//     * @param strMsg
//     * @param length
//     * @param strCheck
//     * @throws Exception
//     */
//    public static void checkSTR_NUM(String strMsg,Integer length,String strCheck) throws Exception {
//
//        checkNUll(strMsg, strCheck);
//        if(!Pattern.matches(STR_NUM ,strCheck)){
//            throw new Exception("请输数字组合" + strMsg + "！");
//        }
//        checkLength(strMsg,length,strCheck);
//    }
//
//    /**
//     * 数字组合check(最小，最大长度)
//     * @param strMsg
//     * @param strCheck
//     * @throws Exception
//     */
//    public static void checkSTR_NUM(String strMsg,Integer minlength,Integer maxlength,String strCheck) throws Exception {
//
//        checkNUll(strMsg, strCheck);
//        if(!Pattern.matches(STR_NUM ,strCheck)){
//            throw new Exception("请输数字组合" + strMsg + "！");
//        }
//        checkLength(strMsg,minlength,maxlength,strCheck);
//    }
//
//    /**
//     * 空或空串判断
//     * @param strMsg
//     * @param strCheck
//     * @throws Exception
//     */
//    public static  void checkNUll(String strMsg,String strCheck) throws Exception {
//        if(strCheck == null || "".equals(strCheck)){
//            throw new Exception(strMsg + "不能为空，请输入！");
//        }
//    }
//
//    /**
//     * 空或空串判断
//     * @param strMsg
//     * @param intCheck
//     * @throws Exception
//     */
//    public static  void checkNUll(String strMsg,Integer intCheck) throws Exception {
//        if(intCheck == null || "".equals(intCheck)){
//            throw new Exception(strMsg + "不能为空，请输入！");
//        }
//    }
//
//    /**
//     * 长度判断 是否超长
//     * @param strMsg
//     * @param length
//     * @param strCheck
//     * @throws Exception
//     */
//    public static  void checkLength(String strMsg,Integer length,String strCheck) throws Exception {
//        if(strCheck.length() > length){
//            throw new Exception(strMsg + "的长度不能超过" + length.toString() + "！");
//        }
//    }
//
//    /**
//     * 长度判断 最小，最大值check
//     * @param strMsg
//     * @param minlength
//     * @param maxlength
//     * @param strCheck
//     * @throws Exception
//     */
//    public static  void checkLength(String strMsg,Integer minlength,Integer maxlength,String strCheck) throws Exception {
//        if(strCheck.length() > maxlength || strCheck.length() < minlength ) {
//            throw new Exception(strMsg + "的长度在" + minlength.toString() + "～" + maxlength.toString() + "之间！");
//        }
//    }
//
//    /**
//     * 密码check
//     * @param password
//     * @throws Exception
//     */
//    public static void checkPassword(String str, String password) throws Exception {
//        if(password==null || "".equals(password)){
//            throw new Exception(str + "密码不能为空，请输入密码！");
//        }
//        if(!Pattern.matches(PASSWORD,password)){
//            throw new Exception("请输入6~16位的英文和数字组合的"+ str +"密码！");
//        }
//    }
//    /**
//     * 密码check
//     * @param password
//     * @throws Exception
//     */
//    public static void checkMemberPassword(String str, String password) throws Exception {
//        if(password==null || "".equals(password)){
//            throw new Exception(str + "密码不能为空，请输入密码！");
//        }
//        if(!Pattern.matches(CHAR_NUM_SYMBOL,password)){
//            throw new Exception("请输入6~20位的英文、数字、符号组合的"+ str +"密码！");
//        }
//    }
//    /**手机号（移动）正则表达式*/
//    public static final String MOBILE_NO =
//            "^((13[4-9])|(14[7,8])|(15[0-2,7-9])|(165)|(17[2,8])|(18[2-4,7-8])|(198))\\d{8}|(1705)\\d{7}$";
//
//    /**手机号（联通）正则表达式*/
//    public static final String CHINA_UNI_NO  =
//            "^((13[0-2])|(145)|(15[5-6])|(166)|(17[1,5,6])|(18[5,6]))\\d{8}|(1709)\\d{7}$";
//
//    /**手机号（电信）正则表达式*/
//    public static final String ELECTRICAL_SIGNALS  = "^((133)|(149)|(153)|(17[3,4,7])|(18[0,1,9])|(199))\\d{8}$";
//
//    /**手机号（虚拟运营商）正则表达式*/
//    public static final String VIRTUAL_OPERATOR   = "^((170))\\d{8}|(1718)|(1719)\\d{7}$";
//
//    /**手机号不严格验证正则表达式*/
//    public static final String PHONE_NUMBER_CHECK_RULE = "^1[3456789]\\d{9}$";
//
//    /**
//     * 手机号格式check
//     * @param phoneNum
//     * @throws Exception
//     */
//    public static void checkPhoneNum(String phoneNum) throws Exception {
//
//        // 手机号空判断
//        if(phoneNum == null || "".equals(phoneNum)){
//            throw new Exception("手机号不能为空，请输入手机号!");
//        }
//
//        // 手机号格式长度判断
//        if(phoneNum.length() >= 12){
//            throw new Exception("手机号位数应为11位，请确认!") ;
//        }
//
//        // 手机号格式判断
//        /*if(!Pattern.matches(MOBILE_NO, phoneNum)
//                && !Pattern.matches(CHINA_UNI_NO, phoneNum)
//                && !Pattern.matches(ELECTRICAL_SIGNALS, phoneNum)
//                && !Pattern.matches(VIRTUAL_OPERATOR, phoneNum)) {
//            throw new Exception("手机号的格式不正确，请输入正确的手机号！");
//        }*/
//        if(!Pattern.matches(PHONE_NUMBER_CHECK_RULE, phoneNum)){
//            throw new FormatException("手机号的格式不正确，请输入正确的手机号！");
//        }
//    }
//
//    /**
//     * 设置分页
//     * @param pageEntity 包含分页信息的对象
//     */
//    public static void startPage(BasePageEntity pageEntity){
//        Integer pageNum = pageEntity.getPageNum();
//        Integer pageSize = pageEntity.getPageSize();
//        if (pageNum == null || pageNum < 1) {
//            pageNum = 1;
//        }
//
//        if (pageSize == null || pageSize < 0) {
//            pageSize = 10;
//        }
//        PageHelper.startPage(pageNum, pageSize);
//    }
//}
