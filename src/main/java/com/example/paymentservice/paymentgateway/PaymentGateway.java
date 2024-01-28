package com.example.paymentservice.paymentgateway;

import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service
public interface PaymentGateway {
    String generatePaymentLink(String order_id, Long amount,String phoneNo, String emailId) throws RazorpayException;

}
