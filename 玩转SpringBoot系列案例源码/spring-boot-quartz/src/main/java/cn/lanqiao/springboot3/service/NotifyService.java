package cn.lanqiao.springboot3.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotifyService {

    public void sendMessageToUser(){
        System.out.println(new Date() + "通知方法被定时任务调用，开始发送通知");
        // to do something
        // 可以在该方法里写上逻辑代码，定时任务会定时调用该方法
    }
}
