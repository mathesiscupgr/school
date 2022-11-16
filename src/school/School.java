package school;

public class School {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student ioannis = new Student("Γιάννης", "Αντεκοτούμπο", 16, "Α2");
        System.out.println("AM: " + ioannis.getAm());
        System.out.println("Τάξη: " + ioannis.getClassroom());
        
        ioannis.setClassroom("Β1");
        System.out.println("Τάξη: " + ioannis.getClassroom());
        
        System.out.println(ioannis);
    }
    
}
