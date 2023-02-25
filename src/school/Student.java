package school;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import school.validation.Validation;

/**
 * A student of the school.
 */
public class Student extends Person {
    /** Automatic counter to set AM. */
    private static int amCounter = 0;
    /** Student's registration number (AM).*/
    private final int am;
    /** Student's age. -1 means age has not been set. */
    private int age = -1;  // 15-18
    /** Student's classroom. */
    private ClassRoom classRoom;
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(Student.class);      

    /**
     * Constructor.
     *
     * @param firstName student's first name
     * @param lastName student's last name
     * @param age student's age must be between 15 and 18 years old
     * @see school.validation.Validation#isAgeValid(int)
     * @throws IllegalArgumentException
     */
    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName);
        am = ++amCounter;
        if (LOG.isDebugEnabled()) {
            LOG.debug("AM=" + am);
        }
        setAge(age);
    }

    /**
     * Student's AM is calculated automatically.
     *
     * @return student's AM
     */
    public int getAm() {
        return am;
    }

    /**
     * @return student's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set student's age. It increases every year.
     *
     * @param age student's age.
     * @see school.validation.Validation#isAgeValid(int)
     * @throws IllegalArgumentException
     */
    public void setAge(int age) {
        if (Validation.isAgeValid(age)) {
            this.age = age;
        } else {
            LOG.error("Μη έγκυρη ηλικία " + age + ". Η ηλικία πρέπει να είναι μεταξύ 15 και 18");
            throw new IllegalArgumentException("Η ηλικία πρέπει να είναι μεταξύ 15 και 18");
        }
    }

    /**
     * @return the classroom the student is in.
     */
    public ClassRoom getClassRoom() {
        return classRoom;
    }

    /**
     * Set student's classroom.
     *
     * @param classRoom new classroom for student.
     */
    void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
        if (LOG.isDebugEnabled()) {
            LOG.debug("Student with am=" + am + " was added to classroom " + classRoom);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.am;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return this.am == other.am;
    }

    @Override
    public String toString() {
        return "Student{" + "am=" + am + super.toString() + ", age=" + age + ", classRoom=" + classRoom + '}';
    }
}
