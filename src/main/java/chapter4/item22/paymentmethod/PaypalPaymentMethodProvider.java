package chapter4.item22.paymentmethod;

public final class PaypalPaymentMethodProvider extends AbstractPaymentMethodProvider
        implements PaymentMethodProvider {

    @Override
    public boolean supports(PaymentMethod method) {
        return PaymentMethod.PAYPAL.equals(method);
    }

    @Override
    public void doPay(PaymentRequest request) {
        System.out.println("Pay successfully");
    }
}
