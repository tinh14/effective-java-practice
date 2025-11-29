package chapter5.item27;

import chapter4.item22.paymentmethod.AbstractPaymentMethodProvider;
import chapter4.item22.paymentmethod.PaymentMethodProvider;
import chapter4.item22.paymentmethod.PaymentRequest;

import static chapter4.item22.paymentmethod.PaymentMethodProvider.PaymentMethod.COD;

public class CodPaymentMethodProvider extends AbstractPaymentMethodProvider implements PaymentMethodProvider {

    @Override
    public boolean supports(PaymentMethod method) {
        return COD.equals(method);
    }

    @Override
    protected void doPay(PaymentRequest request) {
        System.out.println("Pay successfully");
    }

    public void specificMethod() {
        System.out.println("COD: Pay successfully");
    }
}
