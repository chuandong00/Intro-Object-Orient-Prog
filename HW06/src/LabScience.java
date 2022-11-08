/**
 * Define the LabScience class.
 *
 * @author Cliu702
 * @version 1
 */
public class LabScience extends Course {
    private boolean labCoatRequired;

    /**
     * 4-args constructor.
     *
     * @param courseName      String representing name of the course
     * @param id              int representing the course identification number
     * @param professorName   String representing the name of the professor teaching the course
     * @param labCoatRequired boolean representing whether a lab coat is needed
     */
    public LabScience(String courseName, int id, String professorName, boolean labCoatRequired) {
        super(courseName, id, professorName);
        this.labCoatRequired = labCoatRequired;
    }

    /**
     * Gives a String representing information of the LabScience Course.
     *
     * @return String representation of LabScience Course
     */
    @Override
    public String toString() {
        return String.format("LabScience,%s,%d,%s,%b", this.courseName,
                this.id, this.professorName, this.labCoatRequired);
    }

    /**
     * Check if two LabScience Course have the same name, id, professor, and labCoatRequired.
     *
     * @param o Object representing the object you want to compare
     * @return whether two LabScience Course have the same name, id, professor, and labCoatRequired
     */
    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && o instanceof LabScience) {
            LabScience ls = (LabScience) o;
            return (this.labCoatRequired == ls.labCoatRequired);
        } else {
            return false;
        }
    }
}
