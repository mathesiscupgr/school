package school;

import java.util.Arrays;
import java.util.Objects;
import school.validation.Validation;

public class Teacher extends Person {

    private static final int MAX_LESSONS = 3;

    private String id;  // ΑΔΤ
    private String[] lessons; // 0-3

    private int index = 0;

    public Teacher(String id, String firstName, String lastName, String... lessons) {
        super(firstName, lastName);
        this.id = Validation.isValidId(id) ? id : NONE;
        if (lessons != null && lessons.length > 0) { // αντιγράφουμε μόνο τα πρώτα 3 μαθήματα
            int length = lessons.length > MAX_LESSONS ? MAX_LESSONS : lessons.length;
            this.lessons = Arrays.copyOfRange(lessons, 0, length);
        } else {
            this.lessons = new String[MAX_LESSONS];
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Validation.isValidId(id) ? id : NONE;
    }

    public void addLesson(String lesson) {
        if (lesson != null && index < MAX_LESSONS) {
            lessons[index++] = lesson;
        }
    }

    public void removeLesson(String lesson) {
        if (lesson != null) {
            remove(contains(lessons, lesson));
        }
    }

    private int contains(String[] lessons, String les) {
        for (int i = 0; i < lessons.length; i++) {
            String lesson = lessons[i];
            if (lesson.equalsIgnoreCase(les)) {
                return i;
            }
        }
        return -1;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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

}
