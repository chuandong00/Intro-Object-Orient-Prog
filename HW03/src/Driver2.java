public class Driver2 {
    public static void main(String[] args) {
//id, numMiles, passengers, rate, fees, maxNumMiles
        String[] list = {"Owen", null, "Chloe", "Jack", null, null};
        Car c1 = new Car("CAR1", 50, list, 5.0, 25.50, 100);
        Car c2 = new Car("CAR2", 10, 100);
        Car c3 = new Car("CAR3");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println(c1.canDrive(50));
        System.out.println(c1.canDrive(51));
        System.out.println(c1.calculateCost(50));
        Car c4 = new Car("CAR1", 50, new String[6], 5.0, 25.50, 100);
        System.out.println(c1.equals(c4));

        //addPassenger for Car
        String[] a1 = {"Nathan", "Brian"};
        System.out.println(c1.addPassenger(25, a1));
        for (String str: c1.passengers) {
            System.out.print(str);
        }
        String[] a2 = {"ABC", "CBA"};
        System.out.println(c1.addPassenger(25, a2));
        for (String str: c1.passengers) {
            System.out.println(str);
        }
        System.out.println(c1.addPassenger(25, a2));
        System.out.println(c1.toString());

        System.out.println("------------------------");
        //--------------------------------BUS----------------
        // (String id, int numMiles, String location, int stopsPerMile)
        Bus b1 = new Bus("BUS1", 50, "Atlanta", 5);
        System.out.println(b1);
        System.out.println(b1.canDrive(100));
        System.out.println(b1.canDrive(101));
        Bus b2 = new Bus("BUS2", "Georgia");
        System.out.println(b1.equals(b2));
        System.out.println(b1);
//        //addPassenger
        String[] list2 = {"Owen", "Adam", "Chloe", "Jack", "Owen", "Jackie", "Tim", "Bob"};
        System.out.println(b1.addPassenger(25, list2));

        System.out.println(b1.addPassenger(25, list2));
        for (String str: b1.passengers) {
            System.out.print(str);
        }
        System.out.println("");
        System.out.println(b1);
        System.out.println(b1.addPassenger(25, list2));
        for (String str: b1.passengers) {
            System.out.print(str);
        }
        System.out.println("");
        System.out.println(b1.toString());

    }
}