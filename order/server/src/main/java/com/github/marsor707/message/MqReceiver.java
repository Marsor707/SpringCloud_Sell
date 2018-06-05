package com.github.marsor707.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
@Slf4j
@Component
public class MqReceiver {

    //1.直接写队列名，需要在rabbitmq中事先创建好队列 @RabbitListener(queues = "myQueue")
    //2.动态创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3.创建并绑定exchange
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("receive: {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computer"),
            key = "computer",
            exchange = @Exchange("myOrder")
    ))
    public void processComputer(String message) {
        log.info("computer receive: {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myFruit"),
            key = "fruit",
            exchange = @Exchange("myOrder")
    ))
    public void processFruit(String message) {
        log.info("fruit receive: {}", message);
    }
}
