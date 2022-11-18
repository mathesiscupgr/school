package school;

import school.validation.Validation;

/**
 * Parent class of any person.
 */
public abstract class Person {
    /** The empty string used in case no name has been given. */
    static final String NONE = "<Κενό>";
    /** Person's first name. */
    protected String firstName = NONE;
    /** Person's last name. */
    protected String lastName = NONE;

    /**
     * Creates a new person. Is only called by subclasses.
     * 
     * @param firstName first name
     * @param lastName last name
     * @see school.validation.Validation#isNameValid
     */
    Person(String firstName, String lastName) {
        if (Validation.isNameValid(firstName)) {
            this.firstName = firstName.trim();
        }
        if (Validation.isNameValid(lastName)) {
            this.lastName = lastName.trim();
        }
    }

    /**
     * @return person's first name 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set person's first name. 
     * 
     * @param firstName a new first name
     * @see school.validation.Validation#isNameValid
     */
    public void setFirstName(String firstName) {
        this.firstName = Validation.isNameValid(firstName) ? firstName.trim() : NONE;
    }

    /**
     * @return person's last name 
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Set person's last name. 
     * 
     * @param lastName a new last name
     * @see school.validation.Validation#isNameValid
     */
    public void setLastName(String lastName) {
        this.lastName = Validation.isNameValid(lastName) ? lastName.trim() : NONE;
    }

    @Override
    public String toString() {
        return ", firstName=" + firstName + ", lastName=" + lastName;
    }
}