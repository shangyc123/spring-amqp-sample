package com.zr.springamqpsample.controller;

import com.zr.springamqpsample.callback.CallBackSender;
import com.zr.springamqpsample.fanout.FanoutSender;
import com.zr.springamqpsample.simple.SimpleSender;
import com.zr.springamqpsample.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rabbit")
public class RabbitmqController {

    @Autowired
    private SimpleSender simpleSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private CallBackSender callBackSender;

    @PostMapping("/hello")
    public void hello() {
        simpleSender.send();
    }

    /**
     * topic exchange类型rabbitmq测试
     */
    @PostMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }

    /**
     * fanout exchange类型rabbitmq测试
     */
    @PostMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }

    @PostMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }
}
