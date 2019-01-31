package ru.volkov.homework_1_spring_boot.activators;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DirectChannelsActivators {

    @ServiceActivator(inputChannel = "direct_channel_one")
    public void printToConsole(@Payload String messageBody, @Headers Map<String, Object> headersMap) {
        headersMap.forEach((s, o) -> System.out.printf("%s : %s\n", s, o));
        System.out.println(messageBody);
    }
}
