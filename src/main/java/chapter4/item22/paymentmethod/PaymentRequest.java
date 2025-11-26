package chapter4.item22.paymentmethod;

import java.util.Comparator;
import java.util.Objects;

import static chapter4.item22.paymentmethod.PaymentMethodProvider.PaymentMethod;

// This class as immutable.
// Both primitive wrapper classes and enums are immutable. So, it's safe to return them directly.
// If the class contains any fields that mutable,
// creates a defensive copy for them before setting and after returning.
public final class PaymentRequest implements Comparable<PaymentRequest> {
    private final PaymentMethod method;
    private final Double amount;

    public PaymentRequest(PaymentMethod method, Double amount) {
        Objects.requireNonNull(method);
        Objects.requireNonNull(amount);
        this.method = method;
        this.amount = amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public Double getAmount() {
        return amount;
    }

    // Returning a new object with a new state for each state changing operations.
    public PaymentRequest withMethod(PaymentMethod method) {
        return new PaymentRequest(method, amount);
    }

    public PaymentRequest withAmount(Double amount) {
        return new PaymentRequest(method, amount);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof PaymentRequest p))
            return false;

        return p.method.equals(method) && Double.compare(p.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(method) ^ Objects.hashCode(amount);
    }

    @Override
    public int compareTo(PaymentRequest other) {
        return Comparator
                .comparingDouble((PaymentRequest p) -> p.amount)
                .compare(this, other);
    }
}
