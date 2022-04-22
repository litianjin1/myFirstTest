//package com.example.study.util;
//
//import com.ruoyi.collect.constant.Constants;
//import com.ruoyi.collect.mapper.BasicInfoProviderMapper;
//import com.ruoyi.collect.mapper.MemberOperateRecordMapper;
//import com.ruoyi.collect.mapper.OrderMapper;
//import com.ruoyi.collect.mapper.SysDictDataMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//
///**
// * 定时任务（根据自己业务修改此处）
// *
// * @author zc
// */
//@Configuration
//@EnableScheduling
//@EnableAsync
//public class TaskSchedule {
//
//    // 此处依赖注入
//    @Autowired
//    private OrderMapper orderMapper;
//
//    @Autowired
//    private MemberOperateRecordMapper memberOperateRecordMapper;
//
//    @Autowired
//    private SysDictDataMapper sysDictDataMapper;
//
//    /**
//     * 检测订单是否到报价截止日期 每5分钟执行一次
//     */
//    @Scheduled(cron = "0 0/5 * * * ? ")
//    @Async
//    public void checkOrderCloseTime() throws InterruptedException {
//        //更新报价截止日期超过当前时间的订单，将订单状态更新为下架，并向消息中心插入下架消息
//        orderMapper.checkOrderOffShelf(Constants.MESSAGE_BEGIN, Constants.MESSAGE_DOWN_END, Constants.HTML_BEGIN_STYLE, Constants.HTML_BEGIN, Constants.HTML_END);
//    }
//
//
//    /**
//     * 每日凌晨2点执行定时任务 插入符合条件的会员操作记录
//     *
//     * @author zxk
//     * @date 10:42 2021/6/26
//     * @return void
//     **/
//    //@Scheduled(cron = "0 0/2 * * * ? ")
//    @Scheduled(cron = "0 0 2 * * ?")
//    @Async
//    public void insertRecord() {
//        System.out.println("定时任务开始......");
//        long begin = System.currentTimeMillis();
//        int i = memberOperateRecordMapper.insertRecordByTimed(Integer.parseInt(sysDictDataMapper.selectDictLabel("operate_count_set","1")));
//        long end = System.currentTimeMillis();
//        System.out.println(("定时任务结束，共插入"+i+" 条记录, 耗时：[" + (end-begin) + "]毫秒"));
//
//    }
//
//    @Autowired
//    BasicInfoProviderMapper basicInfoProviderMapper;
//    /**
//     * 每日凌晨1点执行定时任务 更新到期的供应商会员
//     *
//     * @author ltj
//     * @date 10:42 2021/11/13
//     * @return void
//     **/
//    @Scheduled(cron = "0 0 1 * * ?")
//    //测试没2分钟一次
////    @Scheduled(cron = "0 0/5 * * * ?")
//    @Async
//    public void updateProviderVipEnd() {
//        System.out.println("定时任务开始更新到期会员......");
//        long begin = System.currentTimeMillis();
//        int i = basicInfoProviderMapper.updateProviderVipEnd();
//        long end = System.currentTimeMillis();
//        System.out.println(("定时任务更新到期会员结束, 更新"+i+"条供应商，耗时：[" + (end-begin) + "]毫秒"));
//    }
//
//    /**
//     * 每日凌晨1点半执行定时任务 更新次数并开通会员:开始时间在当天的供应商会员
//     * (1、将当初暂存的会员等级更新给现有会员等级，2、查看和被查看次数从字典中根据暂存的会员等级匹配更新)
//     * @author ltj
//     * @date 10:42 2021/11/13
//     * @return void
//     **/
//    @Scheduled(cron = "0 30 1 * * ?")
//    //测试没2分钟一次
////    @Scheduled(cron = "0 0/2 * * * ?")
//    @Async
//    public void updateProviderVipStart() {
//        System.out.println("定时任务开始更新会员开始时间在当天的供应商会员......");
//        long begin = System.currentTimeMillis();
//        int i = basicInfoProviderMapper.updateProviderVipStart();
//        long end = System.currentTimeMillis();
//        System.out.println(("定时任务更新会员开始时间在当天的供应商会员结束, 更新"+i+"条供应商，耗时：[" + (end-begin) + "]毫秒"));
//    }
//
//
//    /**
//     * 会员查看和被查看次数 ，每年累加。
//     * 每日凌晨2点执行定时任务 ，如果会员截止时间未到期且从开始时间满一年，将新一年的会员相关次数与上一年的累加（默认一年365天），并将开始时间更新为今天。
//     *
//     * @author ltj
//     * @date 15:42 2021/12/16
//     * @return void
//     **/
//    @Scheduled(cron = "0 0 2 * * ?")
//    //测试没2分钟一次
////    @Scheduled(cron = "0 0/5 * * * ?")
//    @Async
//    public void updateProviderVipEachYear() {
//        System.out.println("定时任务开始更新满一年的会员，次数累加......");
//        long begin = System.currentTimeMillis();
//        int i = basicInfoProviderMapper.updateProviderVipEachYear();
//        long end = System.currentTimeMillis();
//        System.out.println(("定时任务开始更新满一年的会员, 更新"+i+"条供应商，耗时：[" + (end-begin) + "]毫秒"));
//    }
//}