package school.validation;

public final class Validation {

    private static final int MAX_SIZE = 20; // max name size
    private static final int ID_LENGTH = 8;
    public static final int DEFAULT_SIZE = 30;
    private static final int CLASSROOM_NAME_LENGTH = 2; // max classRoom name length 

    private Validation() {
    }

    public static boolean isNameValid(String name) {
        return name != null && !name.isBlank() && name.length() <= MAX_SIZE;
    }

    public static boolean isAgeValid(int inAge) {
        return inAge >= 15 && inAge <= 18;
    }

    public static boolean isSizeValid(int inSize) {
        return inSize >= 20 && inSize <= DEFAULT_SIZE;
    }

    public static boolean isClassRoomNameValid(String classRoom) {
        return classRoom != null && !classRoom.isBlank()
                && classRoom.length() == CLASSROOM_NAME_LENGTH
                && (classRoom.startsWith("Α") || classRoom.startsWith("Β") || classRoom.startsWith("Γ"))
                && classRoom.charAt(1) >= '1' && classRoom.charAt(1) <= '9';
    }

    // ΑΔΤ: ΧΥ123456
    public static boolean isValidId(String id) {
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

    private static boolean isCapitalLetter(char c) {
        return c >= 'Α' && c <= 'Ω';
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

}
