package chapter3.item10.caseinsensitivestring;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {


        System.out.println("SmartCaseInsensitiveString and String:");
        CaseInsensitiveString scis = new SmartCaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println("SCIS equals to String: " + scis.equals(s)); // false
        System.out.println("String equals to SCIS: " + s.equals(scis)); // false

        System.out.println("DumbCaseInsensitiveString and String:");
        CaseInsensitiveString dcis = new DumbCaseInsensitiveString("Polish");
        System.out.println("DCIS equals to String: " + dcis.equals(s)); // true
        System.out.println("String equals to DCIS: " + s.equals(dcis)); // false

        System.out.println("SmartCaseInsensitiveString and SmartCaseInsensitiveString:");
        CaseInsensitiveString scis1 = new SmartCaseInsensitiveString("Polish");
        CaseInsensitiveString scis2 = new SmartCaseInsensitiveString("polish");
        System.out.println("scis1 equals to scis2: " + scis1.equals(scis2)); // true
        System.out.println("scis2 equals to scis1: " + scis2.equals(scis1)); // true

        System.out.println("DumbCaseInsensitiveString and DumbCaseInsensitiveString:");
        CaseInsensitiveString dscis1 = new DumbCaseInsensitiveString("Polish");
        CaseInsensitiveString dscis2 = new DumbCaseInsensitiveString("polish");
        System.out.println("dscis1 equals to dscis2: " + dscis1.equals(dscis2)); // true
        System.out.println("dscis2 equals to dscis1: " + dscis2.equals(dscis1)); // true

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(dcis);
        System.out.println("List contains dcis: " + list.contains(s));

        List<String> strList = new ArrayList<>();
        strList.add(s);
        System.out.println("String List contains dcis: " + strList.contains(dcis));

    }
}
