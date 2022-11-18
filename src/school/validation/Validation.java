package school.validation;

/**
 * An Utility Validation class.
 */
public final class Validation {

    /**
     * Max size for names.
     */
    private static final int MAX_SIZE = 20;
    /**
     * Classroom name length.
     */
    private static final int CLASSROOM_NAME_LENGTH = 2;
    /**
     * Classroom min size.
     */
    private static final int CLASSROOM_MIN_SIZE = 10;
    /**
     * Classroom default/max size.
     */
    public static final int CLASSROOM_MAX_SIZE = 30;
    /**
     * Identity length.
     */
    private static final int ID_LENGTH = 8;

    /**
     * No instance of this class are allowed.
     */
    private Validation() {
    }

    /**
     * A {@code name} is valid if it is neither {@code null} nor empty and not
     * more than {@code MAX_SIZE}.
     *
     * @param name a name
     * @return {@code true} if {@code name} is valid
     * @see MAX_SIZE
     */
    public static boolean isNameValid(String name) {
        return name != null && !name.isBlank() && name.length() <= MAX_SIZE;
    }

    /**
     * A valid age is between 15 and 18 years old.
     *
     * @param inAge an age
     * @return {@code true} if {@code inAge} is between the limits
     */
    public static boolean isAgeValid(int inAge) {
        return inAge >= 15 && inAge <= 18;
    }

    /**
     * A valid classroom size is between 10 and 30 pupils.
     *
     * @param inSize classroom size
     * @return {@code true} if {@code inSize} is between the limits
     * @see CLASSROOM_MIN_SIZE
     * @see CLASSROOM_MAX_SIZE
     */
    public static boolean isSizeValid(int inSize) {
        return inSize >= CLASSROOM_MIN_SIZE && inSize <= CLASSROOM_MAX_SIZE;
    }

    /**
     * A valid classroom name should start with one of the letters
     * {@code Α, Β, Γ} and end with a number. E.g. {@code Γ1}.
     *
     * @param classRoom a classroom name
     * @return {@code true} if {@code classRoom} is valid
     * @see CLASSROOM_NAME_LENGTH
     */
    public static boolean isClassRoomNameValid(String classRoom) {
        return classRoom != null && !classRoom.isBlank()
                && classRoom.length() == CLASSROOM_NAME_LENGTH
                && (classRoom.startsWith("Α")
                || classRoom.startsWith("Β")
                || classRoom.startsWith("Γ"))
                && classRoom.charAt(1) >= '1'
                && classRoom.charAt(1) <= '9';
    }

    /**
     * A valid Hellenic ID consists of two letters and six numbers. E.g.
     * {@code XY123456}.
     *
     * @param id a Hellenic ID number (ΑΔΤ)
     * @return {@code true} if the {@code id} is valid
     * @see ID_LENGTH
     */
    public static boolean isIdValid(String id) {
        return id != null && !id.isBlank() && id.length() == ID_LENGTH
                && isCapitalLetter(id.charAt(0))
                && isCapitalLetter(id.charAt(1))
                && isNumber(id.charAt(2))
                && isNumber(id.charAt(3))
                && isNumber(id.charAt(4))
                && isNumber(id.charAt(5))
                && isNumber(id.charAt(6))
                && isNumber(id.charAt(7));
    }

    /**
     * Check if {@code c} is a capital letter.
     *
     * @param c character to check
     * @return {@code true} if {@code c} is capital letter.
     */
    public static boolean isCapitalLetter(char c) {
        return c >= 'A' && c <= 'Ω';
    }

    /**
     * Check if {@code c} is a number.
     *
     * @param c character to check
     * @return {@code true} if {@code c} is a number.
     */
    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
