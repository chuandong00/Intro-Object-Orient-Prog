/**
 * Define the Course class.
 *
 * @author Cliu702
 * @version 1
 */
public abstract class Course {
    protected String courseName;
    protected int id;
    protected String professorName;

    /**
     * 3-args constructor.
     *
     * @param courseName    String representing name of the course
     * @param id            int representing the course identification number
     * @param professorName String representing the name of the professor teaching the course
     */
    public Course(String courseName, int id, String professorName) {
        if (courseName == null || courseName.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.courseName = courseName;
        }

        if (professorName == null || professorName.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.professorName = professorName;
        }

        if (id < 10000 || id > 99999) {
            throw new IllegalArgumentException();
        } else {
            this.id = id;
        }
    }

    /**
     * Gives a String representing information of the Course.
     *
     * @return String representation of Course
     */
    @Override
    public String toString() {
        return String.format("%s,%d,%s", this.courseName, this.id, this.professorName);
    }

    /**
     * Check if two Course have the same name, id, and professor.
     *
     * @param o Object representing the object you want to compare
     * @return whether two Course have the same name, id, and professor
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Course) {
            Course c = (Course) o;
            return this.courseName.equals(c.courseName) && (this.id == c.id)
                    && this.professorName.equals(c.professorName);
        } else {
            return false;
        }
    }
}
