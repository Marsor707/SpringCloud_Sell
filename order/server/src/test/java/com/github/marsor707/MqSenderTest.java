package com.github.marsor707;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
@Component
public class MqSenderTest extends OrderServerApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now" + new Date());
    }

    @Test
    public void sendOrderComputer() {
        amqpTemplate.convertAndSend("myOrder", "computer", "now" + new Date());
    }

    @Test
    public void sendOrderFruit() {
        amqpTemplate.convertAndSend("myOrder", "fruit", "now" + new Date());
    }
}
