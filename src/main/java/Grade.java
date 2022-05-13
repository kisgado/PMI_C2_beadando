/**
 * Used for recording the grades of a given student for each subject.
 */
public class Grade {
    private Integer grade;
    private String assignment;
    private Integer year;
    private Integer month;
    private Integer day;

    /**
     * Records a grade and assignment on the selected date.
     * @param grade
     * @param assignment
     * @param year
     * @param month
     * @param day
     */
    public Grade(Integer grade, String assignment, Integer year, Integer month, Integer day) {
        this.grade = grade;
        this.assignment = assignment;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns an array of the details of the grade.
     * @return Object[] <br>
     * grade, assignment, year, month, day
     */
    public Object[] readGrade() {
        return new Object[]{this.grade, this.assignment, this.year, this.month, this.day};
    }

    /**
     * Overwrites the details of this grade.
     * @param grade
     * @param assignment
     * @param year
     * @param month
     * @param day
     */
    public void editGrade(Integer grade, String assignment, Integer year, Integer month, Integer day) {
        this.grade = grade;
        this.assignment = assignment;
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
