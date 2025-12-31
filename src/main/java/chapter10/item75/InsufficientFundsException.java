package chapter10.item75;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Thrown when an account does not have enough balance to complete an operation
 */
public class InsufficientFundsException extends RuntimeException {
    private final BigDecimal balance;
    private final BigDecimal amount;

    /**
     * Constructs an {@code InsufficientFundsException}.
     *
     * @param balance the current balance of the account
     * @param amount the amount of attempted transaction
     * @throws NullPointerException if {@code balance} is {@code null} or {@code amount} is {@code null}
     */
    public InsufficientFundsException(BigDecimal balance, BigDecimal amount) {
        super(String.format("Balance: %s, Amount: %s",
                Objects.requireNonNull(balance), Objects.requireNonNull(amount)));

        this.balance = balance;
        this.amount = amount;
    }

    public BigDecimal balance() {
        return balance;
    }

    public BigDecimal amount() {
        return amount;
    }
}
