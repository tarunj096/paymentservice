package com.example.paymentservice.paymentgateway;

public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(String order_id, Long amount,String phoneNo, String emailId) {
        return null;
    }
}
