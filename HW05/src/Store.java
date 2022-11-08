import java.util.ArrayList;

/**
 * Define the Store class.
 *
 * @author Cliu702
 * @version 1
 */
public class Store {
    private String name;
    private ArrayList<Dessert> desserts;

    /**
     * 1-args Constructor.
     *
     * @param name String representing name of the store
     */
    public Store(String name) {
        this.name = name;
        this.desserts = new ArrayList<Dessert>();
    }

    /**
     * Add the dessert to the back of the Desserts.
     *
     * @param dessert Dessert object representing the object you want to add
     */
    public void addDessert(Dessert dessert) {
        this.desserts.add(dessert);
    }

    /**
     * Remove the first instance of the dessert.
     *
     * @param dessert Dessert object representing the object you want to remove
     * @return Dessert representing the dessert that is being removed
     */
    public Dessert removeDessert(Dessert dessert) {
        for (int i = 0; i < desserts.size(); i++) {
            if (desserts.get(i).equals(dessert)) {
                return desserts.remove(i);
            }
        }
        return null;
    }

    /**
     * Find the dessert that has the same sweetness and flavor in the store.
     *
     * @param dessert Dessert representing the Dessert that you are looking for
     * @return Dessert representing the Dessert that has the same sweetness and flavor in the store
     */
    public Dessert findDessert(Dessert dessert) {
        int left = 0;
        int right = desserts.size();
        int middle = 0;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (dessert.compareTo(desserts.get(middle)) == 0) {
                return desserts.get(middle);
            } else if (dessert.compareTo(desserts.get(middle)) > 0) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return null;
    }

    /**
     * Sort in ascending order based on sweetness and flavor.
     */
    public void sortStore() {
        for (int i = 0; i < desserts.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < desserts.size(); j++) {
                if (desserts.get(j).compareTo(desserts.get(minIdx)) < 0) {
                    minIdx = j;
                }
            }
            Dessert temp = desserts.get(minIdx);
            desserts.set(minIdx, desserts.get(i));
            desserts.set(i, temp);
        }
    }

    /**
     * Find the number of desserts in the store that is greater or equal to the Dessert passed in.
     *
     * @param dessert Dessert that you want to compare to
     * @return int representing number of desserts in the store that is greater or equal to the Dessert passed in
     */
    public int checkStore(Dessert dessert) {
        int count = 0;
        for (Dessert value : desserts) {
            if (value.compareTo(dessert) > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Getter for name.
     *
     * @return String representing name of the store
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for desserts.
     *
     * @return ArrayList of Dessert representing dessert that the store has
     */
    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }
}
