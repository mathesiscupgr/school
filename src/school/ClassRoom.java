package school;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import school.validation.Validation;

/**
 * A classroom has a name, a size and contains students.
 */
public class ClassRoom {

    /**
     * Empty classroom name.
     */
    private static final String NO_CLASSROOM = "--";
    /**
     * Classroom's name.
     */
    private final String name;
    /**
     * Classroom's size.
     */
    private final int size;
    /**
     * Classrooms' students.
     */
    private Set<Student> students;

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
        this.students = new HashSet<>(size);
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
     *
     * @param student to add
     */
    public void addStudent(Student student) {
        if (student != null && students.size() < size) {
            students.add(student);
            student.setClassRoom(this);
        }
    }

    /**
     * Remove student with {@code am} from this class.
     *
     * @param am student's reg. number.
     */
    public void removeStudent(int am) {
        Student student = contains(am);
        if (removeStudent(student)) {
            student.setClassRoom(null);
        }
    }

    /**
     * Remove {@code student} from this class.
     *
     * @param student student to remove from this class
     * @return {@code true} if student was removed successfully
     */
    public boolean removeStudent(Student student) {
        boolean removed = false;
        if (student != null) {
            removed = students.remove(student);
            if (removed) {
                student.setClassRoom(null);
            }
        }
        return removed;
    }

    /**
     * Empty this class.
     */
    public void removeAllStudents() {
        for (Student student : students) {
            student.setClassRoom(null);

        }
    }

    /**
     * Checks if the student is in this class.
     *
     * @param am am of student to search for
     * @return the student with {@code am} if found or {@code null}
     */
    public Student contains(int am) {
        for (Student student : students) {
            if (student.getAm() == am) {
                return student;
            }
        }
        return null;
    }

    /**
     * @return the students of this class.
     */
    public Collection<Student> getStudents() {
        return Collections.unmodifiableCollection(students);
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
        return "ClassRoom{" + "name=" + name + ", size=" + size + ", numOfStudents=" + students.size() + '}';
    }
}
