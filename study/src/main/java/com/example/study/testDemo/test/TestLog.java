package com.example.study.testDemo.test;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Aspect
@Component
@Slf4j
public class TestLog {


    @Test
    public void test11(){
        String str = "31030 测试提交审核的订单等级32  灰铁铸件 按成分配比";

        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 0x4E00 && c <= 0x9FA5) { // 判断是否为中文字符
                len += 3;
            } else {
                len += 1;
            }
        }

        if (len >= 64) {
            len = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 0x4E00 && c <= 0x9FA5) { // 判断是否为中文字符
                    len += 3;
                } else {
                    len += 1;
                }
                if (len >= 60) {
                    break;
                }
                sb.append(c);
            }
            str = sb.toString() + "...";
        }
        System.out.println(str);
    }

    @Test
    public void testFloat(){

        String[] strArray = new String[]{"214,215","217,214,215","218,215","215"};
        List<String> list = Arrays.asList(strArray);
        Map<String, Long> collect = list.stream().flatMap(e -> Stream.of(e.split(","))).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(collect);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");
        stringBuilder.append("world");

        System.out.println(stringBuilder.toString());
        String dictLabel = "模板一|视觉差响应式（主红+辅灰）| 全信息：8产品、设备卡片、资质卡片、可独立内页";
        if(null != dictLabel && dictLabel.contains("|")) {
            System.out.println("ssssssssss");
            String[] splitArray = dictLabel.split("\\|");
            System.out.println(splitArray[0]);
            System.out.println(splitArray[1]);
            System.out.println(splitArray[2]);

        }


        A:for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                System.out.println("i ="+i+";j="+j);
                if(5==i && 5==j){
                    break;
                }
            }
        }

        float f = 1.3f;
        Integer s = 1;
        Double d =1.3;
        int i = s.intValue();
        double v = d.doubleValue();
       String[] st = new String[5];
        int length = st.length;

        double naN = Double.NaN;
        System.out.println("f:"+f);
        System.out.println(3*0.1);
        System.out.println(0.3);

    }
    @Test
    public void sortedSquares() {
        int[] nums;
        nums = new int[] {-4,-1,0,3,4,5,10};
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            System.out.println("执行 i:"+i+" j:"+j+" pos :"+pos);
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
       Arrays.asList(ans).forEach(e-> System.out.println(e));
    }

    @Test
    public void rotate() {

        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;

        int len = nums.length;
        int[] result = new int[len];
        int rm = k>len?k%len : k;
        for(int i= 0 ;i<=len-1;i++){
            int num = nums[i];
            int newIndex = rm + i;
            if(newIndex>len-1){
                result[newIndex - len] = num;
            }else{
                result[newIndex] = num;
            }
        }
        System.arraycopy(result,0,nums,0,len);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(" || " + nums[i]);
        }
    }



    @Test
    public void testconsoleLogInfo(){
        sortedSquares();
        log.info("logger.info........");
        log.error("logger.info........");
        log.warn("logger.info........");
        log.debug("logger.info........");


        String regex = "^([1-9][0-9]*)+(.[0-9]{1,2})?$";
        boolean matches = Pattern.matches(regex, "111&3");
        System.out.println(matches);
    }
}
