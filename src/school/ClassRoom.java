package school;

import java.util.Arrays;

public class ClassRoom {
    private static final int DEFAULT_SIZE = 30;
    private static final String NO_CLASSROOM = "--"; // κενή αίθουσα
    private static final int CLASSROOM_NAME_LENGTH = 2; // max classRoom name length    
    
    private final String name; // XY, π.χ. Χ={Α, Β, Γ}, Υ={1, ..., 9}
    private final int size;
    private Student[] students;
    
    private int index = 0;

    public ClassRoom(String name, int size) {
        this.name = isClassRoomNameValid(name) ? name : NO_CLASSROOM;
        this.size = isSizeValid(size) ? size : DEFAULT_SIZE;
        this.students = new Student[size];
    }
    
    public ClassRoom(String name) {
        this(name, DEFAULT_SIZE);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ClassRoom{" + "name=" + name + ", size=" + size + ", numOfStudents=" + index + '}';
    }
    
    public void addStudent(Student student){
        if (student != null && index < size) {
            students[index++] = student;
            student.setClassRoom(this);
        }
    }
    
    public void removeStudent(Student student) {
        if (student != null) {
            removeStudent(student.getAm());
            student.setClassRoom(null);
        }
    }

    public void removeStudent(int am) {
        int indx = contains(students, am);
        if (indx != -1) {
            Student student = students[indx];
            if (remove(indx)) {
                student.setClassRoom(null);
            }
        }
    }
    
    public void removeAllStudents() {
        for (Student student : students) {
            student.setClassRoom(null);
        }
        Arrays.fill(students, null);
        index = 0;
    }
    
    private boolean remove(int indx) {
        if (indx < 0 || indx >= this.students.length) return false;
        Student[] newStudents = new Student[this.students.length - 1];
        System.arraycopy(this.students, 0, newStudents, 0, indx);
        System.arraycopy(this.students, indx+1, newStudents, indx, this.students.length - indx - 1);
        this.students = newStudents;
        index--;
        return true;
    }

    private int contains(Student[] students, int am) {
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student.getAm() == am) {
                return i;
            }
        }
        return -1;
    }
    
    // μέθοδοι εγκυρότητας
    private boolean isSizeValid(int inSize) {
        return inSize >= 20 && inSize <= DEFAULT_SIZE;
    }
    
    private boolean isClassRoomNameValid(String classRoom) {
        return classRoom != null && !classRoom.isBlank()
                && classRoom.length() == CLASSROOM_NAME_LENGTH
                && (classRoom.startsWith("Α") || classRoom.startsWith("Β") || classRoom.startsWith("Γ"))
                && classRoom.charAt(1) >= '1' && classRoom.charAt(1) <= '9';
    }    
    
}
