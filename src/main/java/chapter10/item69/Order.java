package chapter10.item69;

import java.util.Comparator;
import java.util.Optional;

import static chapter10.item69.Order.ShippingState.*;

public final class Order implements Comparable<Order> {
    private final long id;
    private final ShippingState shippingState;

    public enum ShippingState {
        PENDING, DELIVERED
    }

    Order(long id, ShippingState shippingState) {
        if (id < 0)
            throw new IllegalArgumentException("id must not be less than zero");
        this.id = id;
        this.shippingState = shippingState;
    }

    public long id() {
        return id;
    }

    // State-testing method
    public boolean canShip() {
        return PENDING.equals(shippingState);
    }

    // State-dependent method
    public Order ship() {
        if (!canShip())
            throw new OrderException("Cannot deliver");

        return new Order(id, DELIVERED);
    }

    public static Order of(long id) {
        return new Order(id, PENDING);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Order other))
            return false;

        return id == other.id;
    }

    @Override
    public int hashCode() {
        return 31 * Long.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("Order[%d, %s]", id, shippingState);
    }

    @Override
    public int compareTo(Order other) {
        return Long.compare(id, other.id);
    }

    public static void main(String[] args) {
        Order order = Order.of(1);
        System.out.println(order);

        order = order.ship();
        System.out.println(order);

        if (order.canShip()) { // Uses state-testing method to prevent manual exception handling
            order = order.ship();
            System.out.println(order);
        } else {
            System.out.println("Cannot ship");
        }

    }
}
