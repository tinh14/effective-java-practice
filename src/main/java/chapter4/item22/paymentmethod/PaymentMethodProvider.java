package chapter4.item22.paymentmethod;

public interface PaymentMethodProvider {

    // These constants are strongly tied to payment method providers.
    enum PaymentMethod {
        PAYPAL,
        COD,
    }

    boolean supports(PaymentMethod method);
    void pay(PaymentRequest request);
}
