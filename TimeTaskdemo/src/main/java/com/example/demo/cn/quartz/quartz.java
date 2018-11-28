package com.example.demo.cn.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class quartz implements Job {

    /**
     * @param jobExecutionContext 参数是context的上下文
     * @throws JobExecutionException
     */
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //输出当前时间的一个任务
        Date date = new Date();
        //把时间日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年-MM月-dd日 HH时-mm分-ss秒");
        //使用date放在format里就会得到一个String类型的format
        String format = dateFormat.format(date);

        System.out.println("正在进行"+ format);
    }
}
