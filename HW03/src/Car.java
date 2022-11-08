/**
 * Define the Car class.
 *
 * @author Cliu702
 * @version 1
 */
public class Car extends Vehicle {
    private double rate;
    private double fees;
    private int maxNumMiles;

    /** 6-args constructor.
     * @param id String representing the identifier for the vehicle
     * @param numMiles int representing the number of miles the vehicle has travelled
     * @param passengers Array of String representing the passengers aboard the vehicle
     * @param rate double representing the price of using the car to go 1 mile
     * @param fees double representing the total fees to use the car once
     * @param maxNumMiles int representing the total number of miles that the car can drive before it is retired
     */
    public Car(String id, int numMiles, String[] passengers, double rate, double fees, int maxNumMiles) {
        super(id, numMiles, passengers);
        this.rate = rate;
        this.fees = fees;
        this.maxNumMiles = maxNumMiles;
    }

    /** 3-args constructor.
     * @param id String representing the identifier for the vehicle
     * @param numMiles int representing the number of miles the vehicle has travelled
     * @param maxNumMiles int representing the total number of miles that the car can drive before it is retired
     */
    public Car(String id, int numMiles, int maxNumMiles) {
        this(id, numMiles, new String[4], 10.0, 15.0, maxNumMiles);
    }

    /** 1-args constructor.
     * @param id String representing the identifier for the vehicle
     */
    public Car(String id) {
        this(id, 0, new String[4], 10.0, 15.0, 200);
    }

    /** Test whether the car can drive that far.
     * @param distance int representing the distance the car want to go
     * @return boolean representing whether the vehicle can drive that far
     */
    @Override
    public boolean canDrive(int distance) {
        return (distance >= 0) && (distance + this.numMiles <= this.maxNumMiles);
    }

    /** Calculate the cost for travel the given distance.
     * @param distance int representing the distance the car want to go
     * @return double representing cost for the vehicle to drive that far
     */
    @Override
    public double calculateCost(int distance) {
        if (this.canDrive(distance)) {
            return fees + rate * distance;
        } else {
            return -1;
        }
    }

    /** Test whether we can add these passengers to travel that far.
     * @param distance int representing the distance the car want to go
     * @param passengers Array of String representing the passengers want to aboard the vehicle
     * @return boolean representing whether passengers can fit in the vehicle and the vehicle drive the given distance
     */

    @Override
    public boolean addPassenger(int distance, String[] passengers) {
        int count = 0;
        for (int i = 0; i < this.passengers.length; i++) {
            if (this.passengers[i] == null) {
                count++;
            }
        }

        if ((count >= passengers.length) && this.canDrive(distance)) {
            for (int j = 0; j < passengers.length; j++) {
                for (int k = 0; k < this.passengers.length; k++) {
                    if (this.passengers[k] == null) {
                        this.passengers[k] = passengers[j];
                        break;
                    }
                }
            }
            chargeRide(distance);
            return true;
        } else {
            return false;
        }
    }

    /** Indicate whether some other object is equal to this one.
     * @param o Object representing an object
     * @return boolean representing whether the other object is equal to this one
     */
    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && o instanceof Car) {
            Car v = (Car) o;
            return (this.rate == v.rate) && (this.fees == v.fees) && (this.maxNumMiles == v.maxNumMiles);
        } else {
            return false;
        }
    }

    /** Gives a String indicating some information about this object.
     * @return String representing this object
     */
    @Override
    public String toString() {
        return "Car " + super.toString() + String.format(" It can only drive %d miles. It costs %.2f dollars per mile "
                + "and there is a one-time fee of %.2f dollars.", maxNumMiles, rate, fees);
    }

    /** Getter for fees.
     *
     * @return double representing the total fees to use the car once
     */
    public double getFees() {
        return fees;
    }

    /** Getter for rate.
     *
     * @return double representing the price of using the car to go 1 mile
     */
    public double getRate() {
        return rate;
    }

    /** Getter for maxNumMiles.
     *
     * @return int representing the total number of miles that the car can drive before it is retired
     */
    public int getMaxNumMiles() {
        return maxNumMiles;
    }

    /** Setter for fees.
     *
     * @param fees double representing the total fees to use the car once
     */
    public void setFees(double fees) {
        this.fees = fees;
    }

    /** Setter for rate.
     *
     * @param rate double representing the price of using the car to go 1 mile
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /** Setter for maxNumMiles.
     *
     * @param maxNumMiles int representing the total number of miles that the car can drive before it is retired
     */
    public void setMaxNumMiles(int maxNumMiles) {
        this.maxNumMiles = maxNumMiles;
    }
}
