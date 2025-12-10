package chapter6.item35;

public enum Status {

    OK(0),
    ERROR(1),
    UNKNOWN(2),
    TIMEOUT(3),
    RETRY(3);

    private final int code;

    Status(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    public static void main(String[] args) {
        System.out.println(Status.RETRY);
        System.out.println(Status.TIMEOUT);
    }
}
