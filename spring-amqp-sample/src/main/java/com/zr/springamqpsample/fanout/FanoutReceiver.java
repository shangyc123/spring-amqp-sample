package com.zr.springamqpsample.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverA  : " + msg);
    }
}


@Component
@RabbitListener(queues = "fanout.B")
class FanoutReceiverB {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverB  : " + msg);
    }

}


@Component
@RabbitListener(queues = "fanout.C")
class FanoutReceiverC {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverC  : " + msg);
    }

}