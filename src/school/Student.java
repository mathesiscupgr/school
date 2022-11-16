package school;

public class Student {

    private static final int MAX_SIZE = 20; // max name size
    private static final int CLASSROOM_NAME_LENGTH = 2; // max classroom name size
    private static final String NONE = "<Κενό>"; // κενό όνομα
    private static final String NO_CLASSROOM = "--"; // κενή αίθουσα

    private static int amCounter = 0;
    private final int am;
    private String fistname = NONE; // 1-20
    private String lastname = NONE; // 1-20
    private int age = -1; // 15-18
    private String classroom = NO_CLASSROOM; // XY, π.χ. Χ={Α, Β, Γ}, Υ={1, ..., 9}

    public Student(String firstname, String lastname, int age, String classroom) {
        this.am = ++amCounter;
        if (isNameValid(firstname)) {
            this.fistname = firstname;
        }
        if (isNameValid(lastname)) {
            this.lastname = lastname;
        }
        if (isAgeValid(age)) {
            this.age = age;
        }
        if (isClassRoomValid(classroom)) {
            this.classroom = classroom;
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

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String firstname) {
        this.fistname = isNameValid(firstname) ? firstname.trim() : NONE;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = isNameValid(lastname) ? lastname.trim() : NONE;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = isClassRoomValid(classroom) ? classroom : NO_CLASSROOM;
    }

    @Override
    public String toString() {
        return "Student{" + "am=" + am + ", fistname=" + fistname + ", lastname=" + lastname + ", age=" + age + ", classroom=" + classroom + '}';
    }

    // μέθοδοι εγκυρότητας
    private boolean isAgeValid(int inAge) {
        return inAge >= 15 && inAge <= 18;
    }

    private boolean isNameValid(String name) {
        return name != null && !name.isBlank() && name.length() <= MAX_SIZE;
    }

    private boolean isClassRoomValid(String classRoom) {
        return classRoom != null && !classRoom.isBlank()
                && classRoom.length() == CLASSROOM_NAME_LENGTH
                && (classRoom.startsWith("Α") || classRoom.startsWith("Β") || classRoom.startsWith("Γ"))
                && classRoom.charAt(1) >= '1' && classRoom.charAt(1) <= '9';
    }

}
