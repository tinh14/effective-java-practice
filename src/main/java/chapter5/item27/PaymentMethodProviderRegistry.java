package chapter5.item27;

import chapter4.item22.paymentmethod.PaymentMethodProvider;
import chapter4.item22.paymentmethod.PaypalPaymentMethodProvider;

import java.util.HashMap;
import java.util.Map;

import static chapter4.item22.paymentmethod.PaymentMethodProvider.PaymentMethod;
import static chapter4.item22.paymentmethod.PaymentMethodProvider.PaymentMethod.*;

public final class PaymentMethodProviderRegistry {

    private static final Map<PaymentMethod, PaymentMethodProvider> providers = new HashMap<>();

    static {
        providers.put(PAYPAL, new PaypalPaymentMethodProvider());
        providers.put(COD, new CodPaymentMethodProvider());
    }

    private PaymentMethodProviderRegistry(){}


    public static <T extends PaymentMethodProvider> T get(PaymentMethod method) {

        PaymentMethodProvider provider = providers.get(method);
        if (provider == null)
            throw new IllegalArgumentException("Unsupported payment method");
        // Cannot eliminate an unchecked cast warning.
        // We need to suppress the warning with @SuppressWarnings("unchecked") annotation.

        @SuppressWarnings("unchecked")
        T result = (T) provider;

        return result;
    }

    // Better approach without suppressing warnings.
    public static <T extends PaymentMethodProvider> T getAs(PaymentMethod method, Class<T> type) {
        PaymentMethodProvider provider = providers.get(method);
        // If the registry doesn't have an instance of the requested provider, it will return null.
        // This ensures the requested provider exists and matches the expected type.
        if (!type.isInstance(provider))
            throw new IllegalArgumentException("Unsupported payment method");
        return type.cast(provider);
    }
}
