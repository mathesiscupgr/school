package school;

import school.validation.Validation;
import static school.validation.Validation.isAgeValid;

public class Student extends Person {

    private static int amCounter = 0;
    private final int am;
    private int age = -1; // 15-18
    private ClassRoom classRoom;

    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName);
        this.am = ++amCounter;
        if (isAgeValid(age)) {
            this.age = age;
        }
    }

    public int getAm() {
        return am;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (isAgeValid(age)) {
            this.age = age;
        }
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.am;
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
