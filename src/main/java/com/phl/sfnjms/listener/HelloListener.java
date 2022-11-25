package com.phl.sfnjms.listener;

import com.phl.sfnjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

import static com.phl.sfnjms.config.JmsConfig.MY_QUEUE;

@Component
public class HelloListener {

    @JmsListener(destination = MY_QUEUE)
    public void listen(
        @Payload HelloWorldMessage helloWorldMessage,
        @Headers MessageHeaders headers,
        Message message
    ) {
        System.out.println("🟢 I've got a message!");
        System.out.println(helloWorldMessage);

        headers.computeIfPresent("jms_redelivered", (k1, isRedelivery) -> {
            headers.computeIfPresent("JMSXDeliveryCount", (k2, count) -> {
                System.out.println("Redelivery count: " + count);
                return count;
            });
            return isRedelivery;
        });

        System.out.println("\n\n");
//        throw new RuntimeException("XXX");
    }
}
