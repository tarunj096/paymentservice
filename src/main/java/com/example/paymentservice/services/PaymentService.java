package com.example.paymentservice.services;

import com.example.paymentservice.paymentgateway.PaymentGateway;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    public String initiatePayment(String order_id, Long amount,String phoneNo, String emailId) throws RazorpayException, StripeException {
        //amount = 10000L;

        return paymentGateway.generatePaymentLink(order_id,amount,phoneNo,emailId);
    }
}
