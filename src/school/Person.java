package school;

import school.validation.Validation;

public abstract class Person {

    protected static final String NONE = "<Κενό>"; // κενό όνομα
    protected String fistName = NONE; // 1-20
    protected String lastName = NONE; // 1-20

    public Person(String firstName, String lastName) {
        if (Validation.isNameValid(firstName)) {
            this.fistName = firstName;
        }
        if (Validation.isNameValid(lastName)) {
            this.lastName = lastName;
        }
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String firstName) {
        this.fistName = Validation.isNameValid(firstName) ? firstName.trim() : NONE;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Validation.isNameValid(lastName) ? lastName.trim() : NONE;
    }

    @Override
    public String toString() {
        return ", fistName=" + fistName + ", lastName=" + lastName;
    }

}
