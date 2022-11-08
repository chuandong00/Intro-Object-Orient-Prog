/**
 * Define the InvalidCourseException class.
 *
 * @author Cliu702
 * @version 1
 */
public class InvalidCourseException extends RuntimeException {
    /**
     * 1-args constructor.
     *
     * @param message String representing the exception’s message
     */
    public InvalidCourseException(String message) {
        super(message);
    }

    /**
     * Default constructor.
     */
    public InvalidCourseException() {
        super("Invalid course type!");
    }
}
