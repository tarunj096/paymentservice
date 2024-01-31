package com.example.paymentservice.paymentgateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Primary
@Service
public class StripePaymentGateway implements PaymentGateway{

    @Value("${stripe.key.secret}")
    private String stripeApi;
    @Override
    public String generatePaymentLink(String order_id, Long amount,String phoneNo, String emailId) throws StripeException {
        Stripe.apiKey = stripeApi;
//        PaymentLinkCreateParams params =
//                PaymentLinkCreateParams.builder()
//                        .addLineItem(
//                                PaymentLinkCreateParams.LineItem.builder()
//                                        .setPrice("price_1MoC3TLkdIwHu7ixcIbKelAC")
//                                        .setQuantity(1L)
//                                        .build()
//                        )
//                        .build();
//        PaymentLink paymentLink = PaymentLink.create(params);

        Map<String, Object> priceData = new HashMap<>();
        priceData.put("unit_amount", amount);
        priceData.put("currency", "inr");

        Map<String, Object> productData = new HashMap<>();
        productData.put("name", "iPhone");
        //productData.put("quantity", 2);
        priceData.put("product_data", productData);

        Price price = Price.create(priceData);

        //params.put("line_items", );
        Map<String, Object> lineItem1 = new HashMap<>();
        lineItem1.put("price", price.getId());
        lineItem1.put("quantity", 5);

        List<Object> lineItems = new ArrayList<>();
        lineItems.add(lineItem1);

        Map<String, Object> params = new HashMap<>();
        params.put("line_items", lineItems);

        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.toString();
    }
}
