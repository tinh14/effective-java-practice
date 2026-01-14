package chapter12.item87;

import java.io.*;
import java.util.Objects;

public class Name implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * First name. Must be non-null.
     * @serial
     */
    private final String firstName;
    /**
     * Last name. Must be non-null.
     * @serial
     */
    private final String lastName;
    /**
     * Middle name. Can be null.
     * @serial
     */
    private final String middleName;

    public Name(String firstName, String lastName, String middleName) {
        this.firstName = Objects.requireNonNull(firstName);;
        this.lastName = Objects.requireNonNull(lastName);;
        this.middleName = middleName;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String middleName() {
        return middleName;
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        if (firstName == null || lastName == null)
            throw new InvalidObjectException("firstName and lastName must be non-null");
    }
}
