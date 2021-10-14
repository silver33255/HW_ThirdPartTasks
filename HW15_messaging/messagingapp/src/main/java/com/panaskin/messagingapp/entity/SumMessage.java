package com.panaskin.messagingapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;


@NoArgsConstructor
@Setter
@Getter
@ToString
public class SumMessage implements Serializable {
    private UUID correlationId;
    private int firstNum;
    private int secondNum;

    public SumMessage(int first, int second) {
        this.firstNum = first;
        this.secondNum = second;
        correlationId = UUID.randomUUID();
    }
}
