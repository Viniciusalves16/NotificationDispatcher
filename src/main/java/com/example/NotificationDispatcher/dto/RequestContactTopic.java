package com.example.NotificationDispatcher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RequestContactTopic {
    @JsonProperty("paymentId")
    private String paymentId;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("clientName")
    private String clientName;

    @JsonProperty("email")
    private String email;

    public RequestContactTopic() {
    }

    public RequestContactTopic(String paymentId, double amount, String paymentMethod, String clientName, String clientEmail) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.clientName = clientName;
        this.email = clientEmail;
    }


}