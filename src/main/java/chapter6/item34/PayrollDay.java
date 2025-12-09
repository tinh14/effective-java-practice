package chapter6.item34;

import static chapter6.item34.PayrollDay.PayType.*;

public enum PayrollDay {

    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY),
    THURSDAY(WEEKDAY), FRIDAY(WEEKDAY),
    SATURDAY(WEEKEND), SUNDAY(WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    int pay(int mins, int payRate) {
        return payType.overtimePay(mins, payRate);
    }

    enum PayType {
        WEEKDAY {
            int overtimePay(int mins, int payRate) {
                return mins <= MINS_PER_SHIFT ? 0 :
                        (mins - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int mins, int payRate) {
                return mins * payRate / 2;
            }
        };

        private static final int MINS_PER_SHIFT = 8 * 60;
        abstract int overtimePay(int mins, int payRate);
    }

    public static void main(String[] args) {
        for (PayrollDay day : values())
            System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1));
    }
}
