package com.example.paymentservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripeWebhook")

public class StripeWebhookController {
    @PostMapping
    public void recieveWebhook() {
        System.out.println("Webhook recieved");
    }
}
