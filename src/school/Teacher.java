package school;

import java.util.Arrays;
import java.util.Objects;
import school.validation.Validation;

/**
 * A school teacher.
 * 
 * @author MyMacBook
 */
public class Teacher extends Person {
    /** Max number of lessons a teacher can teach in the school. */
    private static final int MAX_LESSONS = 3;
    /** No ID number. */
    private String id = NONE;  // ΑΔΤ
    /** Lessons the teacher can teach. */
    private String[] lessons;
    /** How many lessons the teacher teaches. */
    private int index = 0;

    /**
     * Constructor.
     * 
     * @param id teacher's ID number
     * @param firstName teacher's first name
     * @param lastName teacher's last name
     * @param lessons a teacher can teach up to 3 lessons
     * @see MAX_LESSONS
     * @see school.validation.Validation#isIdValid(java.lang.String) 
     */
    public Teacher(String id, String firstName, String lastName, String... lessons) {
        super(firstName, lastName);
        if (Validation.isIdValid(id)) {
            this.id = id;
        }
        if (lessons != null && lessons.length > 0) { // αντιγράφουμε μόνο τα 3 πρώτα μαθήματα
            int length = lessons.length > MAX_LESSONS ? MAX_LESSONS : lessons.length;
            this.lessons = Arrays.copyOfRange(lessons, 0, length);
        } else {
            this.lessons = new String[MAX_LESSONS];
        }
    }

    /**
     * @return the teacher's ID number
     */
    public String getId() {
        return id;
    }

    /**
     * Set the teacher's id.
     * 
     * @param id the new ID number. It shouldn't be null.
     * @see school.validation.Validation#isIdValid(java.lang.String)
     */
    public void setId(String id) {
        this.id = Validation.isIdValid(id) ? id : NONE;
    }

    /**
     * Add a new lesson that this teacher teaches. If the number of lessons
     * that a teacher can teach is reached, the lesson is ignored.
     * @param lesson lesson to add
     */
    public void addLesson(String lesson) {
        if (lesson != null && index < MAX_LESSONS) {
            lessons[index++] = lesson;
        }
    }
    /**
     * Remove the lesson from the lessons that this teacher teaches. If the 
     * lesson is not teached by this teacher, it is ignored.
     * @param lesson lesson to remove
     */
    public void removeLesson(String lesson) {
        if (lesson != null) {
            remove(contains(lessons, lesson));
        }
    }
    
    /**
     * Checks if the teacher teaches this lesson.
     * @param les lesson to search for
     * @return {@code true} if the teacher teaches this lesson.
     */
    public boolean contains(String les) {
        return les == null ? false : contains(this.lessons, les) >= 0;
    }
    
    /**
     * @return the lessons that this teacher teaches. 
     */
    public String[] getLessons() {
        return Arrays.copyOf(lessons, index);
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Teacher other = (Teacher) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + super.toString() + ", lessons=" + Arrays.toString(lessons) + '}';
    }    
    
    /**
     * Checks to see if {@code les} exists in the list of lessons
     * @param lessons array of lessons
     * @param les lesson to search for
     * @return {@code true} if {@code les} is found in {@code lessons}
     */
    private int contains(String[] lessons, String les) {
        for (int i = 0; i < index; i++) {
            String lesson = lessons[i];
            if (lesson != null && lesson.equalsIgnoreCase(les)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove index {@code indx} from {@code lessons}
     * @param indx index
     * @return {@code true} if the lesson was successfully removed.
     */
    private boolean remove(int indx) {
        if (indx < 0 || indx >= this.lessons.length) {
            return false;
        }
        String[] newLessons = new String[this.lessons.length - 1];
        // αντιγραφή από το 0 μέχρι το lessons[index-1]
        System.arraycopy(this.lessons, 0, newLessons, 0, indx);
        // αντιγραφή από lessons[index+1] μέχρι lessons[lessons.length-1]
        System.arraycopy(this.lessons, indx + 1, newLessons, indx, this.lessons.length - indx - 1);
        this.lessons = newLessons;
        index--;
        return true;
    }
}