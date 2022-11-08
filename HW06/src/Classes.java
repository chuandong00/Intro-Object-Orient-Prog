import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Define the Classes class.
 *
 * @author Cliu702
 * @version 1
 */
public class Classes {

    /**
     * Get the Course object in the file.
     *
     * @param fileName String representing the name of the file
     * @return ArrayList of Course object
     * @throws FileNotFoundException Throws a FileNotFoundException if the passed in file is null or doesn’t exist
     */
    public static ArrayList<Course> outputCourses(String fileName) throws FileNotFoundException {
        File myFile = new File(fileName);
        if (!myFile.exists()) {
            throw new FileNotFoundException();
        }
        ArrayList<Course> courses = new ArrayList<>();
        Scanner scan = new Scanner(myFile);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] elements = line.split(",");
            Course newCourse;
            if (elements[0].equals("ComputerScience")) {
                newCourse = new ComputerScience(elements[1], Integer.parseInt(elements[2]), elements[3], elements[4]);
            } else {
                newCourse = new LabScience(elements[1], Integer.parseInt(elements[2]), elements[3],
                        Boolean.parseBoolean(elements[4]));
            }
            courses.add(newCourse);
        }
        return courses;
    }

    /**
     * Add new Course object in the file.
     *
     * @param fileName String representing the name of the file
     * @param courses  ArrayList of Course object
     * @return boolean representing whether write was successful
     * @throws FileNotFoundException Throws a FileNotFoundException if the passed in file is null or doesn’t exist
     */
    public static boolean writeCourses(String fileName, ArrayList<Course> courses) throws FileNotFoundException {
        File myFile = new File(fileName);
        try {
            if (myFile.exists()) {
                ArrayList<Course> oldCourses = outputCourses(fileName);
                PrintWriter outWriter = new PrintWriter(fileName);
                for (Course oldCourse : oldCourses) {
                    outWriter.write(oldCourse.toString() + "\n");
                }
                for (Course course : courses) {
                    outWriter.println(course.toString());
                }
                outWriter.close();
            } else {
                PrintWriter outWriter = new PrintWriter(fileName);
                for (Course course : courses) {
                    outWriter.println(course.toString());
                }
                outWriter.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * Find the Course object in the file.
     *
     * @param fileName String representing the name of the file
     * @param course   Course object you are looking for
     * @return ArrayList of Integer objects
     * @throws FileNotFoundException Throws a FileNotFoundException if the passed in file is null or doesn’t exist
     */
    public static ArrayList<Integer> readCourses(String fileName, Course course) throws FileNotFoundException {
        ArrayList<Course> oldCourses = outputCourses(fileName);
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < oldCourses.size(); i++) {
            if (oldCourses.get(i).equals(course)) {
                results.add(i + 1);
            }
        }
        if (results.size() == 0) {
            throw new InvalidCourseException();
        }
        return results;
    }

    /**
     * Test the Classes method.
     *
     * @param args Array of String
     */
    public static void main(String[] args) {
        Course c1 = new ComputerScience("cs1331", 15876, "Jacky", "Java");
        Course c2 = new ComputerScience("cs1332", 17841, "Pones", "JavaScript");
        Course c3 = new ComputerScience("cs2110", 13321, "Monica", "C");
        Course c4 = new LabScience("cs1331R", 24852, "Coley", true);
        Course c5 = new LabScience("cs1332R", 23965, "Jessica", false);
        Course c6 = new LabScience("cs2110R", 22578, "David", true);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
        courses.add(c5);
        courses.add(c6);
        try {
            writeCourses("TestCourses.csv", courses);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Course cs1 = new ComputerScience("cs4120", 45825, "Niche", "Python");
        ArrayList<Course> courses2 = new ArrayList<>();
        courses2.add(cs1);


        try {
            writeCourses("TestCourses.csv", courses2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        ArrayList<Course> courses1 = null;
        try {
            courses1 = outputCourses("TestCourses.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Course course : courses1) {
            System.out.println(course.toString());
        }
    }
}
