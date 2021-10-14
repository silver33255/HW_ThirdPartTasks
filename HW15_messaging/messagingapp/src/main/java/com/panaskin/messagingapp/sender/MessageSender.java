package com.panaskin.messagingapp.sender;

import com.panaskin.messagingapp.entity.ErrorMessage;
import com.panaskin.messagingapp.entity.ResultMessage;
import com.panaskin.messagingapp.entity.SumMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Component
public class MessageSender {

    private final Map<UUID, SumMessage> storedMessages = new HashMap<>();

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(SumMessage sumMessage) {
        storedMessages.put(sumMessage.getCorrelationId(), sumMessage);
        jmsTemplate.convertAndSend("message.channel", sumMessage);
    }

    @JmsListener(destination = "result.channel")
    public void receiveResult(@Payload ResultMessage result) {
        checkResult(result);
    }

    public void checkResult(ResultMessage result) {
        if (storedMessages.containsKey(result.getCorrelationId())) {
            log.info("Summ of sended numbers has result " + result.getResult());
        } else {
            redirectToDeathLetterChannel(result);
        };
    }

    public void redirectToDeathLetterChannel(ResultMessage result) {
        ErrorMessage errorMessage = new ErrorMessage("Message with id: "
                + result.getCorrelationId()
                + ", wasn't founded in the sended message store");
        jmsTemplate.convertAndSend("deadletter", errorMessage);
    }
}
