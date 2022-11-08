/**
 * Define the Vehicle class.
 *
 * @author Cliu702
 * @version 1
 */
public abstract class Vehicle {
    private final String id;
    private double earnings;
    protected int numMiles;
    protected String[] passengers;

    /** 3-args constructor.
     * @param id String representing the identifier for the vehicle
     * @param numMiles int representing the number of miles the vehicle has travelled
     * @param passengers Array of String representing the passengers aboard the vehicle
     */
    public Vehicle(String id, int numMiles, String[] passengers) {
        this.id = id;
        this.earnings = 0;
        this.numMiles = numMiles;
        this.passengers = passengers;

    }

    /** 2-args constructor.
     * @param id String representing the identifier for the vehicle
     * @param passengers Array of String representing the passengers aboard the vehicle
     */
    public Vehicle(String id, String[] passengers) {
        this(id, 0, passengers);
    }

    /** Test whether the vehicle can drive that far.
     * @param distance int representing the distance the vehicle want to go
     * @return boolean representing whether the vehicle can drive that far
     */
    public abstract boolean canDrive(int distance);

    /** Calculate the cost for travel the given distance.
     * @param distance int representing the distance the vehicle want to go
     * @return double representing cost for the vehicle to drive that far
     */
    public abstract double calculateCost(int distance);

    /** Test whether we can add these passengers to travel that far.
     * @param distance int representing the distance the vehicle want to go
     * @param newPassengers Array of String representing the passengers want to aboard the vehicle
     * @return boolean representing whether passengers can fit in the vehicle and the vehicle drive the given distance
     */
    public abstract boolean addPassenger(int distance, String[] newPassengers);

    /** Calculate and update the earning and number of miles of the vehicle.
     * @param distance int representing the distance the vehicle want to go
     */
    public void chargeRide(int distance) {
        if (canDrive(distance)) {
            this.earnings += this.calculateCost(distance);
            this.numMiles += distance;
        }
    }

    /** Indicate whether some other object is equal to this one.
     * @param o Object representing an object
     * @return boolean representing whether the other object is equal to this one
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Vehicle) {
            Vehicle v = (Vehicle) o;
            return this.id.equals(v.id) && (this.numMiles == v.numMiles);
        } else {
            return false;
        }
    }

    /** Gives a String indicating some information about this object.
     * @return String representing this object
     */
    public String toString() {
        return String.format("%s has driven %d miles and has earned %.2f dollars.", id, numMiles, earnings);
    }

    /** Getter for earnings.
     * @return double representing the total amount of money this vehicle earned
     */
    public double getEarnings() {
        return earnings;
    }

    /** Getter for numMiles.
     * @return int representing the number of miles the vehicle has travelled
     */
    public int getNumMiles() {
        return numMiles;
    }

    /** Setter for earnings.
     * @param earnings double representing the new total amount of money this vehicle earned
     */
    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    /** Setter for numMiles.
     * @param numMiles int representing the updated number of miles the vehicle has travelled
     */
    public void setNumMiles(int numMiles) {
        this.numMiles = numMiles;
    }
}
