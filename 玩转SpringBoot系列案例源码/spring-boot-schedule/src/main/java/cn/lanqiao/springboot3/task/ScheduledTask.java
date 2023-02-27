package cn.lanqiao.springboot3.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledTask {
    @Scheduled(cron = "0/10 * * * * *")
    public void scheduled1() {
        System.out.println(new Date() + " scheduled1定时任务执行");
    }

    @Scheduled(fixedRate = 5000)
    public void scheduled2() {
        System.out.println(new Date() + " scheduled2定时任务执行");

    }

    @Scheduled(fixedDelay = 5000)
    public void scheduled3() {
        System.out.println(new Date() + " scheduled3定时任务执行");
    }
}
