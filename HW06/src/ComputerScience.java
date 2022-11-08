/**
 * Define the ComputerScience class.
 *
 * @author Cliu702
 * @version 1
 */
public class ComputerScience extends Course {
    private String language;

    /**
     * 4-args constructor.
     *
     * @param courseName    String representing name of the course
     * @param id            int representing the course identification number
     * @param professorName String representing the name of the professor teaching the course
     * @param language      String representing the language in which the class is taught
     */
    public ComputerScience(String courseName, int id, String professorName, String language) {
        super(courseName, id, professorName);
        if (language == null || language.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.language = language;
        }
    }

    /**
     * Gives a String representing information of the ComputerScience Course.
     *
     * @return String representation of ComputerScience Course
     */
    @Override
    public String toString() {
        return String.format("ComputerScience,%s,%d,%s,%s", this.courseName,
                this.id, this.professorName, this.language);
    }

    /**
     * Check if two ComputerScience Course have the same name, id, professor, and language.
     *
     * @param o Object representing the object you want to compare
     * @return whether two ComputerScience Course have the same name, id, professor, and language
     */
    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && o instanceof ComputerScience) {
            ComputerScience cs = (ComputerScience) o;
            return (this.language.equals(cs.language));
        } else {
            return false;
        }
    }
}
