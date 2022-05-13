import java.util.ArrayList;
import java.util.Scanner;

public class Subject {
    private String nameOfSubject;
    private ArrayList<Absence> absences;
    private ArrayList<Grade> grades;

    public Subject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
        this.absences = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    /**
     * Adds a new grade to the student in this subject. Used by other parts of the program.
     * @param grade
     * @param assignment
     * @param year
     * @param month
     * @param day
     */
    public void addGrade(Integer grade, String assignment, Integer year, Integer month, Integer day) {
        grades.add(new Grade(grade, assignment, year, month, day));
    }

    /**
     * Adds a new grade to the student in this subject by asking the user for the data.
     */
    public void addGrade() {
        System.out.println("Enter the details of the grade: ");
        Scanner in = new Scanner(System.in);
        System.out.print("Grade: "); int grade = in.nextInt(); in.nextLine();
        System.out.print("Assignment: "); String assignment = in.nextLine();
        System.out.print("Year: "); int year = in.nextInt();
        System.out.print("Month: "); int month = in.nextInt();
        System.out.print("Day: "); int day = in.nextInt();
        grades.add(new Grade(grade, assignment, year, month, day));
    }

    /**
     * Adds a new absence to the student in this subject.
     * @param year
     * @param month
     * @param day
     * @param missedHours
     */
    public void addAbsence(Integer year, Integer month, Integer day, Integer missedHours) {
        absences.add(new Absence(year, month, day, missedHours));
    }

    /**
     * Adds a new absence to the student in this subject, by asking the user for the data.
     */
    public void addAbsence() {
        System.out.println("Enter the details of the absence: ");
        Scanner in = new Scanner(System.in);
        System.out.print("Year: "); int year = in.nextInt();
        System.out.print("Month: "); int month = in.nextInt();
        System.out.print("Day: "); int day = in.nextInt();
        System.out.print("Missed hours: "); int missedHours = in.nextInt();
        absences.add(new Absence(year, month, day, missedHours));
    }

    /**
     * Prints out a table containing the grades of the student in this subject.
     */
    public void printGrades() {
        System.out.println("\n\tYear\tMonth\tDay\t\tGrade\tAssignment");
        for(int i = 0; i < grades.size(); i++) {
            Object[] currentGrade = grades.get(i).readGrade();
            String ki = (i+1) +"\t";
            ki = ki + currentGrade[2] + "\t" + currentGrade[3] + "\t\t" +  currentGrade[4] + "\t\t" + currentGrade[0];
            ki = ki + "\t\t" + currentGrade[1];
            System.out.println(ki);
        }
        System.out.print("\n");
    }

    /**
     * Prints out a table containing the absences of the student in this subject.
     */
    public void printAbsences() {
        System.out.println("\n\tYear\tMonth\tDay\t\tMissed hours");
        for(int i = 0; i < absences.size(); i++) {
            Integer[] currentAbsence = absences.get(i).readAbsence();
            String ki = (i+1) +"\t";
            ki = ki + currentAbsence[0] + "\t" + currentAbsence[1] + "\t\t" +  currentAbsence[2] + "\t\t";
            ki = ki + currentAbsence[3];
            System.out.println(ki);
        }
        System.out.print("\n");
    }

    /**
     * The user can choose one of the already existing grades, and overwrite its data.
     */
    public void editGrade() {
        this.printGrades();
        System.out.print("Enter the number of grade to be edited, or '0' to cancel: ");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        if(id != 0) {
            Object[] current = grades.get(id-1).readGrade();
            System.out.print("Current grade: " + current[0] + "\nNew grade: ");
            int grade = in.nextInt();
            System.out.println("Current assignment: " + current[1] + "\nNew assignment: ");
            in.nextLine();  // Fixing the string input after int
            String assignment = in.nextLine();
            System.out.print("Current year: " + current[2] + "\nNew year: ");
            int year = in.nextInt();
            System.out.print("Current month: " + current[3] + "\nNew month: ");
            int month = in.nextInt();
            System.out.print("Current day: " + current[4] + "\nNew day: ");
            int day = in.nextInt();
            grades.get(id-1).editGrade(grade, assignment, year, month, day);
        }
    }

    /**
     * The user can choose one of the already existing absences, and overwrite its data.
     */
    public void editAbsence() {
        this.printAbsences();
        System.out.print("Enter the number of absence to be edited, or '0' to cancel: ");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        if(id != 0) {
            Integer[] current = absences.get(id-1).readAbsence();
            System.out.print("Current year: " + current[0] + "\nNew year: ");
            int year = in.nextInt();
            System.out.print("Current month: " + current[1] + "\nNew month: ");
            int month = in.nextInt();
            System.out.print("Current day: " + current[2] + "\nNew day: ");
            int day = in.nextInt();
            System.out.print("Current missed hours: " + current[3] + "\nNew missed hours: ");
            int missedHours = in.nextInt();
            absences.get(id-1).editAbsence(year, month, day, missedHours);
        }
    }

    /**
     * Overwrites the name of this subject.
     */
    public void editNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    /**
     * Overwrites the name of this subject, by asking the user for a new name.
     */
    public void editNameOfSubject() {
        Scanner in = new Scanner(System.in);
        String nameOfSubject = "";
        while (nameOfSubject.length()==0) {
            System.out.print("Enter the new name of the subject: ");
            nameOfSubject = in.nextLine();
        }
        this.nameOfSubject = nameOfSubject;
    }

    /**
     * Returns the name of this subject
     * @return String
     */
    public String getNameOfSubject() {
        return this.nameOfSubject;
    }
}