package school;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import school.validation.Validation;

/**
 * A school teacher.
 */
public class Teacher extends Person {
    /** Max number of lessons a teacher can teach in the school. */
    private static final int MAX_LESSONS = 3;
    /** No ID number. */
    private String id = NONE;  // ΑΔΤ
    /** Lessons the teacher can teach. */
    private final Set<String> lessons;
    /** Logger. */
    private static final Logger LOG = LogManager.getLogger(Teacher.class);    

    /**
     * Constructor.
     *
     * @param id teacher's ID number
     * @param firstName teacher's first name
     * @param lastName teacher's last name
     * @param lessons a teacher can teach up to 3 lessons
     * @see MAX_LESSONS
     * @see school.validation.Validation#isIdValid(java.lang.String)
     * @throws IllegalArgumentException
     */
    public Teacher(String id, String firstName, String lastName, String... lessons) {
        super(firstName, lastName);
        setId(id);
        if (lessons != null && lessons.length > 0) { // αντιγράφουμε μόνο τα 3 πρώτα μαθήματα
            if (LOG.isInfoEnabled()) {
                LOG.info("More lessons (" + lessons.length +") were given than the maximum number of lessons allowed (" + MAX_LESSONS + "). Only the first " + MAX_LESSONS + " will be assigned to teacher with ID=" + this.id);
            }
            int length = lessons.length > MAX_LESSONS ? MAX_LESSONS : lessons.length;
            this.lessons = new HashSet<>(Arrays.asList(Arrays.copyOfRange(lessons, 0, length)));
        } else {
            this.lessons = new HashSet<>(MAX_LESSONS);
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
     * @throws IllegalArgumentException
     */
    public void setId(String id) {
        if (Validation.isIdValid(id)) {
            this.id = id;
        } else {
            LOG.error("Μη έγκυρος ΑΔΤ " + id);
            throw new IllegalArgumentException("Μη έγκυρος ΑΔΤ " + id);
        }
    }

    /**
     * Add a new lesson that this teacher teaches. If the number of lessons that
     * a teacher can teach is reached, the lesson is ignored.
     *
     * @param lesson lesson to add
     */
    public void addLesson(String lesson) {
        if (lesson != null && lessons.size() < MAX_LESSONS) {
            lessons.add(lesson);
            if (LOG.isDebugEnabled()) {
                LOG.debug(lesson + " was assigned to teacher with ID " + this.id);
            }
        }
    }

    /**
     * Remove the lesson from the lessons that this teacher teaches. If the
     * lesson is not teached by this teacher, it is ignored.
     *
     * @param lesson lesson to remove
     */
    public void removeLesson(String lesson) {
        if (lesson != null) {
            this.lessons.remove(lesson);
            if (LOG.isDebugEnabled()) {
                LOG.debug(lesson + " was removed from teacher with ID " + this.id);
            }
        }
    }

    /**
     * Checks if the teacher teaches this lesson.
     *
     * @param les lesson to search for
     * @return {@code true} if the teacher teaches this lesson.
     */
    public boolean contains(String les) {
        return les == null ? false : this.lessons.contains(les);
    }

    /**
     * @return the lessons that this teacher teaches.
     */
    public Collection<String> getLessons() {
        return Collections.unmodifiableCollection(lessons);
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
        return "Teacher{" + "id=" + id + super.toString() + ", lessons=" + lessons + '}';
    }
}
