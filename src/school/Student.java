package school;

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

    /**
     * Constructor.
     * 
     * @param firstName student's first name
     * @param lastName student's last name
     * @param age student's age must be between 15 and 18 years old
     * @see school.validation.Validation#isAgeValid(int) 
     */
    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName);
        am = ++amCounter;
        if (Validation.isAgeValid(age)) {
            this.age = age;
        }
    }

    /**
     * Student's AM is calculated automatically.
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
     * @param age student's age.
     * @see school.validation.Validation#isAgeValid(int) 
     */
    public void setAge(int age) {
        this.age = Validation.isAgeValid(age) ? age : -1;
    }

    /**
     * @return the classroom the student is in.
     */
    public ClassRoom getClassRoom() {
        return classRoom;
    }

    /**
     * Set student's classroom.
     * @param classRoom new classroom for student.
     */
    void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
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