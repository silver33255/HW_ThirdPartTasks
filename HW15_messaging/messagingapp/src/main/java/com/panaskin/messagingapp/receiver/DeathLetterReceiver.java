package com.panaskin.messagingapp.receiver;

import com.panaskin.messagingapp.entity.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class DeathLetterReceiver {
    @JmsListener(destination = "deadletter")
    public void receiveMessage(@Payload ErrorMessage errorMessage) {
        log.info(errorMessage.getMessage());
    }
}
