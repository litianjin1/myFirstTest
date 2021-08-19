package com.example.demo.localDateDemo;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationDemo {
    /*
     * @description -- Duration里面封装了seconds和nanos，前者是秒，后者是纳秒，代表着两个时间间的差值；
     *   而Period里面封装了day，month，years 3 个属性，代表的是两个日期间的差值。
     *   所以，Duration只能计算包含有时间的对象，比如LocalDateTime，LocalTime，Instant，如果计算LocalDate的话会不支持的异常。
     *   同理，Period也就只支持LocalDate的计算。
     *   原文链接：https://blog.csdn.net/Sixpences/article/details/112761441
     * @author -- ltj
     * @date -- 2021/8/11 13:36
     * @param args
     * @return -- void
     */
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(1);

        // 根据两个时间获取 Duration
        Duration duration = Duration.between(today, tomorrow);
        print("获取纳秒数差值：", duration.toNanos());
        print("获取毫秒数差值：", duration.toMillis());
        print("获取秒数差值: ", duration.getSeconds());
        print("获取分钟数差值：", duration.toMinutes());
        print("获取小时数差值：", duration.toHours());
        print("获取天数差值：", duration.toDays());

        // 当第1个时间比第2个时间小时为false, 反之true。可以用来判断2个时间的大小。
        boolean negative = duration.isNegative();
        print("isNegative: ", negative);

        // 以1天的差值创建Duration
        Duration duration1 = Duration.ofDays(1);
        print("以1天的差值创建Duration: ", duration1.getSeconds());

        testDuration();
    }

    /*
     * @description -- Duration还有个功能，可以通过解析字符串来生成对象。
     * 字符串的规则是这样：PnDTnHnMn.nS。P为固定开头，n为数字，D为天数，
     * T代表后面是时间部分，H、M、S分别时、分、秒。字母大小写不敏感，可大写可小写。
     * 另外还支持+和-。+为往上加时间，-为往下减时间。
     * @author -- ltj
     * @date -- 2021/8/11 13:38
     * @param
     * @return -- void
     */
    public static void testDuration() {
        Duration duration = Duration.parse("P1DT1H1M1S");
        print("当前时间加上1天1小时1分钟1秒的差值: ", duration.getSeconds());

        Duration duration1 = Duration.parse("P2D");
        print("当前时间加上2天的差值: ", duration1.getSeconds());

        Duration duration2 = Duration.parse("PT2H");
        print("当前时间加上2小时的差值: ", duration2.getSeconds());

        Duration duration3 = Duration.parse("PT-2H");
        print("当前时间减去2小时的差值: ", duration3.getSeconds());

        Duration duration4 = Duration.parse("PT-2H30M");
        print("当前时间减去1小30分的差值: ", duration4.getSeconds());

        Duration duration5 = Duration.parse("PT-2H-30M");
        print("当前时间减去2小30分的差值: ", duration5.getSeconds());

        // 上面的也可以写成这样
        Duration duration6 = Duration.parse("-PT2H30M");
        print("当前时间减去2小30分的差值: ", duration6.getSeconds());
    }


    public static void print(String s,Object o){
        System.out.println(s+o);
    }
}
