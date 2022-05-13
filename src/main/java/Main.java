import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * This is where all the data is being stored. Empty by default, the user can add new data or load from a file.
     */
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        // Main menu preparation
        Scanner in = new Scanner(System.in);
        int menu = -1;

        while (menu!=0) {
            System.out.println("\n\nStudent Database\n");
            System.out.println("Please choose from the following options.");
            System.out.println("1. Open student menu");
            System.out.println("2. Load external data");
            System.out.println("0. Exit");
            menu = in.nextInt();

            switch (menu) {
                case 1: studentMenu(); break;
                case 2: Data.load(); break;

            }
        }
    }

    private static void studentMenu() {
        System.out.println("\nCurrent number of students: " + students.size());

        Scanner in = new Scanner(System.in);
        int menu = -1;

        while (menu!=0) {
            System.out.println("\nPlease choose from the following options.");
            System.out.println("1. Add new student");
            System.out.println("2. List students");
            System.out.println("3. Edit students");
            System.out.println("4. Save students");
            System.out.println("0. Exit");
            menu = in.nextInt();

            switch (menu) {
                case 1: addStudent(); break;
                case 2: listStudents(); break;
                case 3: editStudents(); break;
                case 4: Data.save(); break;
            }
        }
    }

    private static void addStudent() {
        students.add(new Student());
    }

    private static void addStudent(String f, String l, Integer y, Integer m, Integer d, String e) {
        students.add(new Student(f,l,y,m,d,e));
    }

    private static int listStudents() {
        if (students.isEmpty()) {
            System.out.println("\nThere are no students.");
            return 0;
        } else {
            System.out.println("\nStudents:");
            int i;
            for (i = 0; i < students.size(); i++) {
                System.out.println((i+1) + "\t" + students.get(i).getStudentName());
            }
            return (i+1);
        }
    }

    private static void editStudents() {
        int numberOfStudents = listStudents();
        if (numberOfStudents > 0) {

            Scanner in = new Scanner(System.in);
            System.out.print("Enter the number of a student (or 0 to cancel): ");
            int menu = in.nextInt();

            if (menu!=0) {
                editStudentMenu(menu);
            }

        }
    }

    private static void editStudentMenu(int student) {
        student = student - 1;
        students.get(student).printStudentInfo();
        students.get(student).printStudentSubjects();

        System.out.println("\nChoose between the following: ");

        Scanner in = new Scanner(System.in);
        System.out.println("1. Add subject");
        System.out.println("2. Select subject");
        System.out.println("3. Edit student info");
        System.out.println("4. Delete student");
        System.out.println("0. Exit");
        int menu = in.nextInt();
        if (menu!=0) {
            switch (menu) {
                case 1: students.get(student).addSubject(); break;
                case 2: subjectChoiceMenu(student); break;
                case 3: students.get(student).editStudentInfo(); break;
                case 4: deleteStudent(student); break;
            }
        }
    }

    private static void subjectChoiceMenu(int student) {
        students.get(student).printStudentSubjects();
        System.out.println("Choose a subject: ");
        Scanner in = new Scanner(System.in);
        int menu = in.nextInt();
        Subject subject = students.get(student).getSubject((menu-1),true);

        subject = subjectActionsMenu(subject);

        students.get(student).addSubject(subject);

    }
    private static Subject subjectActionsMenu(Subject subject) {

        String name = subject.getNameOfSubject();
        System.out.println("\nChoose between the following: ");

        Scanner in = new Scanner(System.in);
        System.out.println("\nSubject: " + name);
        System.out.println("1. Grades");
        System.out.println("2. Absences");
        System.out.println("3. Rename subject");
        System.out.println("0. Go back");
        int menu = in.nextInt();
        if (menu!=0) {
            switch (menu) {
                case 1: subject = gradesMenu(subject); break;
                case 2: subject = absencesMenu(subject); break;
                case 3: subject = renameSubject(subject); break;
            }
        }
        return subject;
    }

    private static Subject gradesMenu(Subject subject) {
        subject.printGrades();
        System.out.println("Please choose from the following options.");
        System.out.println("1. Add new grade");
        System.out.println("2. Edit grade");
        System.out.println("3. Remove grade");
        System.out.println("0. Exit");
        return subject;
    }

    private static Subject absencesMenu(Subject subject) {

        return subject;
    }

    private static Subject renameSubject(Subject subject) {

        return subject;
    }

    private static void deleteStudent(int student) {
        students.remove(student);
        System.out.println("\nStudent has been removed.\n");
    }
}
