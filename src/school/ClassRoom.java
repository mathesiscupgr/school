package school;

import java.util.Arrays;
import java.util.Objects;
import school.validation.Validation;

/**
 * A classroom has a name, a size and contains students.
 */
public class ClassRoom {
    /** Empty classroom name. */
    private static final String NO_CLASSROOM = "--";
    /** Classroom's name. */ 
    private final String name;
    /** Classroom's size. */ 
    private final int size;
    /** Classrooms' students. */ 
    private Student[] students;
    /** Classroom's number of students. */ 
    private int index = 0;

    /**
     * Constructor.
     * 
     * @param name classroom's name
     * @param size classroom's size
     * @see school.validation.Validation#isClassRoomNameValid(java.lang.String) 
     * @see school.validation.Validation#isSizeValid(int)
     * @see school.validation.Validation#CLASSROOM_MAX_SIZE
     * @see NO_CLASSROOM
     */
    public ClassRoom(String name, int size) {
        this.name = Validation.isClassRoomNameValid(name) ? name : NO_CLASSROOM;
        this.size = Validation.isSizeValid(size) ? size : Validation.CLASSROOM_MAX_SIZE;
        this.students = new Student[size];
    }

    /**
     * Constructor. Default size.
     * 
     * @param name classroom's name. 
     * @see school.validation.Validation#CLASSROOM_MAX_SIZE
     */
    public ClassRoom(String name) {
        this(name, Validation.CLASSROOM_MAX_SIZE);
    }

    /**
     * @return classroom's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return classroom's size
     */
    public int getSize() {
        return size;
    }

    /**
     * Add {@code student} to the class. 
     * @param student to add
     */
    public void addStudent(Student student) {
        if (student != null && index < size) {
            students[index++] = student;
            student.setClassRoom(this);
        }
    }

    /**
     * Remove student with {@code am} from this class.
     * @param am student's reg. number.
     */
    public void removeStudent(int am) {
        int indx = contains(students, am);
        if (indx != -1) {
            Student student = students[indx];
            if (remove(indx)) {
                student.setClassRoom(null);
            }
        }
    }

    /**
     * Remove {@code student} from this class.
     * 
     * @param student student to remove from this class
     */
    public void removeStudent(Student student) {
        if (student != null) {
            removeStudent(student.getAm());
            student.setClassRoom(null);
        }
    }

    /**
     * Empty this class.
     */
    public void removeAllStudents() {
        for (int i = 0; i < index; i++) {
            students[i].setClassRoom(null);
        }
        Arrays.fill(students, null);
        index = 0;
    }
    
    /**
     * Checks if the student is in this class.
     * @param am am of student to search for
     * @return {@code true} if the student with the given {@code am} exists in this class.
     */
    public boolean contains(int am) {
        return contains(this.students, am) >= 0;
    }
    
    /**
     * @return the students of this class. 
     */
    public Student[] getStudents() {
        return Arrays.copyOf(students, index);
    }       

    /**
     * Checks to see if {@code am} exists in the list of students
     * @param students array of students
     * @param am am to search for
     * @return {@code true} if {@code am} is found in {@code students}
     */
    private int contains(Student[] students, int am) {
        for (int i = 0; i < index; i++) {
            Student student = students[i];
            if (student != null && student.getAm() == am) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove index {@code indx} from {@code students}
     * @param indx index
     * @return {@code true} if the student was successfully removed.
     */
    private boolean remove(int indx) {
        if (indx < 0 || indx > this.index) return false;
        Student[] newStudents = new Student[this.students.length - 1];
        // αντιγραφή από το 0 μέχρι το students[index-1]
        System.arraycopy(this.students, 0, newStudents, 0, indx);
        // αντιγραφή από students[index+1] μέχρι students[students.length-1]
        System.arraycopy(this.students, indx + 1, newStudents, indx, this.students.length - indx - 1);
        this.students = newStudents;
        index--;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
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
        final ClassRoom other = (ClassRoom) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "ClassRoom{" + "name=" + name + ", size=" + size + ", numOfStudents=" + index + '}';
    }
}