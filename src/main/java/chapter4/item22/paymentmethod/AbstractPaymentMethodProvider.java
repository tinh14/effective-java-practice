package chapter4.item22.paymentmethod;

// A skeletal implementation
public abstract class AbstractPaymentMethodProvider implements PaymentMethodProvider {

    public void pay(PaymentRequest request) {
        if (!supports(request.getMethod()))
            throw new IllegalArgumentException("Unsupported payment method");

        doPay(request);
    }

    protected abstract void doPay(PaymentRequest request);
}
