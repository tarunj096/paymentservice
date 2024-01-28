package com.example.paymentservice.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDto {
    private String order_id;
     private Long amount;
     private String phoneNo;
     private String emailId;
}
