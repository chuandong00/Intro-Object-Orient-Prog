/**
 * Define the Dessert class.
 *
 * @author Cliu702
 * @version 1
 */
public abstract class Dessert implements Comparable<Dessert> {
    private String flavor;
    private double sweetness;

    /**
     * 2-args constructor.
     * @param flavor String representing the flavor of the cake
     * @param sweetness double representing the sweetness of the cake
     */
    public Dessert(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
    }

    /**
     * Default constructor.
     */
    public Dessert() {
        this("vanilla", 25.0);
    }

    /**
     * Gives a String representing information of Dessert.
     * @return String representation of Dessert
     */
    @Override
    public String toString() {
        return String.format("This is a %s dessert with a sweetness of %.2f.", this.flavor, this.sweetness);
    }

    /**
     * Check if two desserts have the same flavor and sweetness.
     *
     * @param o Object representing the object you want to compare
     * @return whether two desserts have the same flavor and sweetness
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Dessert) {
            Dessert d = (Dessert) o;
            return this.flavor.equals(d.flavor) && (this.sweetness == d.sweetness);
        } else {
            return false;
        }
    }

    /**
     * Compared this Dessert with another Dessert.
     *
     * @param o Dessert representing the Dessert to be compared to
     * @return int representing whether this Dessert has better flavor and sweetness than other Dessert
     */
    @Override
    public int compareTo(Dessert o) {
        if (o == null) {
            return 1;
        }
        if (this.sweetness > o.sweetness) {
            return 1;
        } else if (this.sweetness < o.sweetness) {
            return -1;
        } else { //this.sweetness == o.sweetness
            return this.flavor.compareTo(o.flavor);
        }
    }

    /**
     * Getter for sweetness.
     * @return double representing the sweetness of the cake
     */
    public double getSweetness() {
        return sweetness;
    }

    /**
     * Getter for flavor.
     * @return String representing the flavor of the cake
     */
    public String getFlavor() {
        return flavor;
    }
}
