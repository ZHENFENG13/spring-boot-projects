package cn.lanqiao.springboot3.task;

import cn.lanqiao.springboot3.service.NotifyService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class QuartzTask extends QuartzJobBean {
    @Autowired
    private NotifyService notifyService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println(new Date() + " QuartzTask定时任务执行");
        notifyService.sendMessageToUser();
    }

}
