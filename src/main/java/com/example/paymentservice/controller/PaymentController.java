package com.example.paymentservice.controller;

import com.example.paymentservice.dto.InitiatePaymentRequestDto;
import com.example.paymentservice.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) throws RazorpayException {
        return paymentService.initiatePayment(requestDto.getOrder_id(),requestDto.getAmount(),requestDto.getPhoneNo(),requestDto.getEmailId());
    }
}
