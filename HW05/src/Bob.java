/**
 * Define the Bob class.
 *
 * @author Cliu702
 * @version 1
 */
public class Bob {

    /**
     * Test whether each individual dessert object in Store 1 are all in Store 2.
     *
     * @param store1 Store object representing the first store
     * @param store2 Store object representing the second store
     * @return boolean representing whether each individual dessert object in Store 1 are all in Store 2
     */
    public static boolean compareStores(Store store1, Store store2) {
        for (int i = 0; i < store1.getDesserts().size(); i++) {
            if (store2.findDessert(store1.getDesserts().get(i)) == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Test whether Bob was able to find his dessert in the store.
     *
     * @param store   Store object representing the store
     * @param dessert Dessert object representing the dessert
     * @return boolean representing whether Bob was able to find his dessert in the store
     */
    public static boolean shop(Store store, Dessert dessert) {
        store.sortStore();
        if (store.findDessert(dessert) == null) {
            return false;
        }
        return true;
    }
}
