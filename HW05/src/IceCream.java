/**
 * Define the IceCream class.
 *
 * @author Cliu702
 * @version 1
 */
public class IceCream extends Dessert {
    private int scoops;
    private boolean cone;

    /**
     * 4-args constructor.
     *
     * @param flavor    String representing the flavor of the cake
     * @param sweetness double representing the sweetness of the cake
     * @param scoops    int representing the number of scoops of ice cream you get
     * @param cone      boolean represents if the ice cream has a cone
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        this.scoops = scoops;
        this.cone = cone;
    }

    /**
     * 2-args constructor.
     *
     * @param scoops int representing the number of scoops of ice cream you get
     * @param cone   boolean represents if the ice cream has a cone
     */
    public IceCream(int scoops, boolean cone) {
        this("vanilla", 45.0, scoops, cone);
    }

    /**
     * Default constructor.
     */
    public IceCream() {
        this("vanilla", 45.0, 1, false);
    }

    /**
     * Gives a String representing information of IceCream.
     *
     * @return String representation of IceCream
     */
    @Override
    public String toString() {
        if (cone) {
            return String.format("This is a %s ice cream with %d scoops and has a cone.",
                    this.getFlavor(), this.scoops);
        } else {
            return String.format("This is a %s ice cream with %d scoops and does not have a cone.",
                    this.getFlavor(), this.scoops);
        }

    }

    /**
     * Check if two IceCreams have the same flavor, sweetness, scoops, and cone.
     *
     * @param o Object representing the object you want to compare
     * @return whether two IceCreams have the same flavor, sweetness, scoops, and cone
     */
    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && o instanceof IceCream) {
            IceCream i = (IceCream) o;
            return ((this.scoops == i.scoops) && (this.cone == i.cone));
        } else {
            return false;
        }
    }

}
