/**
 * Define the Cake class.
 *
 * @author Cliu702
 * @version 1
 */
public class Cake extends Dessert {
    private String frosting;

    /**
     * 3-args constructor.
     *
     * @param flavor    String representing the flavor of the cake
     * @param sweetness double representing the sweetness of the cake
     * @param frosting  String representing the frosting of the cake
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        this.frosting = frosting;
    }

    /**
     * 1-args constructor.
     *
     * @param flavor String representing the flavor of the cake
     */
    public Cake(String flavor) {
        this(flavor, 45.0, "vanilla");
    }

    /**
     * Gives a String representing information of Dessert.
     *
     * @return String representation of Dessert
     */
    @Override
    public String toString() {
        return String.format("This is a %s cake with a %s frosting and has a sweetness of %.2f.",
                this.getFlavor(), this.frosting, this.getSweetness());
    }

    /**
     * Check if two cakes have the same flavor, sweetness, and frosting.
     *
     * @param o Object representing the object you want to compare
     * @return whether two cakes have the same flavor, sweetness, and frosting
     */
    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && o instanceof Cake) {
            Cake c = (Cake) o;
            return (this.frosting.equals(c.frosting));
        } else {
            return false;
        }
    }

}
