
/**
 * Recursion class.
 *
 * @author CS1331 TAs
 * @version 13.31
 */
public class Recursion {
    /**
     * Sort array of Strings in ascending lexicographical order.
     *
     * @param input Array of String representing the array you want to sort
     * @return the sorted array of String
     */
    public static String[] mergeSort(String[] input) {
        mergeSortHelper(input, 0, input.length - 1);
        return input;
    }

    /**
     * Helper method for mergeSort method.
     *
     * @param input Array of String representing the array you want to sort
     * @param beg   beginning index
     * @param end   ending index
     */
    private static void mergeSortHelper(String[] input, int beg, int end) {
        if (beg == end) {
            return;
        } else if (beg == (end - 1)) {
            if (input[beg].compareTo(input[end]) <= 0) {
                return;
            } else {
                String temp = input[beg];
                input[beg] = input[end];
                input[end] = temp;
            }
        } else {
            int mid = (end - beg) / 2;
            mergeSortHelper(input, beg, beg + mid);
            String[] arr1 = RecursionUtils.copyOfRange(input, beg, beg + mid + 1);
            mergeSortHelper(input, beg + mid + 1, end);
            String[] arr2 = RecursionUtils.copyOfRange(input, beg + mid + 1, end + 1);
            String[] arr3 = RecursionUtils.merge(arr1, arr2);
            for (int i = 0; i < arr3.length; i++) {
                input[beg + i] = arr3[i];
            }
        }
    }

    /**
     * Merge a 2-d array of Strings in a 1-d string array in ascending lexicographical order.
     *
     * @param input 2-d array of Strings you want to sort
     * @return the sorted 1-d array of Strings
     */
    public static String[] mergeAll(String[][] input) {
        return mergeAllHelper(input, input[0], 1);
    }

    /**
     * Helpermethod for mergeAll method.
     *
     * @param input    2-d array of Strings you want to sort
     * @param strings  1-d array that have been sorted
     * @param position the index of current position you want to merge
     * @return the sorted 1-d array
     */
    private static String[] mergeAllHelper(String[][] input, String[] strings, int position) {
        if (position == input.length - 1) {
            return RecursionUtils.merge(strings, input[position]);
        } else {
            String[] result = RecursionUtils.merge(strings, input[position]);
            return mergeAllHelper(input, result, position + 1);
        }
    }

    /**
     * Count the number of duplicates in the array of String.
     *
     * @param input Array of String in ascending lexicographical order
     * @return int representing the number of duplicate
     */
    public static int countDuplicates(String[] input) {
        if (input.length == 1 || input.length == 0) {
            return 0;
        } else {
            String[] arr = RecursionUtils.copyOfRange(input, 1, input.length);
            if (input[1].equals(input[0])) {
                return 1 + countDuplicates(arr);
            } else {
                return countDuplicates(arr);
            }
        }
    }

    /**
     * Test whether this String is a palindrome.
     *
     * @param input String representing the String you want to test
     * @return boolean representing whether this String is a palindrome
     */
    public static boolean verifyPalindrome(String input) {
        if (input == null) {
            return false;
        } else if (input.equals("") || input.length() == 1) {
            return true;
        } else {
            String newString = input.substring(1, input.length() - 1);
            if (Character.toLowerCase(input.charAt(0)) == Character.toLowerCase(input.charAt(input.length() - 1))) {
                return verifyPalindrome(newString);
            } else {
                return false;
            }
        }
    }

    /**
     * Find how many points are strictly within the circle.
     *
     * @param points Array of Points representing the Cartesian coordinates for a set of points
     * @param radius int representing the radius of the circle
     * @return int representing the number of points that are strictly within the circle
     */
    public static int numInteriorPoints(Point[] points, int radius) {
        return numInteriorPointsHelper(points, radius, 0);
    }

    /**
     * Helper method for numInteriorPoint method.
     *
     * @param points   Array of Points representing the Cartesian coordinates for a set of points
     * @param radius   int representing the radius of the circle
     * @param position int representing the current position in the array
     * @return int representing whether current point is strictly within the circle
     */
    private static int numInteriorPointsHelper(Point[] points, int radius, int position) {
        if (position >= points.length) {
            return 0;
        } else {
            if (Math.pow(points[position].getX(), 2) + Math.pow(points[position].getY(), 2) < Math.pow(radius, 2)) {
                return 1 + numInteriorPointsHelper(points, radius, position + 1);
            } else {
                return numInteriorPointsHelper(points, radius, position + 1);
            }
        }
    }
}
