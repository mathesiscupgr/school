package school;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(Person.class); 

    /**
     * Creates a new person. Is only called by subclasses.
     *
     * @param firstName first name
     * @param lastName last name
     * @see school.validation.Validation#isNameValid
     * @throws IllegalArgumentException
     */
    Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
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
     * @throws IllegalArgumentException
     */
    public void setFirstName(String firstName) {
        if (Validation.isNameValid(firstName)) {
            this.firstName = firstName.trim();
        } else {
            LOG.error("Μη έγκυρο όνομα " + firstName);
            throw new IllegalArgumentException("Μη έγκυρο όνομα.");
        }
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
     * @throws IllegalArgumentException
     */
    public void setLastName(String lastName) {
        if (Validation.isNameValid(lastName)) {
            this.lastName = lastName.trim();
        } else {
            LOG.error("Μη έγκυρο επώνυμο " + lastName);
            throw new IllegalArgumentException("Μη έγκυρο επώνυμο.");
        }
    }

    @Override
    public String toString() {
        return ", firstName=" + firstName + ", lastName=" + lastName;
    }
}
