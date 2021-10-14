package com.panaskin.messagingapp.receiver;
import com.panaskin.messagingapp.entity.SumMessage;
import com.panaskin.messagingapp.entity.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class MessageReceiver {
    private final List<SumMessage> messagePool = new ArrayList<>();
    private final int POOLING_SIZE = 10;

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "message.channel")
    public void receiveMessage(@Payload SumMessage sumMessage){
        messagePool.add(sumMessage);
        if (messagePool.size() == POOLING_SIZE) {
            for (SumMessage mess : messagePool) {
                sendMessageResult(mess);
            }
            messagePool.clear();
        }
    }

    public void sendMessageResult(SumMessage sumMessage) {
        jmsTemplate.convertAndSend("result.channel", calculateResultMessage(sumMessage));
    }

    private ResultMessage calculateResultMessage(SumMessage sumMessage) {
        if (randomWithProbability(4)) {
            sumMessage.setCorrelationId(UUID.randomUUID());
        }
        ResultMessage resultMessage = new ResultMessage(sumMessage.getFirstNum(), sumMessage.getSecondNum());
        resultMessage.setCorrelationId(sumMessage.getCorrelationId());
        return resultMessage;
    }

    private boolean randomWithProbability(int percent){
        return new Random().nextInt((percent - 0) - 0) == 1;
    }
}