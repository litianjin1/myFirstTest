package com.example.study.localDateDemo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TestDateTime {
    public static void main(String[] args) {
        TestDateTime dateTime = new TestDateTime();
//        dateTime.testNow();
        dateTime.testDate();
    }

    public void testNow(){
        System.out.println("LocalDate: "+ LocalDate.now());
        System.out.println("LocalDateTime: "+ LocalDateTime.now());
        System.out.println("LocalTime: "+ LocalTime.now());
        System.out.println("Instant: "+ Instant.now().atZone(ZoneId.systemDefault()));
        System.out.println("Instant: "+ Instant.now().atZone(ZoneId.of("Australia/Darwin")));
    }

    public void testDate(){
        // 获取当天日期时间
        LocalDate today = LocalDate.now();
        print("获取当天日期时间: ", today);

        // 加一天
        LocalDate tomorrow = today.plusDays(1);
        print("加一天: ", tomorrow);

        // 加一个月
        LocalDate nextMonth = today.plusMonths(1);
        print("加一个月: ", nextMonth);

        // 减一天
        LocalDate yesterday = today.minusDays(1);
        print("减一天: ", yesterday);

        // 减一个月
        LocalDate lastMonth = today.minusMonths(1);
        print("减一个月: ", lastMonth);

        // 获取今天是本月第几天
        int dayOfMonth = today.getDayOfMonth();
        print("获取今天是本月第几天: ", dayOfMonth);

        // 获取今天是本周第几天
        int dayOfWeek = today.getDayOfWeek().getValue();
        print("获取今天是本周第几天: ", dayOfWeek);

        // 获取今天是本年第几天
        int dayOfYear = today.getDayOfYear();
        print("获取今天是本年第几天: ", dayOfYear);

        // 获取本月天数。
        int daysOfMonth = today.lengthOfMonth();
        print("获取本月天数: ", daysOfMonth);

        // 获取本年天数
        int daysOfYear = today.lengthOfYear();
        print("获取本年天数: ", daysOfYear);

        // 获取本月指定的第n天
        LocalDate date1 = today.withDayOfMonth(15);
        print("获取本月指定的第n天: ", date1);

        // 获取本月的最后一天
        LocalDate lastDaysOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        print("获取本月的最后一天: ", lastDaysOfMonth);

        // 日期字符串解析。 严格按照ISO yyyy-MM-dd 验证
        LocalDate date = LocalDate.parse("2021-01-17");
        print("日期字符串解析: ", date);

        // 日期字符串解析。 自定义格式
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-M-dd");
        LocalDate date2 = LocalDate.parse("2021-1-17", dft);
        print("日期字符串解析(日期字符串解析): ", date2);

        // 格式化日期
        String dateStr = today.format(dft);
        print("格式化日期: ", dateStr);

        // 自定义日期
        LocalDate cusDate = LocalDate.of(2020, 8, 14);
        print("自定义日期: ", cusDate);

        // 日期比较
        boolean before = today.isBefore(tomorrow);
        print("今天是否比明天早: ", before);

        boolean before1 = today.isBefore(yesterday);
        print("今天是否比昨天早: ", before1);

        boolean after = today.isAfter(tomorrow);
        print("今天是否比明天晚: ", after);

        boolean after1 = today.isAfter(yesterday);
        print("今天是否比昨天晚: ", after1);

        // 获取两个时间相差多少天/周/月...  根据单位不同返回不同
        long until = today.until(nextMonth, ChronoUnit.WEEKS);
        print("今天到下个月相差几周: ", until);

        Month month = today.getMonth();
        print("月份：", month);
        print("月份: ", month.getValue());
    }

    public void print(String s,Object o){
        System.out.println(s+o);
    }
}
