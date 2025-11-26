package chapter4.item22.paymentmethod;

import static chapter4.item22.paymentmethod.PaymentMethodProvider.PaymentMethod;

public class Test {
    public static void main(String[] args) {
        PaymentRequest paypal = new PaymentRequest(PaymentMethod.PAYPAL, 1000.0);
        PaymentRequest paypal2 = paypal.withAmount(999.9);
        PaymentRequest cod = paypal.withMethod(PaymentMethod.COD);

        PaymentMethodProvider provider = new PaypalPaymentMethodProvider();

        System.out.println("--COMPARING AMOUNT OF MONEY--");
        System.out.println("PAYPAL AND COD: " + paypal.compareTo(cod));
        System.out.println("PAYPAL AND PAYPAL2: " + paypal.compareTo(paypal2));
        System.out.println("--PAYING--");
        System.out.print("PAYPAL: ");
        provider.pay(paypal);
        System.out.print("COD: ");
        provider.pay(cod);
    }
}
