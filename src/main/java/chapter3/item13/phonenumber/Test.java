package chapter3.item13.phonenumber;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        PhoneNumber jennyHuynh = new PhoneNumber(707, 867, 309);

        m.put(jennyHuynh, "JennyHuynh");
        System.out.println(m.get(jennyHuynh.clone()));

        System.out.println(jennyHuynh.getClass() == jennyHuynh.clone().getClass());
    }
}
