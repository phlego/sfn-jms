package com.phl.sfnjms.sender;

import com.phl.sfnjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.phl.sfnjms.config.JmsConfig.MY_QUEUE;

@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        System.out.println("I'm sending a message!");

        HelloWorldMessage message = new HelloWorldMessage(UUID.randomUUID(), "Hallo Welt");
        jmsTemplate.convertAndSend(MY_QUEUE, message);

        System.out.println("✅ Message sent!");
    }
}
