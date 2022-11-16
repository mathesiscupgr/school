package school;

public class Student {

    private static final int MAX_SIZE = 20; // max name size
    private static final String NONE = "<Κενό>"; // κενό όνομα

    private static int amCounter = 0;
    private final int am;
    private String fistName = NONE; // 1-20
    private String lastName = NONE; // 1-20
    private int age = -1; // 15-18
    private ClassRoom classRoom; 

    public Student(String firstName, String lastName, int age) {
        this.am = ++amCounter;
        if (isNameValid(firstName)) {
            this.fistName = firstName;
        }
        if (isNameValid(lastName)) {
            this.lastName = lastName;
        }
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

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String firstName) {
        this.fistName = isNameValid(firstName) ? firstName.trim() : NONE;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = isNameValid(lastName) ? lastName.trim() : NONE;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Student{" + "am=" + am + ", fistName=" + fistName + ", lastName=" + lastName + ", age=" + age + ", classRoom=" + classRoom + '}';
    }

    // μέθοδοι εγκυρότητας
    private boolean isAgeValid(int inAge) {
        return inAge >= 15 && inAge <= 18;
    }

    private boolean isNameValid(String name) {
        return name != null && !name.isBlank() && name.length() <= MAX_SIZE;
    }
}
