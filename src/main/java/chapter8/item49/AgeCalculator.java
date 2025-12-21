package chapter8.item49;

import java.time.LocalDate;
import java.time.Period;

/**
 * A utility class for calculating age from a given birthday
 */
public class AgeCalculator {

    private AgeCalculator(){
        throw new AssertionError("Cannot instantiate AgeCalculator");
    }

    /**
     * Returns the age calculated from the year of birth.
     *
     * @param yearOfBirth the year of birth
     * @return the age in years
     * @throws IllegalArgumentException if yearOfBirth is greater than the current year
     */
    public static int from(int yearOfBirth){
        LocalDate now = LocalDate.now();
        LocalDate birthDay = LocalDate.of(yearOfBirth, 1, 1);

        if (birthDay.isAfter(now))
            throw new IllegalArgumentException("Year of birth must be less than or equal to current year!");

        return Period.between(birthDay, now).getYears();
    }

    public static void main(String[] args) {
        System.out.println(AgeCalculator.from(2002));
        System.out.println(AgeCalculator.from(2030));
    }
}
