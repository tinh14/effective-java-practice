package chapter10.item75;

import java.math.BigDecimal;
import java.util.Objects;

public final class BankAccount implements Comparable<BankAccount>{
    private final String customerId;
    private final BigDecimal balance;

    private BankAccount(String customerId, BigDecimal balance) {
        this.customerId = Objects.requireNonNull(customerId, "Customer id cannot be null");
        this.balance = Objects.requireNonNull(balance, "Balance cannot be null");

        if (this.balance.signum() < 0)
            throw new IllegalArgumentException("Balance must not be negative");
    }

    public static BankAccount of(String customerId, BigDecimal balance) {
        return new BankAccount(customerId, balance);
    }

    public boolean canWithdraw(BigDecimal amount) {
        return this.balance.compareTo(amount) >= 0;
    }

    public BankAccount withdraw(BigDecimal amount) {
        // Programming error
        Objects.requireNonNull(amount, "Amount cannot be null");
        if (amount.signum() <= 0)
            throw new IllegalArgumentException("Amount must be positive");

        // Business error
        if (!canWithdraw(amount))
            throw new InsufficientFundsException(balance, amount);

        return new BankAccount(customerId, this.balance.subtract(amount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof BankAccount other))
            return false;

        return customerId.equals(other.customerId);
    }

    @Override
    public int hashCode() {
        return customerId.hashCode();
    }

    @Override
    public String toString() {
        return String.format("BankAccount[customerId=%s, balance=%s]", customerId, balance);
    }

    @Override
    public int compareTo(BankAccount other) {
        return this.customerId.compareTo(other.customerId);
    }

    public static void main(String[] args) {
        final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

        BankAccount bankAccount = BankAccount.of("001", ONE_HUNDRED);
        System.out.println(bankAccount);

        if (bankAccount.canWithdraw(ONE_HUNDRED)) {
            bankAccount = bankAccount.withdraw(ONE_HUNDRED);
            System.out.println(bankAccount);
        } else {
            System.out.println("You're broke");
        }

        try {
            bankAccount.withdraw(ONE_HUNDRED); // Throws an InsufficientFundsException
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }

        BankAccount.of("002", BigDecimal.ONE.negate()); // Throws an IllegalArgumentException
    }
}
