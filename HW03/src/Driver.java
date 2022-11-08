/**
 * Define the Driver class.
 *
 * @author Cliu702
 * @version 1
 */
public class Driver {
    /** Test the other classes.
     *
     * @param args Array of String
     */
    public static void main(String[] args) {
        String[] passengers = new String[3];
        passengers[0] = "George";
        passengers[1] = "Mary";
        passengers[2] = "Tom";
        String[] newPassengers = new String[]{"Jimmy", "Doggy", "Alex"};
        Car car1 = new Car("Toyota", 20, 200);
        Car car2 = new Car("car2", 10, passengers, 0.8, 50.0, 100);
        System.out.println(car1.addPassenger(100, newPassengers));
        System.out.println(car2.addPassenger(70, newPassengers));
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car1.equals(car2));
        String[] newPassengers2 = new String[7];
        String[] newPassengers3 = new String[11];
        for (int i = 0; i < newPassengers2.length; i++) {
            newPassengers2[i] = "Edward";
        }
        for (int i = 0; i < newPassengers2.length; i++) {
            newPassengers2[i] = "Stan";
        }
        Bus bus1 = new Bus("Bus1", "Tech Square");
        Bus bus2 = new Bus("Bus2", 100, "Clough", 3);
        System.out.println(bus1.addPassenger(25, newPassengers));
        System.out.println(bus1.addPassenger(20, newPassengers2));
        System.out.println(bus1.addPassenger(10, newPassengers3));
        System.out.println(bus2.addPassenger(20, newPassengers3));
        System.out.println(bus1.toString());
        System.out.println(bus2.toString());
        System.out.println(bus1.equals(bus2));
        Bus bus4 = new Bus("Bus1", "Tech Square");
        Bus bus3 = new Bus("Bus1", "Tech Square");
        System.out.println(bus4.equals(bus3));
    }

}
