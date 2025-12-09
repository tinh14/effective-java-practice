package chapter6.item34;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private static final Map<String, Operation> stringOperations =
            Stream.of(values())
                    .collect(Collectors.toMap(
                            Operation::toString,
                            Function.identity()
                    ));

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringOperations.get(symbol));
    }

    public static Operation inverse(Operation operation) {
        return switch(operation) {
            case PLUS -> MINUS;
            case MINUS -> PLUS;
            case TIMES -> DIVIDE;
            case DIVIDE -> TIMES;
        };
    }

    public static void main(String[] args) {
        double x = 1;
        double y = 2;
        for (Operation op : Operation.values())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));

        Operation.fromString("/").ifPresentOrElse(
                operation -> System.out.println(operation.apply(1, 0)),
                () -> System.out.println("Unsupported operation"));

        Operation.fromString("%").ifPresentOrElse(
                operation -> System.out.println(operation.apply(1, 0)),
                () -> System.out.println("Unsupported operation"));
        System.out.println("Inverse of addition symbol is " + Operation.inverse(PLUS));
    }
}
