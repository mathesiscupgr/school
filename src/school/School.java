package school;

public class School {

    private static final ClassRoom[] classRooms = {
        new ClassRoom("Α1"),
        new ClassRoom("Α2", 28),
        new ClassRoom("Α3", 25),
        new ClassRoom("Β1"),
        new ClassRoom("Β2", 28),
        new ClassRoom("Β3", 25),
        new ClassRoom("Γ1"),
        new ClassRoom("Γ2", 26),
        new ClassRoom("Γ3", 22)};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Create student ioannis ====");
        Student ioannis = new Student("Γιάννης", "Αντεκοτούμπο", 16);
        System.out.println("AM: " + ioannis.getAm());
        System.out.println("ClassRoom: " + ioannis.getClassRoom());
        
        System.out.println("\n=== Add student ioannis to classroom 'B1' ====");
        classRooms[3].addStudent(ioannis);
        System.out.println(ioannis.getClassRoom());
        System.out.println(ioannis);
        
        System.out.println("\n=== Create student aliki and add to classroom 'B1' ====");
        Student aliki = new Student("Αλίκη", "Βουγιουκλάκη", 17);
        classRooms[3].addStudent(aliki);
        System.out.println(aliki);
        System.out.println(classRooms[3]);

        System.out.println("\n=== Remove student ioannis from classroom 'B1' ====");
        classRooms[3].removeStudent(ioannis.getAm());
        System.out.println(ioannis);
        System.out.println(classRooms[3]);
    }

}
