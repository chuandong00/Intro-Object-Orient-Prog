/**
 * Define the Bus class.
 *
 * @author Cliu702
 * @version 1
 */
public class Bus extends Vehicle {
    private String location;
    private int stopsPerMile;

    /**
     * 4-args constructor.
     *
     * @param id           String representing the identifier for the vehicle
     * @param numMiles     int representing the number of miles the vehicle has travelled
     * @param location     String representing the general area of the bus route
     * @param stopsPerMile int representing how many times a bus stops in one mile
     */
    public Bus(String id, int numMiles, String location, int stopsPerMile) {
        super(id, numMiles, new String[20]);
        this.location = location;
        this.stopsPerMile = stopsPerMile;
    }

    /**
     * 2-args constructor.
     *
     * @param id       String representing the identifier for the vehicle
     * @param location String representing the general area of the bus route
     */
    public Bus(String id, String location) {
        this(id, 0, location, 2);
    }

    /**
     * Test whether the bus can drive that far.
     *
     * @param distance int representing the distance the bus want to go
     * @return boolean representing whether the vehicle can drive that far
     */
    @Override
    public boolean canDrive(int distance) {
        return (distance >= 0);
    }

    /**
     * Calculate the cost for travel the given distance.
     *
     * @param distance int representing the distance the bus want to go
     * @return double representing cost for the vehicle to drive that far
     */
    @Override
    public double calculateCost(int distance) {
        if (this.canDrive(distance)) {
            return distance * 3.0 / stopsPerMile;
        } else {
            return -1;
        }
    }

    /**
     * Test whether we can add these passengers to travel that far.
     *
     * @param distance   int representing the distance the vehicle want to go
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
        if (this.canDrive(distance)) {
            int numOfPeople = 0;
            if (count >= passengers.length) {
                //All the passengers can get on the bus
                for (int i = 0; i < passengers.length; i++) {
                    for (int j = 0; j < this.passengers.length; j++) {
                        if (this.passengers[j] == null) {
                            this.passengers[j] = passengers[i];
                            break;
                        }
                    }
                }
                numOfPeople = passengers.length;
            } else {
                //Part of the passengers can get on the bus
                int position = 0;
                for (int i = 0; i < this.passengers.length; i++) {
                    if (this.passengers[i] == null) {
                        this.passengers[i] = passengers[position];
                        position++;
                    }
                }
                numOfPeople = position;
            }
            chargeRide(distance);
            setEarnings(getEarnings() + (numOfPeople - 1) * this.calculateCost(distance));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Indicate whether some other object is equal to this one.
     *
     * @param o Object representing an object
     * @return boolean representing whether the other object is equal to this one
     */
    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && o instanceof Bus) {
            Bus v = (Bus) o;
            return (this.location.equals(v.location)) && (this.stopsPerMile == v.stopsPerMile);
        } else {
            return false;
        }
    }

    /**
     * Gives a String indicating some information about this object.
     *
     * @return String representing this object
     */
    @Override
    public String toString() {
        return "Bus " + super.toString() + String.format(" This bus drives around %s and makes %d stops per mile.",
                location, stopsPerMile);
    }

    /**
     * Getter for location.
     *
     * @return String representing the general area of the bus route
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter for stopsPerMile.
     *
     * @return int representing how many times a bus stops in one mile
     */
    public int getStopsPerMile() {
        return stopsPerMile;
    }

    /**
     * Setter for location.
     *
     * @param location String representing the general area of the bus route
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Setter for stopsPerMile.
     *
     * @param stopsPerMile int representing how many times a bus stops in one mile
     */
    public void setStopsPerMile(int stopsPerMile) {
        this.stopsPerMile = stopsPerMile;
    }
}
