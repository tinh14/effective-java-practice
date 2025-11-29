package chapter5.item27;


import chapter4.item22.paymentmethod.PaymentMethodProvider;
import chapter4.item22.paymentmethod.PaymentRequest;
import chapter4.item22.paymentmethod.PaypalPaymentMethodProvider;

import static chapter4.item22.paymentmethod.PaymentMethodProvider.PaymentMethod.*;

public class Test {
    public static void main(String[] args) {
        PaymentRequest paypal = new PaymentRequest(PAYPAL, 1000.0);

        // Works fine if we provide correctly a payment method and its provider.
        PaypalPaymentMethodProvider provider1 = PaymentMethodProviderRegistry.get(PAYPAL);
        provider1.pay(paypal);
        CodPaymentMethodProvider provider2 = PaymentMethodProviderRegistry.get(COD);
        provider2.specificMethod();

        try {
            // Provides a provider class, help the registry specifies the correct return type
            // without throwing ClassCastException
            PaypalPaymentMethodProvider provider3 = PaymentMethodProviderRegistry
                    .getAs(COD, PaypalPaymentMethodProvider.class);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // ClassCastException
        PaypalPaymentMethodProvider provider4 = PaymentMethodProviderRegistry.get(COD);
    }
}
