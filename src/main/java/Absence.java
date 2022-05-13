/**
 * Used for recording the absences of a given student for each subject.
 */
public class Absence {
    private Integer missedHours;    // Number of hours missed on a given day. Defaults to one.
    private Integer year;           //
    private Integer month;          //  Date of absence.
    private Integer day;            //

    /**
     * Records an absence on the selected date and number of missed hours.
     * @param year
     * @param month
     * @param day
     * @param missedHours
     */
    public Absence(Integer year, Integer month, Integer day, Integer missedHours) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.missedHours = missedHours;
    }

    /**
     * Returns an array of the details of this absence.
     * @return Integer[]<br> year, month, day, missedHours
     */
    public Integer[] readAbsence() {
        return new Integer[]{this.year, this.month, this.day, this.missedHours};
    }

    /**
     * Overwrites the details of this absence.
     * @param year
     * @param month
     * @param day
     * @param missedHours
     */
    public void editAbsence(Integer year, Integer month, Integer day, Integer missedHours) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.missedHours = missedHours;
    }

}
