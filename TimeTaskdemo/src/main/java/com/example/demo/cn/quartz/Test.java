package com.example.demo.cn.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        //第一步需要一个调度器（Scheduler），从工厂中获取调度实例（默认：实例化 new StdSchedulerFactory）
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        //第二步任务实例（JobDateil）
        JobDetail build = JobBuilder.newJob(quartz.class)//加载任务类
                .withIdentity("Job1", "group1")//参数一：任务名称，参数二：任务组的名称
                .build();
        //第三步 触发器（Trigger）
       /* SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("Trigger", "Trigger")//参数一：触发器的名称，参数二：触发器组的名称
                .startNow() //马上启动触发器
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(2))
                .build();*/
        //Cron表达式
        CronTrigger trigger = TriggerBuilder.newTrigger().
                withIdentity("trigger10","group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/1 0-19 11  * * ?"))
                .build();
        //第四部调度器关联任务和触发器，按照规定的条件执行
        Date date = defaultScheduler.scheduleJob(build, trigger);
        //启动
        defaultScheduler.start();

        Thread.sleep(10000);
        defaultScheduler.shutdown(true);

    }
}
