public class Driver {
    public static void main(String[] args){
        GarageOwner garageOwner = new GarageOwner("Chuandong", 21);
        Car[] carCatalogue = new Car[2];
        Garage garage = new Garage(garageOwner, carCatalogue);
        Car car1 = new Car(1234, "nsd" , "x");
        Car car2 = new Car();
        Car car3 = new Car(1234, "nsd" , "x", "dark", 99);
        garage.addCar(1, car1);
        garage.addCar(1, car2);
        garage.addCar(0, car3);
        garage.sellCar(0);
        System.out.println(garage.getTheOwner().getCarsOwned());
        garage.showCertainCars(90);
    }
}
