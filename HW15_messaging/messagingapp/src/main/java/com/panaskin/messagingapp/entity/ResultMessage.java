package com.panaskin.messagingapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class ResultMessage implements Serializable {
    private UUID correlationId;
    private int result;

    public ResultMessage(int firstNumber, int secondNumber) {
        result = sum(firstNumber, secondNumber);
    }

    private int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
