import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
    private String email;
    private ArrayList<Subject> subjects;

    /**
     * Creates a new student.
     * @param firstName
     * @param lastName
     * @param birthYear
     * @param birthMonth
     * @param birthDay
     * @param email
     */
    public Student(String firstName, String lastName, Integer birthYear, Integer birthMonth, Integer birthDay, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.email = email;
        this.subjects = new ArrayList<>();
    }

    /**
     * Creates a new student by asking the user for the details.
     */
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter the firstname of the student: "); this.firstName = in.nextLine();
        System.out.print("Enter the lastname of the student: "); this.lastName = in.nextLine();
        System.out.print("Enter the birth year of the student: "); this.birthYear = in.nextInt();
        System.out.print("Enter the birth month of the student: "); this.birthMonth = in.nextInt();
        System.out.print("Enter the birth day of the student: "); this.birthDay = in.nextInt();
        in.nextLine(); // nextInt fix
        System.out.print("Enter the email of the student: "); this.email = in.nextLine();
        this.subjects = new ArrayList<>();
    }

    /**
     * Prints out the personal information of this student.
     */
    public void printStudentInfo() {
        System.out.println("");
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Birthdate: " + this.birthYear + "/" + this.birthMonth + "/" + this.birthDay);
        System.out.println("Email: " + this.email);
    }

    /**
     * Allows the user to change the information of the student.
     */
    public void editStudentInfo() {
        System.out.println("\nCurrent student info:");
        this.printStudentInfo();
        System.out.println("New student info:");
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter the firstname of the student: "); this.firstName = in.nextLine();
        System.out.print("Enter the lastname of the student: "); this.lastName = in.nextLine();
        System.out.print("Enter the birth year of the student: "); this.birthYear = in.nextInt();
        System.out.print("Enter the birth month of the student: "); this.birthMonth = in.nextInt();
        System.out.print("Enter the birth day of the student: "); this.birthDay = in.nextInt();
        in.nextLine(); // nextInt fix
        System.out.print("Enter the email of the student: "); this.email = in.nextLine();
    }

    /**
     * Prints out the subjects of this student.
     */
    public void printStudentSubjects() {
        System.out.println("Subjects: ");
        if(!subjects.isEmpty()) {
            for(int i = 0; i < subjects.size(); i++) {
                System.out.println("\t" + (i+1)+"\t" + subjects.get(i).getNameOfSubject());
            }
        } else {
            System.out.println("\tNo subjects were added to this student.");
        }
    }

    /**
     * Returns the full name of the student.
     * @return String
     */
    public String getStudentName() {
        return firstName + " " + lastName;
    }

    /**
     * Adds a new subject to the student.
     */
    public void addSubject(String nameOfSubject) {
        subjects.add(new Subject(nameOfSubject));
    }

    /**
     * Adds a new subject to the student by asking the user for the name of the subject.
     */
    public void addSubject() {
        Scanner in = new Scanner(System.in);
        String nameOfSubject = "";
        while (nameOfSubject.length()==0) {
            System.out.print("Enter the name of the new subject: ");
            nameOfSubject = in.nextLine();
        }
        subjects.add(new Subject(nameOfSubject));
    }

    /**
     * Adds a Subject type object to the subjects ArrayList.
     * @param subject
     */
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    /**
     * Removes a subject from this student.
     */
    public void removeSubject(int id) {
        subjects.remove(id);
    }

    /**
     * Removes a subject from this student by asking the user to select the subject.
     */
    public void removeSubject() {
        System.out.println("\nWhich subject would you like to remove?");
        this.printStudentSubjects();
        System.out.println("Number of subject (or 0 to cancel): ");
        Scanner in = new Scanner(System.in);
        int menu = in.nextInt();
        if (menu <= subjects.size() && menu>0) {
            subjects.remove(menu);
            System.out.println("Subject has been removed.");
        }
    }

    public Subject getSubject(int index, boolean remove) {
        Subject subject = subjects.get(index);
        if (remove) {
            subjects.remove(index);
        }
        return subject;
    }
}
